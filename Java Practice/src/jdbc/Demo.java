package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@//ofss-mum-5027.snbomprshared1.gbucdsint02bom.oraclevcn.com:1521/DEV11_6";
		String username = "FCRHOSTIT2";
		String password = "YESHSTUAT";
		String query = "select * from ba_int_indx_mast where cod_int_indx > 100 and cod_int_indx < 110";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(query);
			
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				String index = rs.getString(1);
				String name = rs.getString(2);
				String status = rs.getString(3);
				System.out.println(index + '-' + name + '-' + status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
