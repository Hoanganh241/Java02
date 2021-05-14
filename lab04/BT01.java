package lab05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BT01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop2", "root", "");
        String sql = "create table bookss (" + "id int not null auto_increment," + "title varchar(50) default null," + "author varchar (50) default null," + "price double ," + "qty int, " + "primary key (id)" + ")";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.execute();
        System.out.println("Create!");
    }
}
