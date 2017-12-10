<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>Flat Login & Register Forms A Flat Responsive Widget Template :: W3layouts</title>

    <!-- For-Mobile-Apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Flat Login & Register Forms Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //For-Mobile-Apps -->

    <!-- Style --> <link rel="stylesheet" href="css/style_login.css" type="text/css" media="all" />

    <!-- 网站字体我觉得会影响速度  就注释了  -->
    <%--<link href='//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800' rel='stylesheet' type='text/css'>--%>
    <%--<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>--%>
    <!-- //Web-Fonts -->

</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>请在此页面进行手机验证</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts">
        <form action="/verify" method="post">
            <label>手机号</label>
            <input type="text" name="rid" value="${rid}" style="visibility: hidden">
            <input type="text" class="user" id="shoujihao" name="mobile" value="" placeholder="您的手机号" required="true">
            <label>6位验证码</label>
            <input type="text" class="pass" name="code" id="yanzhengma" value="" placeholder="验证码" required="true">
            <ul>
                <li>

                 <input type="button" id="btnSendNum" onclick="getNum()" value="发送验证码">
                </li>
            </ul>

            <input type="submit" value="登录"></form>
        <div class="clear"></div>
    </div>
    <script src="js/jquery-2.1.4.min.js"></script>
    <!-- pop-up-box -->
    <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
    <script type="text/javascript">
        function getNum(){
            $.ajax({
                type: "POST",
                url: "ajaxNum",
                data: "phoneNum="+document.getElementById("shoujihao").value,
                success: function(msg){
                    document.getElementById("btnSendNum").value="已发送";
                }
            });
        }
        $(document).ready(function() {
            $('.popup-with-zoom-anim').magnificPopup({
                type: 'inline',
                fixedContentPos: false,
                fixedBgPos: true,
                overflowY: 'auto',
                closeBtnInside: true,
                preloader: false,
                midClick: true,
                removalDelay: 300,
                mainClass: 'my-mfp-zoom-in'
            });
        });
    </script>
    <div class="social agileits">
        <h5>或者使用其他账号验证</h5>
        <ul class="social-icons">
            <li><a href="#" class="facebook" title="Go to Our Facebook Page"></a></li>
            <li><a href="#" class="twitter" title="Go to Our Twitter Account"></a></li>
            <li><a href="#" class="googleplus" title="Go to Our Google Plus Account"></a></li>
        </ul>
        <div class="clear"></div>
    </div>

    <div class="reg w3l aits">
        <!--这里是 注册-->
        <h3>Not a member?</h3>
        <a class="popup-with-zoom-anim hvr-underline-from-left" href="#small-dialog">点击去注册</a>
        <div class="clear"></div>

        <!-- Popup-Box -->
        <div id="popup w3l">
            <div id="small-dialog" class="mfp-hide aits">
                <div class="pop_up agileits">
                    <div class="register w3layouts">
                        <form action="#" method="post">
                            <label>First Name</label>
                            <input type="text" Name="First Name" placeholder="First Name" required="">
                            <label>Last Name</label>
                            <input type="text" Name="Last Name" placeholder="Last Name" required="">
                            <label>Email</label>
                            <input type="text" Name="Email" placeholder="Email" required="">
                            <label>Password</label>
                            <input type="password" Name="Password" placeholder="Password" required="">
                            <label>Confirm Password</label>
                            <input type="password" Name="Password" class="lessgap" placeholder="Confirm Password" required="">
                            <label>Phone Number</label>
                            <input type="text" Name="Phone Number" placeholder="Phone Number" required="">
                            <div class="send-button">
                                <input type="submit" value="REGISTER">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <button title="Close (Esc)" type="button" class="mfp-close w3layouts">×</button>
        <!-- //Popup-Box -->

    </div>

</div>

<div class="footer">
    <p> &copy;2017 页面用于手机验证<a href="http://w3layouts.com" target="_blank">W3layouts</a></p>
</div>


<!--//pop-up-box -->
<!-- //Custom-JavaScript-File-Links -->

</body>
<!-- //Body -->

</html>