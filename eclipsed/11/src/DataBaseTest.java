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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		System.out.println("���سɹ�");
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
		// TODO �Զ����ɵķ������
		DataBaseTest da = new DataBaseTest();
		da.startMysql();
	}

}
