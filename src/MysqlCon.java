import java.sql.*;
class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7358180","sql7358180","wKBsgvqkCR");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from personen");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}  