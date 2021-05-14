package lab05;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class selectBT01 {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop2", "root", "");
                PreparedStatement pstmt = conn.prepareStatement("insert into bookss values (?, ?, ?, ?, ?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from bookss");
                ){


            pstmt.setInt(1, 956);
            pstmt.setString(2, "How to become a master of smoke");
            pstmt.setString(3, "Dat smoker");
            pstmt.setDouble(4, 88.62);
            pstmt.setInt(5, 12);
            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");

            pstmt.setInt(1, 123456);
            pstmt.setString(2, "Phong thái của một con nghiện");
            rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + "rows affected.");

            ResultSet rset = pstmtSelect.executeQuery();
            while (rset.next()) {
                System.out.println("Id: " + rset.getInt("id")
                        + "\nTitle: " + rset.getString("title")
                        + "\nAuthor: " + rset.getString("author")
                        + "\nPrice: " + rset.getDouble("price")
                        + "\nQty : " + rset.getInt("qty"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
