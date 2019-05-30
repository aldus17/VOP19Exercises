/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexam2012.opg1_usernames;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author PCATG
 */
public class UserMap {

    public static void main(String[] args) {
        Map<String, User> userMap = userMap = new HashMap<>();
        String fullName;
        String firstName;
        String lastName;
        User user = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fullname:");
        do {

            fullName = sc.nextLine();
            user = new User(fullName);
            userMap.put(user.makeUserName(), user);

        } while (!sc.nextLine().equalsIgnoreCase(" "));
        System.out.println(userMap);

    }
}
