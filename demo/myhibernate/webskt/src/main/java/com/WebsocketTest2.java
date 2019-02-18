package com;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket")
public class WebsocketTest2 {

    //记录在线人数
    private static int onlineNum = 0;

    private static CopyOnWriteArraySet<WebsocketTest2> websocketTest = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){
        this.session =session;
        websocketTest.add(this);
        addOnlineNum();
        System.out.println("有新连接加入！当前在线人数："+getOnlineNum());
    }

    @OnClose
    public void OnClose(){
        websocketTest.remove(this);
        subOnlineNum();
        System.out.println("有一个连接退出，当前在线人数："+getOnlineNum());
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("收到客户端消息:"+message);
        for (WebsocketTest2 websocketTest2 : websocketTest) {
            try {
                websocketTest2.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session,Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }


    public void sendMessage(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    public static synchronized void addOnlineNum(){
        onlineNum++;
    }
    public static synchronized void subOnlineNum(){
        onlineNum--;
    }
    public static synchronized int getOnlineNum(){
        return onlineNum;
    }

}
