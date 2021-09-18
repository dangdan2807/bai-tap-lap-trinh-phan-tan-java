package lab2.codeCuaCo.btgson.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
// import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

public class jdbcMetaData {
	private static final String PW = "sapassword";
	private static final String US = "sa";

	public static void main(String[] args) throws SQLException, JsonIOException, IOException {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=AdgTest";
		Connection con = DriverManager.getConnection(url, US, PW);
		
		// DatabaseMetaData metaData = con.getMetaData();
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		PreparedStatement stmt = con.prepareStatement("select * from Department");
		ResultSetMetaData colRs = stmt.getMetaData();
		
		int columnCount = colRs.getColumnCount();
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Map<String, Object> map = new HashMap<>();
			for(int i  = 1; i <= columnCount; i++) {
				map.put(colRs.getColumnName(i), rs.getObject(i));
			}
			
			list.add(map);
		}
		
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		FileWriter out;
		gson.toJson(list, out = new FileWriter("data/Department.json"));
		out.close();
		
		
//		Lấy ds các table
//		ResultSet tblRs = metaData.getTables("AdgTest", null, null, new String[] {"TABLE"});
//		while(tblRs.next()) {
//			System.out.println(tblRs.getString("TABLE_NAME"));
//		}
		
//		Lấy DS db name
//		ResultSet dbRs = metaData.getCatalogs();
//		while(dbRs.next()) {
//			System.out.println(dbRs.getString("TABLE_CAT"));
//		}
		
	}
}
