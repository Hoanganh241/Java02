package lab05;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.sql.*;

public class test2 {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root", "");
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into books values (?,?,?,?,?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from books");
        ) {


            pstmt.setInt(1, 7001);
            pstmt.setString(2, "Mahjong 101");
            pstmt.setString(3, "Kumar");
            pstmt.setDouble(4, 88.88);
            pstmt.setInt(5, 88);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");
            pstmt.setInt(1, 7002);
            pstmt.setString(2, "Mahjong 102");

            rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");
            ResultSet rset = pstmtSelect.executeQuery();
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ","
                        + rset.getString("author") + ","
                        + rset.getString("title") + ","
                        + rset.getDouble("price"));
            }
        }
                catch(SQLException ex){
                ex.printStackTrace();
            }

            }
        }
