import managers.DatabaseManager;
import models.orm.FakeCreditCard;
import models.orm.Product;
import models.orm.ScratchCard;
import models.orm.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;
import providers.repositories.FakeCreditCardRepo;
import providers.repositories.ScratchCardRepo;
import providers.repositories.UserRepo;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class testMain {
    static Logger log = Logger.getLogger(testMain.class.getName());


    public static void main(String[] args) throws SQLException {
        var db = DatabaseManager.getInstance();
        db.beginTransaction();

//        session.save(user);
//        System.out.println("user = " + user);
//        Query q = session.createQuery("from User");
//        List<User> users = q.list();
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }

//        var userRepo = UserRepo.getInstance();
//        User user = new User();
//        user.setEmail("tester");
//        user.setUserName("tester");
//        user.setPassword("tester");
//        userRepo.create(user);
//        System.out.println("user = " + userRepo.read(user.getUserId()));

//        for (User user : userRepo.readAll()) {
//            System.out.println("user = " + user);
//        }

        //        System.out.println("user = " + userRepo.read(user.getUserId()));


//        ScratchCardRepo scratchCardRepo = ScratchCardRepo.getInstance();
//        scratchCardRepo.create(new ScratchCard("SUPER102", 100));
//        var scratchCard = scratchCardRepo.findValidCard("SUPER102");
//        System.out.println("scratchCard = " + scratchCard);
//        System.out.println("scratchCardRepo.use(scratchCard.get()) = " + scratchCardRepo.use(scratchCard.get()));
//        System.out.println("scratchCard = " + scratchCard);

//        FakeCreditCardRepo fakeCreditCardRepo = FakeCreditCardRepo.getInstance();
////        fakeCreditCardRepo.create(new FakeCreditCard("123", "123", Date.valueOf(LocalDate.now().plusDays(1)), 100));
//        var card = fakeCreditCardRepo.findValidCard("123", "123", Date.valueOf(LocalDate.now().plusDays(1)));
//        System.out.println("card = " + card);
//        System.out.println("fakeCreditCardRepo.charge(card.get(), 5) = " + fakeCreditCardRepo.charge(card.get(), 5));
//        System.out.println("card = " + card);

        db.endTransaction();
    }

}
