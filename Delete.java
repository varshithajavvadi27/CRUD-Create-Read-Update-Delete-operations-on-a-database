import java.sql.*;
public class Delete {
    public static void main(String[] args)
    {
        String url="jdbc:mysql://localhost:3306/sturec";
        String user="root";
        String password="varshi";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,password);
            System.out.println("database connected succesfilly");
            String sql="delete from sturec where rollno=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,1);
            int data= ps.executeUpdate();
            if(data>0)
            {
                System.out.println("data updated successfully");
            }
            else {
                System.out.println("student not found");
            }
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
