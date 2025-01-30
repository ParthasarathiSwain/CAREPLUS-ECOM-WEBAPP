package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Company;
import utility.DbConnection;

public class CompanyDao {

	public int saveCompany(Company c) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="insert into companies(comName,comEmail,comPass,comPhone,comAdd,createdDate) values(?,?,?,?,?,now())";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, c.getComName());
			ps.setString(2, c.getComEmail());
			ps.setString(3, c.getComPass());
			ps.setString(4, c.getComPhone());
			ps.setString(5, c.getComAdd());
			status=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
