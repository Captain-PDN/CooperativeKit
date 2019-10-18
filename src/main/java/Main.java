import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JDBC jdbc = context.getBean("jdbc",JDBC.class);

//        //Register user;
//        User user = new User("0000000002", "username2", "password2", "FirstName2", "LastName2", "0847410001", "Address2", "test2@gmail.com", "1249800110690", "photo2", new Date("05/12/1998"), false, "type", "Female");
//        jdbc.userRegister(user);
//
//        //Get all user
//        List<User> users = jdbc.getAllUser();
//        for (User u :users) {
//            System.out.println(u.getIduser());
//        }
//
//        //wait for fix
//        User UpdateUser = new User("0000000001", "username", "password", "FirstName", "LastName", "0847410000", "Address", "test@gmail.com", "1249800110689", "photo", , true, "type", "Male");
//        jdbc.updateUserProfile(UpdateUser, UpdateUser.getIduser());
//
//        //login
//        if (jdbc.signIn("username", "password"))
//            System.out.println("pass");
//        else
//            System.out.println("not pass");
//
//        //create log
//        jdbc.createHistoryLog("0000000001", "test history log2");
//
//        //get user log
//        List<History> userHistory = jdbc.getUserHistory("0000000001");
//        for (History his : userHistory) {
//            System.out.println(his.getIdUser() + "     " + his.getDate() + "     " + his.getTime() + "     " + his.getLog());
//        }
//
//        //create chat between two people
//        jdbc.createChatLog("0000000001", "0000000002", "test chat log");
//        jdbc.createChatLog("0000000001", "0000000002", "test chat log2");
//
//        //delete chat between two people
//        jdbc.deleteChat("0000000001", "0000000002", "test chat log");
//
//        //get all chat between two people
//        List<Chat> chats = jdbc.getUserChat("0000000001", "0000000002");
//        for (Chat c : chats) {
//            System.out.println(c.getIdUser() + "     " + c.getIduserOther() + "     " + c.getDate() + "     " + c.getTime() + "     " + c.getChatlog());
//        }





    }

}
