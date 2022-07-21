package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add(new User("Jmih", "Pojiloy", "denis@gvs.ru", new Car("Lada Niva", 2101)));
      userService.add(new User("Vladimir", "Nonamed", "vovan@krel.ru", new Car("Lada Niva", 2114)));
      userService.add(new User("Abobus", "Spacees", "aboba@space.com", new Car("Spaceship", 13)));
      userService.add(new User("Tolya", "Tolyanov", "tolya@formus.ru", new Car("Lambo Corch", 148)));

      //Все пользователи
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      //Поиск по машине
      System.out.println(userService.getUserByCar("Lada Niva", 2114));

      context.close();
   }
}
