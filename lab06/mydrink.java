package lab06;

import java.sql.*;
import java.util.Scanner;

    public class mydrink {
        public static void main(String[] args) {
            try (
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/demo-jdbc",
                            "root", "");
                    Statement stmt = conn.createStatement();
            ) {
                Scanner scanner = new Scanner(System.in);
                int y=0;
                do {
                    System.out.println("list:");
                    System.out.println("1. Insert to table.");
                    System.out.println("2. Search in table.");
                    System.out.println("3. Update in table.");
                    System.out.println("4. Delete in table.");
                    System.out.println("5. Print table.");
                    System.out.println("6. Exit.");
                    System.out.println("Enter the number:");
                    y= Integer.parseInt(scanner.nextLine());
                    switch (y) {
                        case 1:
                            System.out.println("Set id:");
                            int id1 = Integer.parseInt(scanner.nextLine());
                            System.out.println("Name drink:");
                            String name1 = scanner.nextLine();
                            System.out.println("Price drink:");
                            int price1 = Integer.parseInt(scanner.nextLine());
                            System.out.println("Made by drink:");
                            String made = scanner.nextLine();
                            String insert1= "insert into drink values(?,?)";
                            PreparedStatement pstmt = conn.prepareStatement(insert1);
                            pstmt.setInt(1,id1);
                            pstmt.setString(2,name1);
                            int rowsInserted = pstmt.executeUpdate();
                            System.out.println(rowsInserted + " drink inserted!");
                            String check1 = "select * from drink WHERE drink = '"+ name1 +"';";
                            ResultSet drink1 = stmt.executeQuery(check1);
                            ResultSetMetaData drink1MD = drink1.getMetaData();
                            int numColums1 = drink1MD.getColumnCount();
                            for (int i = 1; i <= numColums1; i++) {
                                System.out.printf("%-20s", drink1MD.getColumnName(i));
                            }
                            System.out.println();
                            for (int i = 1; i <= numColums1; i++) {
                                System.out.printf("%-20s", "(" + drink1MD.getColumnName(i) + ")");
                            }
                            System.out.println();
                            while (drink1.next()) {
                                for (int i = 1; i <= numColums1; i++) {
                                    System.out.printf("%-20s", drink1.getString(i));
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Enter name drink:");
                            String name2 = scanner.nextLine();
                            String check2 = "select * from drink WHERE drink = '"+ name2 +"';";
                            ResultSet drink2 = stmt.executeQuery(check2);
                            int count=0;
                            while (drink2.next()){
                                count++;
                            }
                            if (count>=1){
                                ResultSetMetaData drink2MD = drink2.getMetaData();
                                int numColums2 = drink2MD.getColumnCount();
                                for (int i = 1; i <= numColums2; i++) {
                                    System.out.printf("%-20s", drink2MD.getColumnName(i));
                                }
                                System.out.println();
                                for (int i = 1; i <= numColums2; i++) {
                                    System.out.printf("%-20s", "(" + drink2MD.getColumnName(i) + ")");
                                }
                                System.out.println();
                                while (drink2.next()) {
                                    for (int i = 1; i <= numColums2; i++) {
                                        System.out.printf("%-20s", drink2.getString(i));
                                    }
                                    System.out.println();
                                }
                            }else
                                System.out.println("No drink name: " + name2+" in the list!!!");
                            break;
                        case 3:
                            System.out.println("Enter id:");
                            int id3= Integer.parseInt(scanner.nextLine());
                            System.out.println("Name drink:");
                            String name3 = scanner.nextLine();
                            System.out.println("Price drink:");
                            int price3 = Integer.parseInt(scanner.nextLine());
                            System.out.println("Made by drink:");
                            String made3 = scanner.nextLine();
                            String update3 ="UPDATE drink"+" SET drink=?,price=?,manufacturer=?"+" WHERE id=?";
                            PreparedStatement pstmt3 = conn.prepareStatement(update3);
                            conn.setAutoCommit(false);
                            pstmt3.setString(1,name3);
                            pstmt3.setInt(2,price3);
                            pstmt3.setString(3, made3);
                            pstmt3.setInt(4,id3);
                            pstmt3.addBatch();
                            System.out.println("Insert values");
                            break;
                        case 4:
                            System.out.println("Name drink:");
                            String name4 = scanner.nextLine();
                            String delete4 = "DELETE FROM drink WHERE drink ='"+name4+"';";
                            PreparedStatement pstmt4 = conn.prepareStatement(delete4);
                            pstmt4.executeUpdate();
                            System.out.println("DELETED!");
                            break;
                        case 5:
                            String strSelect = "select * from Drink";
                            System.out.println("The list my drink is:\n");
                            ResultSet drink = stmt.executeQuery(strSelect);
                            ResultSetMetaData drinkMD = drink.getMetaData();
                            int numColums = drinkMD.getColumnCount();
                            for (int i = 1; i <= numColums; i++) {
                                System.out.printf("%-20s", drinkMD.getColumnName(i));
                            }
                            System.out.println();
                            for (int i = 1; i <= numColums; i++) {
                                System.out.printf("%-20s", "(" + drinkMD.getColumnName(i) + ")");
                            }
                            System.out.println();
                            while (drink.next()) {
                                for (int i = 1; i <= numColums; i++) {
                                    System.out.printf("%-20s", drink.getString(i));
                                }
                                System.out.println();
                            }
                            break;
                    }
                }while (y<6);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
