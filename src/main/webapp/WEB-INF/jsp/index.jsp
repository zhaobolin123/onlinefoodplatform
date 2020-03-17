<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/5
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="test()">发送</button>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script>
function test() {
    var data={"user_phone":"132465",
        "user_password":"123456798"};
    $.ajax({
        type:'post',
        url:"http://localhost:8080/regist",
        data:data,
        contentType: 'application/x-www-form-urlencoded',
        //contentType:"application/json;charset=utf-8",
        success:function(msg){
            alert(msg)
        }
    });
}

</script>
</html>
