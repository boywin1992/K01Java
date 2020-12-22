package ex21jdbc.shopping;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;
import ex21jdbc.prepared.InsertSQL;

public class InsertShop extends IConnectImpl{
	
	public InsertShop() {
		super("kosmo", "1234");
	}
	
	/*
	쇼핑몰 과제에서 "상품입력" 프로그램 작성
	 	: PreparedStatement 객체를 사용한다.
	*/
	public void execute() {
		//1. 쿼리문 작성
		String sql = " INSERT INTO sh_goods "
					+ " VALUES "
					+ " (goods_seq.nextval, ?, ?, sysdate, ?) ";
		try {
			//2. prepared 객체 생성
			psmt = con.prepareStatement(sql);
			
			//3. 인파라미터 설정
			psmt.setString(1, scanValue("상품명:"));
			psmt.setString(2, scanValue("상품가격:"));
			psmt.setString(3, scanValue("상품코드:"));
			
			//4.쿼리실행
			int affected = psmt.executeUpdate();
			
			System.out.println(affected +"행이 입력 되었습니다.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new InsertShop().execute();
	}
}
