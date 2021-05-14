package lab05;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class jdbcCommitCatchTest {

    public static void main(String[] args)throws SQLException {
       try (
               Connection conn = DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/ebookshop", "root", "");
               Statement stmt = conn.createStatement();
               ) {
           try {
               conn.setAutoCommit(false);

               stmt.executeUpdate("insert  into books values (4001, 'Paul Chan', 'Majong 101', 44.44, 4)");
               stmt.executeUpdate("insert into books values (4002, 'peter Chan', 'Mahjong 101', 4.4, 4)");
               conn.commit();
           }
           catch (SQLException ex) {
               System.out.println("--Rolling back changes--");
               conn.rollback();
               ex.printStackTrace();
           }

           ResultSet rset = stmt.executeQuery("select * from books");

           ResultSetMetaData rsetMD = rset.getMetaData();
           int numColumns = rsetMD.getColumnCount();

           for (int i = 1; i <= numColumns; i++) {
               System.out.printf("%-30s", rsetMD.getColumnName(i));
           }
           System.out.println();

           for (int i = 1; i <= numColumns; i++) {
               System.out.printf("%-30s", "(" + rsetMD.getColumnClassName(i) +")");
           }
           System.out.println();
           while (rset.next()) {
               for (int i = 1; i <= numColumns; i++) {
                   System.out.printf("%-30s", rset.getString(i));
               }
               System.out.println();
           }

       }}
}
