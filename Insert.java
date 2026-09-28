import java.sql.*;
public class Insert {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/sturec";
        String user = "root";
        String password = "varshi";
         try
         {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection(url,user,password);
             System.out.println("Connection Established Successfully!");
             Statement st=con.createStatement();
             String sql="insert into  sturec(rollno,name,dept)values(?,?,?)";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1,105);
             ps.setString(2,"varsha");
             ps.setString(3,"EEE");
             int data=ps.executeUpdate();
             ResultSet rs=ps.executeQuery("select * from sturec");
             System.out.println("Student detils");
             System.out.println("-----------------");
             while(rs.next())
             {
                 System.out.println(rs.getInt("rollno")+"|"+rs.getString("name")+"|"+rs.getString("dept"));
             }
           con.close();
         }
         catch (Exception e) {
             e.printStackTrace();
         }
    }
}
