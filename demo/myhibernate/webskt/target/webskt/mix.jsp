<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8">
</head>
<body>

欢迎来到聊天室
<input id="text" type="text">
<button onclick="send()">发送消息</button>
<hr/>
<button onclick="closeWebSocket()">退出聊天室</button>
<hr/>
<div id="msg"></div>
</body>
<script type="javascript">
    var webSocket = null;
    if( "Websocket" in window){
        webSocket = new WebSocket('ws://localhost:8080/websocket');
    }else {
        alert('当前浏览器不支持websocket')
    }

    //连接发生错误的回调方法
    webSocket.onerror = function(){
        setMessageOn('发生错误');
    }
    //接收到消息的回调方法
    webSocket.onmessage =function(event){
        setMessageOn(event.data);
    }
    //连接成功建立的回调方法
    webSocket.onopen = function () {
        setMessageOn('连接成功');
    }
    //接收到消息的回调方法
    webSocket.onclose = function () {
        setMessageOn('连接关闭');
    }

    //发送消息
    function send() {
        webSocket.send(document.getElementById('text').value);
    }
    //将消息显示在网页上
    function setMessageOn(innerHtml) {
        document.getElementById('msg').innerHTML += innerHtml +'<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        webSocket.close();
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常
    window.onbeforeunload = function () {
        closeWebSocket();
    }
</script>
</html>
