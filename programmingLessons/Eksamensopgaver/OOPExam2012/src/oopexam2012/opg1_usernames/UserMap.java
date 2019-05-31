package oopexam2012.opg1_usernames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMap {

    public static void main(String[] args) {
        Map<String, User> userMap = userMap = new HashMap<>();
        List<String> names = new ArrayList<>();

        System.out.println("Enter fullname:");
        Scanner input = new Scanner(System.in);
        do {

            String x = input.nextLine();

            if (x == null || x.isEmpty()) {
                break;
            } else {
                names.add(x);
            }

        } while (true);
        for (String name : names) {
            User user = new User(name);

            userMap.put(user.makeUserName(), user);

        }
        int count = 1;
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
            String key = entry.getKey();
            User value = entry.getValue();
            if (key.contains(entry.getKey()) && value.equals(entry.getValue())) {
                String replace = entry.getKey().replace(entry.getKey(), entry.getKey() + count);
                userMap.put(replace, entry.getValue());
                count++;
            }

        }
        System.out.println(userMap);

    }
}
