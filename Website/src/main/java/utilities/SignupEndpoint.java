package utilities;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.*;

@ServerEndpoint("/echo")
public class SignupEndpoint {
    private final static Set<Session> vector = new HashSet<>();
    @OnOpen
    public void onOpen(Session session){
        try {
            session.getBasicRemote().sendText("connectionEstablished");
            vector.add(session);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String msg , Session session){
        try {
            if (msg == "dalia.elzohairy.de@gmail.com"){
                session.getBasicRemote().sendText(" ");
            }else {
                session.getBasicRemote().sendText("This Email is Already Registered");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        vector.remove(session);
        System.out.println("closed"+ session.getId());
    }
}
