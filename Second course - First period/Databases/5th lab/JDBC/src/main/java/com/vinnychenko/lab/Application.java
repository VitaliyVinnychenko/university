package com.vinnychenko.lab;

import java.sql.*;
import java.util.Scanner;


public class Application {
    private static final String url = "jdbc:mysql://localhost:3306/lab_5";
    private static final String user = "root";
    private static final String password = "";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            deletePharmacy();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver is not loaded");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
            }

            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
            }

            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    private static void readData() throws SQLException {
        rs = statement.executeQuery("SELECT * FROM street");

        System.out.format("\nTable Streets ------------------------------------------------------------\n");
        System.out.format("%3s %s\n", "id", "name");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.format("%3d %s\n", id, name);
        }


        rs = statement.executeQuery("SELECT * FROM medicines");

        System.out.format("\nTable Medicines ------------------------------------------------------------\n");
        System.out.format("%3s %-18s %-18s %-4s %s\n", "id", "name", "instruction", "number_in_pack", "packing");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String instruction = rs.getString("instruction");
            int numberInPack = rs.getInt("number_in_pack");
            String packing = rs.getString("packing");
            System.out.format("%3d %-18s %-18s %-4d %s\n", id, name, instruction, numberInPack, packing);
        }


        rs = statement.executeQuery("SELECT id, name, phone, owner_full_name, " +
                "(SELECT name FROM street WHERE id=P.street_id) AS street FROM pharmacy AS P");

        System.out.format("\nTable Pharmacies ------------------------------------------------------------\n");
        System.out.format("%3s %-15s %-18s %-35s %s\n", "id", "name", "phone", "owner_full_name", "street");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String ownerFullName = rs.getString("owner_full_name");
            String street = rs.getString("street");

            System.out.format("%3d %-15s %-18s %-35s %s\n", id, name, phone, ownerFullName, street);
        }


        String query = "SELECT (SELECT name FROM pharmacy WHERE id=PHM.pharmacy_id) AS pharmacy, " +
                "(SELECT name FROM medicines WHERE id=PHM.medicine_id) AS medicine, number_of_medicine " +
                "FROM pharmacy_has_medicines AS PHM";
        rs = statement.executeQuery(query);

        System.out.format("\nJoining Table Pharmacy Has Medicines --------------------\n");
        System.out.format("%-15s %-15s %s\n", "pharmacy", "medicine", "number");
        while (rs.next()) {
            String pharmacy = rs.getString("pharmacy");
            String medicine = rs.getString("medicine");
            int number = rs.getInt("number_of_medicine");
            System.out.format("%-15s %-15s %d\n", pharmacy, medicine, number);
        }

    }

    private static void updatePharmacy() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input name pharmacy what you want to update: ");
        String oldPharmacyName = input.next();
        System.out.println("Input new name pharmacy for %s: " + oldPharmacyName);
        String newPharmacyName = input.next();

        statement.execute("UPDATE pharmacy SET name='" + newPharmacyName + "' WHERE name='" + oldPharmacyName + "';");
    }

    private static void insertStreet() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a new street: ");
        String newStreet = input.next();

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("INSERT street (name) VALUES (?)");
        preparedStatement.setString(1, newStreet);
        int n = preparedStatement.executeUpdate();
        System.out.println("Count rows that inserted: " + n);

    }

    private static void deletePharmacy() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a name pharmacy for delete: ");
        String name = input.next();

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("DELETE FROM pharmacy WHERE name=?");
        preparedStatement.setString(1, name);
        int n = preparedStatement.executeUpdate();
        System.out.println("Count rows that deleted: " + n);
    }

    private static void callProcedureForInsertToPharmacy() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nInput name: ");
        String name = input.next();
        System.out.println("Input phone number: ");
        String phone = input.next();
        System.out.println("Input owner's full name: ");
        String ownerFullName = input.next();
        System.out.println("Input street: ");
        String street = input.next();

        CallableStatement callableStatement;
        callableStatement = connection.prepareCall("{call InsertPharmacy(?, ?, ?, ?)}");
        callableStatement.setString("name_in", name);
        callableStatement.setString("phone_in", phone);
        callableStatement.setString("owner_full_name_in", ownerFullName);
        callableStatement.setString("street_in", street);
        ResultSet rs = callableStatement.executeQuery();

        while (rs.next()) {
            String msg = rs.getString(1);
            System.out.format("\nResult: " + msg);
        }
    }

}
