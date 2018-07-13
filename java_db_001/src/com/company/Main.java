package com.company;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Connection conn;

    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/citizens"
                        + "?useSSL=false"
                        + "&useLegacyDatetimeCode=false"
                        + "&amp"
                        + "&serverTimezone=UTC";
        String username = "root";
        String password = "password";

        conn = DriverManager.getConnection(dbURL, username, password);

        Scanner sc = new Scanner(System.in);

        initMenu();

        int choice;
        do {
           System.out.print("Enter choice: ");
           choice = sc.nextInt();
           switch(choice){
               case 1:
                   addCountry();
                   break;
               case 2:
                   addCity();
                   break;
               case 3:
                   addPerson();
                   break;
               case 4:
                   selectPersons();
                   break;
               case 5:
                   selectPerson();
                   break;
               case 6:
                   selectCity();
                   break;
               case 7:
                   selectCountry();
                   break;
               case 8:
                   selectPersonsByCity();
                   break;
               case 9:
                   selectCitiesByCountry();
                   break;
               case 10:
                   selectPersonCityCountry();
                   break;
               case 11:
                   fillRandom();
                   break;
               case 12:
                   updatePerson();
                   break;
               default:
                   break;
           }
        } while(choice != 13);

        conn.close();
        sc.close();
    }

    private static void initMenu() {
        System.out.println("1 - Add country");
        System.out.println("2 - Add city");
        System.out.println("3 - Add person");
        System.out.println("4 - Select all persons");
        System.out.println("5 - Select person by ID");
        System.out.println("6 - Select city by ID");
        System.out.println("7 - Select country by ID");
        System.out.println("8 - Select persons by city ID");
        System.out.println("9 - Select cities by country ID");
        System.out.println("10 - Select person with city and country");
        System.out.println("11 - Fill with random data");
        System.out.println("12 - Update person by ID");
        System.out.println("13 - Exit");
    }

    private static void addCountry() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter country name: ");
        String name = sc.next();

        sc.close();

        String query = "INSERT INTO country(name) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void addCity() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter city name: ");
        String name = sc.next();

        System.out.print("Enter country id: ");
        int country_id = sc.nextInt();

        sc.close();

        String query = "INSERT INTO city(name, country_id) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setInt(2, country_id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void addPerson() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter firstname: ");
        String firstname = sc.next();

        System.out.print("Enter lastname: ");
        String lastname = sc.next();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter hobby: ");
        String hobby = sc.next();

        System.out.print("Enter city id: ");
        int city_id = sc.nextInt();

        sc.close();

        String query = "INSERT INTO person(firstname, lastname, age, hobby, city_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, firstname);
        pstmt.setString(2, lastname);
        pstmt.setInt(3, age);
        pstmt.setString(4, hobby);
        pstmt.setInt(5, city_id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void selectPersons() throws SQLException {
        String query = "SELECT p.* FROM person p;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                        + rs.getString("firstname") + "\t| "
                        + rs.getString("lastname") + "\t| "
                        + rs.getInt("age") + "\t| "
                        + (rs.getString("hobby").isEmpty() ? "No" : rs.getString("hobby")));
        }

        rs.close();
        stmt.close();
    }

    private static void selectPerson() throws SQLException {
        String query = "SELECT * FROM person WHERE id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person id: ");
        int id = sc.nextInt();
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                    + rs.getString("firstname") + "\t| "
                    + rs.getString("lastname") + "\t| "
                    + rs.getInt("age") + "\t| "
                    + (rs.getString("hobby").isEmpty() ? "No" : rs.getString("hobby")));
        }

        rs.close();
        pstmt.close();
        sc.close();
    }

    private static void selectCity() throws SQLException {
        String query = "SELECT * FROM city WHERE id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city id: ");
        int id = sc.nextInt();

        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                    + rs.getString("name"));
        }

        rs.close();
        pstmt.close();
        sc.close();
    }

    private static void selectCountry() throws SQLException {
        String query = "SELECT * FROM country WHERE id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter country id: ");
        int id = sc.nextInt();

        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                    + rs.getString("name"));
        }

        rs.close();
        pstmt.close();
        sc.close();
    }

    private static void selectPersonsByCity() throws SQLException {
        String query = "SELECT p.id, p.firstname, p.lastname, p.age, p.hobby, ct.name FROM person p JOIN city ct ON p.city_id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city id: ");
        int id = sc.nextInt();
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                    + rs.getString("firstname") + "\t| "
                    + rs.getString("lastname") + "\t| "
                    + rs.getInt("age") + "\t| "
                    + (rs.getString("hobby").isEmpty() ? "No" : rs.getString("hobby")) + "\t| "
                    + rs.getString("name"));
        }

        rs.close();
        pstmt.close();
        sc.close();
    }

    private static void selectCitiesByCountry() throws SQLException {
        String query = "SELECT ct.id, ct.name, c.name AS country_name FROM city ct JOIN country c ON ct.country_id = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter country id: ");
        int id = sc.nextInt();
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                    + rs.getString("name") + "\t| "
                    + rs.getString("country_name"));
        }

        rs.close();
        pstmt.close();
        sc.close();
    }

    private static void selectPersonCityCountry() throws SQLException {
        String query = "SELECT p.id, p.firstname, p.lastname, p.age, p.hobby, ct.name, c.name AS country_name  FROM person p " +
                "JOIN city ct ON p.id = ? JOIN country c ON ct.country_id = c.id;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person id: ");
        int id = sc.nextInt();

        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t| "
                    + rs.getString("firstname") + "\t| "
                    + rs.getString("lastname") + "\t| "
                    + rs.getInt("age") + "\t| "
                    + (rs.getString("hobby").isEmpty() ? "No" : rs.getString("hobby")) + "\t| "
                    + rs.getString("name") + "\t| "
                    + rs.getString("country_name"));
        }

        rs.close();
        pstmt.close();
        sc.close();
    }

    private static void fillRandom() throws SQLException {
        Random random = new Random();
        String[] firstnames = {"Maksym", "Anastasia", "Artem", "Anna", "Oleksandr", "Sofia", "Nazar", "Diana", "William", "Emma",
                "James", "Olivia", "John", "Elizabeth", "Noah", "Amelia", "Francesco", "Aurora", "Alessandro", "Alice",
                "Leonardo", "Beatrice", "Lorenzo", "Alessia", "Haruto", "Rin", "Sora", "Kei", "Yuki", "Koharu", "Ren", "Kokoro"};
        String[] lastnames = {"Smith", "Williams", "Johnson", "Jones", "Brown", "Espocito", "Costa", "Romano", "Alfonsi", "Pavlyuk", "Melnik",
                "Loboda", "Kovalchuk", "Doroshenko", "Sasaki", "Suzuki", "Nakamura", "Kobayashi", "Yamamoto"};
        String[] hobbies = {"Acting", "Dancing", "Singing", "Coloring", "Baking", "Calligraphy", "Acrobatics", "Drawing", "Whittling", "Lapidary",
                "Cosplaying", "Archery", "Shooting", "Surfing", "Blacksmithing", "Driving", "Hiking", "Rugby", "Travel", "Curling", "Fishing",
                "Golfing", "Cycling", "Lacrosse", "Reading", "Chess", "Go", "Marbles", "Poker", "Wrestling"};
        String query = "INSERT INTO person(firstname, lastname, age, hobby, city_id) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        String query2 = "SELECT COUNT(ct.id) AS amount FROM city ct;";
        PreparedStatement pstmt2 = conn.prepareStatement(query2);
        ResultSet rs = pstmt2.executeQuery();
        rs.next();
        int amount = rs.getInt("amount");
        query2 = "SELECT COUNT(p.id) AS amount FROM person p;";
        pstmt2 = conn.prepareStatement(query2);
        rs = pstmt2.executeQuery();
        rs.next();
        if(rs.getInt("amount") == 0) {
            query2 = "ALTER TABLE person AUTO_INCREMENT = 1;";
            Statement stmt = conn.createStatement();
            stmt.execute(query2);
            stmt.close();
        }
        rs.close();
        pstmt2.close();
        for(int i = 0; i < 50; i++){
            pstmt.setString(1, firstnames[random.nextInt(firstnames.length)]);
            pstmt.setString(2, lastnames[random.nextInt(lastnames.length)]);
            pstmt.setInt(3, random.nextInt(61) + 15);
            pstmt.setString(4, hobbies[random.nextInt(hobbies.length)]);
            pstmt.setInt(5, random.nextInt(amount)+1);
            pstmt.executeUpdate();
        }
        pstmt.close();
    }

    private static void updatePerson() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person id: ");
        int id = sc.nextInt();
        String pick = "";
        System.out.print("Update firstname(Y/N): ");
        pick = sc.next();
        if(pick.equals("Y")) {
            updatePersonFirstname(id);
        }
        System.out.print("Update lastname(Y/N): ");
        pick = sc.next();
        if(pick.equals("Y")) {
            updatePersonLastname(id);
        }
        System.out.print("Update age(Y/N): ");
        pick = sc.next();
        if(pick.equals("Y")) {
            updatePersonAge(id);
        }
        System.out.print("Update hobby(Y/N): ");
        pick = sc.next();
        if(pick.equals("Y")) {
            updatePersonHobby(id);
        }
        System.out.print("Update city(Y/N): ");
        pick = sc.next();
        if(pick.equals("Y")) {
            updatePersonCity(id);
        }
    }

    private static void updatePersonFirstname(int id) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "UPDATE person SET firstname = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        String firstname;
        System.out.print("Enter firstname: ");
        firstname = sc.next();
        pstmt.setString(1, firstname);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void updatePersonLastname(int id) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "UPDATE person SET lastname = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        String lastname;
        System.out.print("Enter lastname: ");
        lastname = sc.next();
        pstmt.setString(1, lastname);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void updatePersonAge(int id) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "UPDATE person SET age = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        int age;
        System.out.print("Enter age: ");
        age = sc.nextInt();
        pstmt.setInt(1, age);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void updatePersonHobby(int id) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "UPDATE person SET hobby = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        String hobby;
        System.out.print("Enter hobby: ");
        hobby = sc.next();
        pstmt.setString(1, hobby);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    private static void updatePersonCity(int id) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String query = "UPDATE person SET city_id = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        int city_id;
        System.out.print("Enter city id: ");
        city_id = sc.nextInt();
        pstmt.setInt(1, city_id);
        pstmt.setInt(2, id);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
