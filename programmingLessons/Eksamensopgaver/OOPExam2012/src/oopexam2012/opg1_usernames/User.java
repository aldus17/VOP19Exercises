package oopexam2012.opg1_usernames;

import java.util.Date;

public class User {

    private String fullName;
    private Date createdAt;

    public User(String name) {
        this.fullName = name;
        this.createdAt = new Date();

    }

    @Override
    public String toString() {
        return "User: " + this.fullName + " - " + this.createdAt;
    }

    // Opg. 1b
    public String makeUserName() {

        int start = fullName.indexOf(' ');
        int end = fullName.lastIndexOf(' ');

        String firstName = "";
        String middleName = "";
        String lastName = "";
        String userName = "";

        if (start >= 0) {
            firstName = fullName.substring(0, start).toLowerCase();

            if (end > start) {
                middleName = fullName.substring(start + 1, end);
            }
            lastName = fullName.substring(end + 1, fullName.length()).toLowerCase();

        }

        if (firstName.length() <= 2 || lastName.length() < 3) {
            userName += firstName + lastName;
            return userName.toLowerCase();
        } else {
            userName += firstName.substring(0, 2) + lastName.substring(0, 3);
        }

        userName = userName.replace("æ", "ae");
        userName = userName.replace("ø", "oe");
        userName = userName.replace("å", "aa");

        return userName.toLowerCase();
    }

    public static void main(String[] arg) {

        // Til test af opg. 1a
        User user1 = new User("Joachim Holger Waldemar Christian");
        System.out.println(user1);

        User user2 = new User("Ib Bo");
        System.out.println(user2);

        User user3 = new User("Åge Bøgeskov");
        System.out.println(user3);

        User user4 = new User("Ib Poulsen");
        System.out.println(user4);

        User user5 = new User("Iben Bo");
        System.out.println(user5);
        // Til test af opg. 1b 
        System.out.println(user1.makeUserName());
        System.out.println(user2.makeUserName());
        System.out.println(user3.makeUserName());
        System.out.println(user4.makeUserName());
        System.out.println(user5.makeUserName());
    }
}
