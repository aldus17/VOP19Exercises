/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumValuesOfSpecsInLaptops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author AleksanderSTUD
 */
public class Opg_931_b {

    private final String url = "jdbc:postgresql://localhost:5432/computerStore";
    private final String user = "admin";
    private final String password = "admin";

    public static void main(String[] args) {

        String query = "WITH R1 AS ("
                + " SELECT * "
                + "    FROM laptop "
                + " WHERE speed >= ?"
                + "    AND ram >= ?"
                + "    AND hd >= ?"
                + "    AND screen >= ?"
                + " ),"
                + "     R2 AS ("
                + " SELECT model,"
                + "        maker "
                + "    FROM product"
                + " ) "
                + "SELECT * "
                + "FROM R1 "
                + "NATURAL JOIN R2 ";

        String sql1 = "SELECT laptop.model, speed, ram, hd, price, product.maker "
                + "FROM laptop, product"
                + "WHERE laptop.model = product.model " + "AND" + "speed >=?" + " AND"
                + "ram >=?" + " AND"
                + "hd >=?" + " AND"
                + "screen >=?";

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Please type a speed: ");

            String getUserSpeed = String.valueOf(scan.nextDouble());
            System.out.print("Please type a Ram: ");
            String getUserRam = String.valueOf(scan.nextInt());
            System.out.print("Please type a HDD: ");
            String getUserHD = String.valueOf(scan.nextInt());
            System.out.print("Please type a Screen Size: ");
            String getUserScreen = String.valueOf(scan.nextDouble());

            Opg_931_b db = new Opg_931_b();

            db.connect();

            PreparedStatement ps = db.connect().prepareStatement(sql1);
            ps.setString(1, getUserSpeed);
            ps.setString(2, getUserRam);
            ps.setString(3, getUserHD);
            ps.setString(4, getUserScreen);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                

                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));

//                System.out.println("Model: " + rs.getString(1));
//                System.out.print("Speed: ");
//                System.out.println(rs.getInt(2));
//                System.out.print("Ram: ");
//                System.out.println(rs.getInt(3));
//                System.out.print("HDD: ");
//                System.out.println(rs.getInt(4));
//                System.out.print("Screen Size: ");
//                System.out.println(rs.getDouble(5));
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
