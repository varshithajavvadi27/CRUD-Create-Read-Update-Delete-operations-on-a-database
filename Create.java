import java.sql.*;
public class Create {
    public static void main(String[] args)
    {
         String url="jdbc:mysql://localhost:3306/sturec";
         String user="root";
         String password="varshi";
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(url,user,password);
             System.out.println("database connected successfully");
             con.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    }
}
