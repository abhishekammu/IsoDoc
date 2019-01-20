package dao1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.MySqlC;

public class LoginDao1 {
	public Map<String, Comparable> guardlogin() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException
	{
		database.MySqlC c = new database.MySqlC();
		Connection con =  c.conect();
		Map obj=null;
		try {
			// Connection con= null;
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Iso_Doc");
	
			if (rs.next()) {
				obj=new HashMap();
				obj.put("F_Directorate", rs.getString(1));
				obj.put("F_Division", rs.getString(2));
				obj.put("F_TypofDoc", rs.getString(3));
				obj.put("F_DocNomen", rs.getString(4));
				obj.put("F_DocNo",rs.getString(5));
				obj.put("F_RevNo",rs.getString(6));	
				obj.put("F_RevDt",rs.getString(7));
				obj.put("F_IssueNo",rs.getString(8));
				obj.put("F_IssueDt",rs.getString(9));	
				obj.put("F_Remarks",rs.getString(10));	
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return obj;
	}
	public List guardlogin1() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException
	{
		System.out.println("Enter to dao");
		database.MySqlC c = new database.MySqlC();
		System.out.println("Enter to dao1");
		Connection con =  MySqlC.conect();
		System.out.println("Enter to dao2");
		List obj=new ArrayList();
		System.out.println("Enter to dao3");
		try {
			System.out.println("10");
			// Connection con= null;
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Iso_Doc order by F_Directorate");
			
			System.out.println("20");
			while(rs.next()) {
				Map m=new HashMap();
				m.put("F_Directorate", rs.getString(1));
				System.out.println("1");
				m.put("F_Division", rs.getString(2));
				System.out.println("2");
				m.put("F_TypofDoc", rs.getString(3));
				System.out.println("3");
				m.put("F_DocNomen", rs.getString(4));
				System.out.println("4");
				
				m.put("F_DocNo",rs.getString(5));
				System.out.println("5");
				m.put("F_RevNo",rs.getString(6));
				System.out.println("6");
				m.put("F_RevDt", rs.getDate(7));
				
				
				System.out.println("7");
				m.put("F_IssueNo",rs.getString(8));
				System.out.println("8");
				m.put("F_IssueDt",rs.getString(9));
				System.out.println("9");
				m.put("F_Remarks",rs.getString(10));
				System.out.println("10");
				obj.add(m);
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return obj;
	}
public int saveIso_DocController(String Directorate,String Division,String TypeofDocument,String DocumentNomenclature,String DocumentNo,String RevisionNumber,String RevisionDate,String IssueNumber,String IssueDate,String Remarks) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException


{
	System.out.println("Directorate ===>>. "+ Directorate);
	System.out.println("Division ===>>. "+ Division);
	System.out.println("TypeofDocument ===>> "+ TypeofDocument);
	System.out.println("DocumentNomenclature===>> "+ DocumentNomenclature);
	System.out.println("DocumentNo ===>> "+ DocumentNo);
	System.out.println("RevisionNumber===>>> "+RevisionNumber);
	System.out.println("RevisionDate===>>> "+RevisionDate);
	System.out.println("IssueNumber===>>> "+IssueNumber);
	System.out.println("IssueDate===>>> "+IssueDate);
	System.out.println("Remarks===>>> "+Remarks);
	database.MySqlC c = new database.MySqlC();
	Connection con =  c.conect();
	try {
		System.out.println("10");
		java.sql.Statement stmt = con.createStatement();
		String sqlQuery = "INSERT INTO `Iso_Doc`(`F_Directorate`, `F_Division`, `F_TypofDoc`, `F_DocNomen`, `F_DocNo`, `F_RevNo`, `F_RevDt`,`F_IssueNo`,`F_IssueDt`,`F_Remarks`) VALUES ('"+Directorate+"','"+Division+"', '"+TypeofDocument+"', '"+DocumentNomenclature+"','"+DocumentNo+"','"+RevisionNumber+"',STR_TO_DATE('"+RevisionDate.trim()+"','%d-%b-%Y'),'"+IssueNumber+"',STR_TO_DATE('"+IssueDate.trim()+"','%d-%b-%Y'),'"+Remarks+"')";
		return stmt.executeUpdate(sqlQuery);
		
	} catch (Exception e) {
		System.out.println(e);
	}
	finally {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	return 0;
}

}
