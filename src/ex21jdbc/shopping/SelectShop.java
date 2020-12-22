package ex21jdbc.shopping;

import java.sql.SQLException;
import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class SelectShop extends IConnectImpl{
	
	String searchName;
	
	public SelectShop(String searchName) {
		
		super("kosmo", "1234");
		this.searchName = searchName;
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			String query = 
					" SELECT "
					+ " g_idx, "
					+ " goods_name, "
					+ " to_char(goods_price, '999,999,999') p1,"
					+ "	to_char(regidate, 'yyyy.mm.dd hh24:mi') d1, "
					+ "	p_code "
					+ " FROM sh_goods"
					+ "	WHERE goods_name like '%" + searchName + "%' ";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				int idx = rs.getInt(1);//id컬럼
				String name = rs.getString(2);
				String price = rs.getString("p1");
				String date = rs.getString("d1");
				int code = rs.getInt(5);
				
				System.out.printf("%s %s %s %s %s \n",
						idx, name, price, date, code);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리 오류발생");
			e.printStackTrace();
		}
		finally {
			close();//DB 자원반납
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("상품이름:");
		String searchName = sc.next();
		SelectShop selectSQL = new SelectShop(searchName);
		selectSQL.execute();
	}
}
