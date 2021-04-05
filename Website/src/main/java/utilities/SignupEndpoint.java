package utilities;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import managers.DatabaseManager;
import models.orm.User;
import providers.repositories.UserRepo;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ServerEndpoint("/echo")
public class SignupEndpoint {
    private final static Set<Session> vector = new HashSet<>();
    @OnOpen
    public void onOpen(Session session){
            //session.getBasicRemote().sendText("connectionEstablished");
            vector.add(session);
    }

    @OnMessage
    public void onMessage(String msg , Session session){
        try {
            var db = DatabaseManager.getInstance();
            db.beginSession();

            UserRepo userRepo = UserRepo.getInstance();
            Optional<User> user = userRepo.findByEmail(msg);
            if (Validator.getInstance().EmailValidation(msg) == true){
                if (user.isPresent()){
                    session.getBasicRemote().sendText("This Email is Already Registered");
                }
                else {
                    session.getBasicRemote().sendText("");
                }
            }else{
                session.getBasicRemote().sendText("Please Enter a Valid Form of an Email");
            }

            db.endSession();

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
