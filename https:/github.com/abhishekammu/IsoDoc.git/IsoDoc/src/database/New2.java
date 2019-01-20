package database;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class New2 {

	public static void main(String[] args)  throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		
		database.MySqlC c= new database.MySqlC();
		c.conect();
		
		try {
			//Connection con= null;
		java.sql.Statement stmt = ((java.sql.Connection) c.conect()).createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Iso_Doc");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getString(10));  
		c.conect().close();  
		}
	catch(Exception e){ System.out.println(e);}  
		 


	

		
	

}
}