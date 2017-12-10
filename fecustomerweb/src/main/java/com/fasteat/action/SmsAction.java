package com.fasteat.action;



import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fasteat.server.key.AliAccessKey;
import com.fasteat.server.util.RandomStringTLUtils;
import com.fasteat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Thanks for Everything.
 */
@Controller
public class SmsAction {
	@Autowired
	private RedisService redisService;

	//显示页面
	@RequestMapping("/restaurant")
	public String login(Model model,Integer rid){

		model.addAttribute("rid",rid);
		return "mtlogin";//返回模板页面的地址,不要加jsp
	}

	@RequestMapping("/ajaxNum")
	@ResponseBody
	public String sendMsg(String phoneNum) throws ClientException {
		//设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//初始化ascClient需要的几个参数
		final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
		//替换成你的AK
		final String accessKeyId = AliAccessKey.accessKeyId;//你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = AliAccessKey.accessKeySecret;//你的accessKeySecret，参考本文档步骤2
//初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
				accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		IAcsClient acsClient = new DefaultAcsClient(profile);
		//组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		//使用post提交
		request.setMethod(MethodType.POST);
		//必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		request.setPhoneNumbers(phoneNum);
		//必填:短信签名-可在短信控制台中找到
		request.setSignName("吕自政");
		//必填:短信模板-可在短信控制台中找到SMS_101125003SMS_109440168
		request.setTemplateCode("SMS_101125003");
		//可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		//友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		//生成验证码：
		String numeric = RandomStringTLUtils.randomNumeric(6);
		//动态传递验证码给手机
		request.setTemplateParam("{\"code\":\""+numeric+"\"}");
		//可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		//request.setSmsUpExtendCode("90997");
		//可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		//request.setOutId("java1712");
//请求失败这里会抛ClientException异常
//		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
//		if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//			//请求成功
//			return numeric;
//		}
		//假设发送成功了,判断缓存中手机号是否存在,存在即没有到达可以发送验证码的事件

		String str = redisService.get("send"+phoneNum);
		System.out.println(str);
		if(str==null) {
			//记录手机号发送短信次数
			Long count = redisService.incr(phoneNum + "_count");
			System.out.println(count);
			//当发送3次以上
			if (count > 3) {
				redisService.set("send"+phoneNum, "验证码发送上限制");
				redisService.expire("send"+phoneNum,60*24*60);
				redisService.del(phoneNum + "_count");
				Long ttl = redisService.ttl(phoneNum);
				return "手机已达到验证上限,请\"+ttl+\"秒后再来";
			}
			redisService.set(phoneNum,numeric);
			redisService.expire(phoneNum,300);
			System.out.println(numeric);
			return "请填写6位验证码";
		}else{
			Long ttl = redisService.ttl("send"+phoneNum);

			return "手机已达到验证上限,请\"+ttl+\"秒后再来";
		}



	}
}
