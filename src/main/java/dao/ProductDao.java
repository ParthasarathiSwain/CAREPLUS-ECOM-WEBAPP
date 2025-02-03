package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Product;
import utility.DbConnection;

public class ProductDao {

	public int saveProduct(Product product) {
		int status=0;
		try {
			Connection con=DbConnection.getConnection();
			String query="insert into products(pname,pdesc,imgName,availability,price,manufDate,expDate,createdDate,catId,comId) values(?,?,?,?,?,?,?,now(),?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, product.getPname() );
			ps.setString(2, product.getPdesc() );
			ps.setString(3, product.getImgName() );
			ps.setInt(4, product.getAvailability() );
			ps.setDouble(5, product.getPrice() );
			ps.setString(6, product.getManufDate() );
			ps.setString(7, product.getExpDate() );
			ps.setInt(8, product.getCatId() );
			ps.setInt(9, product.getComId() );
			
			status=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
