import java.sql.*;

public class DataBaseTest {
	String url = "jdbc:mysql://localhost/bank?"
			+ "user=yyf&password=&useUnicode=true&characterEncoding=UTF8";
	Connection con = null;
	Statement sta = null;

	public void startMysql() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("加载失败");
		}
		System.out.println("加载成功");
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		sta = con.createStatement();
		ResultSet re = sta.executeQuery("SELECT * FROM account;");
		while (re.next()) {
			for (int i = 1; i <=12; i++)
				System.out.print(re.getString(i)+"    ");
			System.out.println();
		}

	}

	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		DataBaseTest da = new DataBaseTest();
		da.startMysql();
	}

}
