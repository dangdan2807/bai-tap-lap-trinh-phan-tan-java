package lab2.codeCuaCo.btgson.exercise6;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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

public class DatabaseUtil {
	private Connection con = null;

	/**
	 * @param con
	 */
	public DatabaseUtil(Connection con) {
		this.con = con;
	}
	
	public List<String> getDatabases() throws SQLException {
		List<String> list = new ArrayList<>();
		
		DatabaseMetaData metaData = con.getMetaData();
		ResultSet rs = metaData.getCatalogs();
		while(rs.next()) {
			String dbName = rs.getString("TABLE_CAT");
			list.add(dbName);
		}
		
		return list;
	}
	
	public List<String> getTables(String dbName) throws SQLException {
		List<String> list = new ArrayList<>();
		
		DatabaseMetaData metaData = con.getMetaData();
		ResultSet rs = metaData.getTables(dbName, "dbo", null, new String[] {"TABLE"});
		while(rs.next()) {
			String table = rs.getString("TABLE_NAME");
			list.add(table);
		}
		
		return list;
	}

	public void export2json(Connection con, String tblName, String fileName) throws SQLException, IOException {

		List<Map<String, Object>> list = new ArrayList<>();
		
		FileWriter out = new FileWriter(fileName);
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		//Java Object Model
		//Java Stream API
		
		Map<String, Object> map = new HashMap<>();
		
		PreparedStatement stmt = con.prepareStatement("select * from " + tblName);
		ResultSet rs = stmt.executeQuery();
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		
		while(rs.next()) {
			int columnCount = rsMetaData.getColumnCount();
			for(int i = 1; i <= columnCount ; i++) {
				map.put(rsMetaData.getColumnName(i), rs.getObject(i));
			}
			list.add(map);
		}
		
		gson.toJson(list, out);
		
		out.close();
	}
}
