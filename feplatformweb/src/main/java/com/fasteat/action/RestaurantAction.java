package com.fasteat.action;

import com.alibaba.druid.support.json.JSONUtils;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fasteat.dto.RestDTO;
import com.fasteat.platformservice.RestaurantService;
import com.fasteat.server.key.AliAccessKey;
import com.fasteat.server.pojo.Restaurant;
import com.fasteat.server.util.CodeUtil;
import com.fasteat.server.util.FastDFSUtils;
import com.fasteat.server.util.RandomStringTLUtils;
import com.fasteat.server.util.SerializeUtil;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RestaurantAction {
    @Autowired
    private RestaurantService restaurantService;

    /*
    * 传入 店铺实体，生成二维码并传入图片服务器
    * 返回成功页面
    * */
    @RequestMapping("/rest_goadd")
    public String goAdd(){
        return "/rest_add";
    }
    @RequestMapping("/rest_reg")
    @ResponseBody
    public Map<String,Object>  regRest(Restaurant restaurant){
        int i = restaurantService.addRest(restaurant);
        //先保存，生成店铺ID
    //restaurant.setRid(id);
    //获取店铺ID
    try {
        String qrCode = CodeUtil.createQrCode(i);
        //生成二维码
        String s = FastDFSUtils.testFast(qrCode, "jpg");
        //上传至图片服务器，返回图片服务器的地址
        restaurant.setRcode(s);
        File file= new File(qrCode);
        file.delete();
        //设置商家二维码
        System.out.println(restaurant.getRcode());
        restaurantService.updateRest(restaurant);
        //把二维码添加至数据库
    } catch (WriterException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Map<String,Object> map= new HashMap<>();
    map.put("status",200);
    return map;
}
    @RequestMapping("/rest_goupdate")
    public String goupdate(){
         return "/rest_edit";
     }
    @RequestMapping("/rest_update")
    @ResponseBody
    public Map<String,Object> updateRest(Restaurant restaurant){
        //修改过的实体更新
        int i = restaurantService.updateRest(restaurant);
        if(i>0) {
            Map<String, Object> map = new HashMap<>();
        map.put("status",200);
        return map;
        }
return null;
    }
    @RequestMapping("/rest_showlist")
    @ResponseBody
    public RestDTO getRestList(Integer page,Integer rows){
        //查出所有使用该平台的店家
         RestDTO itemList = restaurantService.getAllRest(page,rows);
        System.out.println(itemList);
        //model.addAttribute("allRest",allRest);
        return itemList;


    }
    @RequestMapping("/rest_gologin.html")
    public String goLogin(){
        return "rest_login";
    }
    @RequestMapping("/rest_golist")
    public String goList(){
        return "rest_list";
    }

    @RequestMapping("/rest_del")
    @ResponseBody
    public Map<String,Object> delRest(Integer[] rid){
        //根据ID删除
        for (Integer integer : rid) {
            restaurantService.delRest(integer);
        }
        Map<String,Object> map= new HashMap<>();
        map.put("status",200);

        return map;
    }
    @RequestMapping("/rest_goplat")
    public String goPlat(){
        return "index";
    }

    @RequestMapping("/check.html")
    public void check(String rphone)throws Exception {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
//初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = AliAccessKey.accessKeyId;//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret =AliAccessKey.accessKeySecret;//你的accessKeySecret，参考本文档步骤2
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
        request.setPhoneNumbers(String.valueOf(rphone));
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("郭文博");
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_109390134");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        //生成验证码：
        String numeric = RandomStringTLUtils.randomNumeric(6);
        request.setTemplateParam("{\"code\":\""+numeric+"\"}");//动态传递验证码给手机
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("java1712");
//请求失败这里会抛ClientException异常
        Jedis jedis=new Jedis("120.78.184.134",6379);
        jedis.set(String.valueOf(rphone),numeric,"nx","ex",900);


        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        System.out.println(sendSmsResponse.getCode());
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功

           // redisService.set(phoneNum,numeric,300l);
            System.out.println(numeric);
        }}
        @RequestMapping("/rest_login")
    public String login(Long rphone, String code, HttpServletRequest request){

        Jedis jedis = new Jedis("120.78.184.134",6379);
            String s = jedis.get(String.valueOf(rphone));
            System.out.println(s);
            Restaurant restaurant = restaurantService.getRestByRphone(rphone);
            if(!code.equals(s)){
                return null;

            }
            if(restaurant==null){
               // model.addAttribute("msg","手机号不存在，请先<a href='/rest_goreg2.html'>注册</a>");
                request.getSession().setAttribute("msg","商店不存在，请先<a href='rest_goreg2.html'>注册</a>");
                return "rest_login";
            }
            //把二维码添加至数据库
            //调用serializeUtil序列化方法
            jedis.set("USER".getBytes(), SerializeUtil.serialize(restaurant));
            return "redirect:/rest_index.html";
        }
        @RequestMapping("/rest_goreg2.html")
        public String goReg2(){
        return "rest_reg";
        }


        @RequestMapping(value = "/check2.html" ,produces = "text/html;charset=UTF-8")
        @ResponseBody
        public String checkPhone(Long rphone){
            Restaurant rest = restaurantService.getRestByRphone(rphone);
            System.out.println(rphone);
            Map<String,Object> map = new HashMap<String,Object>();
            if(rest==null){
                map.put("msg","可以使用");
                map.put("status",true);
                String s = JSONUtils.toJSONString(map);
                return s;
            }
            map.put("msg","不可以使用");
            map.put("status",false);
            String s = JSONUtils.toJSONString(map);
            return s;
        }
        @RequestMapping("/rest_reg1")
    public String regResta(Restaurant restaurant){

            int i = restaurantService.addRest(restaurant);
                try {
                    String qrCode = CodeUtil.createQrCode(i);
                    //生成二维码
                    String s = FastDFSUtils.testFast(qrCode, "jpg");
                    //上传至图片服务器，返回图片服务器的地址
                    File f = new File(qrCode);
                    f.delete();
                    restaurant.setRcode(s);
                    //设置商家二维码
                    System.out.println(restaurant.getRcode());
                    restaurantService.updateRest(restaurant);
                    Jedis jedis = new Jedis("120.78.184.134",6379);
                   // request.getSession().setAttribute("USER",restaurant);
                    //把二维码添加至数据库
                    //调用serializeUtil序列化方法
                    jedis.set("USER".getBytes(), SerializeUtil.serialize(restaurant));
                } catch (WriterException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


             return "redirect:/rest_index.html";


        }
}
