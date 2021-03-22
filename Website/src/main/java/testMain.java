import managers.DatabaseManager;
import models.orm.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;
import providers.repositories.*;

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


        CategoryRepo categoryRepo = CategoryRepo.getInstance();
//        var cats = categoryRepo.findByName("category1");
//        System.out.println("cats.size() = " + cats.size());
//        System.out.println("cats = " + cats);

//        for (int i = 1; i < 5; i++) {
//            categoryRepo.create(new Category("category" + i));
//        }

        ProductRepo productRepo = ProductRepo.getInstance();
        var products = productRepo.readAll();
        for (var product : products) {
            product.setDiscountPercent((int) (product.getCategory().getCategoryId() * 5));
        }
//        productRepo.create(new Product("product" + 21,
//                21 * 100,
//                "description" + 21,
//                21 * 5,
//                "images/product/men/product6.jpg",
//                categoryRepo.findByName("category5").get()));
//        for (int i = 1; i < 21; i++) {
//            productRepo.create(new Product("product" + i,
//                    i * 100,
//                    "description" + i,
//                    i * 5,
//                    "images/product/men/product6.jpg"));
//        }
//        var list = productRepo.findLikeName("product1");
//        var list = productRepo.findByCategory(categoryRepo.read(1L).get());
//        var list = productRepo.findByPriceRange(100, 500);
//        var list = productRepo.findByCategoryPriceName(categoryRepo.read(1L).get(), 100, 500, "product1");
//        var cat = categoryRepo.findByName("category1").get();
//        System.out.println("cat = " + cat);
//        var list = productRepo.findByCategoryPriceName(cat, 100, 500, "product1");
//        System.out.println("list.size() = " + list.size());
//        System.out.println("list = " + list);

//        ProductRepo productRepo = ProductRepo.getInstance();
//        for (long i = 1; i < 21; i++) {
//            var productO = productRepo.read(i);
//            if (productO.isPresent()) {
//                var product = productO.get();
//                product.setCategory(categoryRepo.read(i / 5 + 1).get());
//                productRepo.update(product);
//            }
//        }

        db.endTransaction();
    }

}
