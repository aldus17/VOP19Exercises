package oopexam2012.opg1_usernames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserMap {

    public static void main(String[] args) {
        Map<String, User> userMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter full name:");
        String fullName = sc.nextLine();
        while (!fullName.equalsIgnoreCase("")) {
            User user = new User(fullName);
            String userName = user.makeUserName();

            int count = 0;
 
            while (userMap.containsKey(count == 0 ? userName : userName + count)) {               
                count++;          
            }        
            if (count > 0) {              
                userName += count;             
            }
 
            userMap.put(userName, user);
            fullName = sc.nextLine();

        }
        System.out.println(userMap);
    }
}
