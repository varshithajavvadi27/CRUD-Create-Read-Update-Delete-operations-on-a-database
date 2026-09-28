import java.sql.*;
public class Update {
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
            String sql="update sturec set dept=? where rollno=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"MECH");
            ps.setInt(2,1);
            int data=ps.executeUpdate();
            ResultSet rs=ps.executeQuery("select * from sturec");
            while(rs.next())
            {
                System.out.println(rs.getInt("rollno")+rs.getString("name")+rs.getString("dept"));

            }
            con.close();
            ps.close();
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }
    }
}
