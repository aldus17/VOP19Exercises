/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askUserForPrice;

import java.sql.*;
import java.util.Scanner;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 *
 * @author AleksanderSTUD
 */
public class Opg_931_a {

    private final String url = "jdbc:postgresql://localhost:5432/computerStore";
    private final String user = "admin";
    private final String password = "admin";

    public static void main(String[] args) {

        String query = "WITH Q1 AS ("
                + "     SELECT model,"
                + "            speed,"
                + "            abs(price - ?) AS diff"
                + "     FROM pc"
                + "     ),"
                + "         Q2  AS ("
                + "     SELECT MIN(diff) AS minimum"
                + "     FROM Q1"
                + "     ),"
                + "         Q3 AS ("
                + "     SELECT model,"
                + "            speed"
                + "     FROM Q1"
                + "     WHERE diff = (SELECT minimum from Q2)"
                + "     )"
                + " SELECT maker,"
                + "       model,"
                + "       speed "
                + " FROM Q3"
                + "      NATURAL JOIN product";
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print(
                    "Please type a price: ");
            int getUserPrice = scan.nextInt();
            Opg_931_a db = new Opg_931_a();

            db.connect();

            PreparedStatement ps = db.connect().prepareStatement(query);
            ps.setInt(1, getUserPrice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print("Maker: ");
                System.out.println(rs.getString(1));
                System.out.print("Model: ");
                System.out.println(rs.getString(2));
                System.out.print("Speed : ");
                System.out.println(rs.getString(3));
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {

        }

    }

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("NO CONNECTION");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
            System.out.println(ex.getMessage());
        }

        return conn;
    }

}
