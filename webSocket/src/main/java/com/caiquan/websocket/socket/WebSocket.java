package com.caiquan.websocket.socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;


@Component
@ServerEndpoint("/webSocket/{page}")
public class WebSocket {
    private Logger log = LoggerFactory.getLogger(this.getClass());



    /**
     * 用来记录房间及人数
     */
    private static Map<String,Set<Session>> roomMap = new ConcurrentHashMap(8);

    /**
     *
     *
     * @param page 房间号
     * @param session
     * @return
     * @author  CarpCap
     * @date 2022/2/11 13:46
     */
    @OnOpen
    public void open(@PathParam("page") String page, Session session) throws IOException {
        Set<Session> set = roomMap.get(page);
        // 如果是新的房间，则创建一个映射，如果房间已存在，则把用户放进去
        if(set == null){
            set = new CopyOnWriteArraySet();
            set.add(session);
            roomMap.put(page,set);
        }else{
            set.add(session);
        }


        // 给房间内所有用户推送信息
        for(Session s : set){
            s.getBasicRemote().sendText("新用户{"+session.getId()+"}进入聊天,房间人数:{"+set.size()+"}");
        }

    }

    @OnClose
    public void close(@PathParam("page") String page, Session session) {
        // 如果某个用户离开了，就移除相应的信息
        if(roomMap.containsKey(page)){
            roomMap.get(page).remove(session);
        }

        // 给房间内所有用户推送信息
        for(Session s : roomMap.get(page)){
            try {
                s.getBasicRemote().sendText("用户{"+session.getId()+"}退出聊天,房间人数:{"+roomMap.get(page).size()+"}");
            }catch (IllegalStateException | IOException e){

            }
        }
    }

    @OnMessage
    public void reveiveMessage(@PathParam("page") String page, Session session,String message) throws IOException {
        log.info("接受到用户{}的数据:{}",session.getId(),message);
        // 拼接一下用户信息
        String msg = "用户"+session.getId()+"   : "+ message;
        Set<Session> sessions = roomMap.get(page);
        // 给房间内所有用户推送信息
        for(Session s : sessions){
            s.getBasicRemote().sendText(msg);
        }
    }

    @OnError
    public void error(Throwable throwable){
        try {
            throw throwable;
        } catch (Throwable e) {
            log.error("未知错误");
        }
    }
}