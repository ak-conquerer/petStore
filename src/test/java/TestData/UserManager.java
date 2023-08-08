package TestData;

import POJO.Request.UserArray;

import java.util.ArrayList;

public class UserManager {

    public static ArrayList<UserArray> createUserArray()
    {

        ArrayList<UserArray> arrayListUser = new ArrayList<UserArray>();


        UserArray user = new UserArray();

        user.setFirstName("Fuser1");
        user.setLastName("LUser1");
        user.setEmail("user1@abc.com");
        user.setUserStatus(0);
        user.setPhone("111111");
        user.setPassword("abcd");
        user.setUsername("user001");
        user.setId(00010);


        UserArray user1 = new UserArray();

        user1.setFirstName("FUser2");
        user1.setLastName("LUser2");
        user1.setEmail("user2@abc.com");
        user1.setUserStatus(0);
        user1.setPhone("2222222");
        user1.setPassword("abcd");
        user1.setUsername("user002");
        user1.setId(00020);

        UserArray user2 = new UserArray();

        user2.setFirstName("FUser3");
        user2.setLastName("LUser3");
        user2.setEmail("user3@abc.com");
        user2.setUserStatus(0);
        user2.setPhone("333333");
        user2.setPassword("abcd");
        user2.setUsername("user003");
        user2.setId(000030);

        arrayListUser.add(user);
        arrayListUser.add(user1);
        arrayListUser.add(user2);

        return arrayListUser;
    }
}
