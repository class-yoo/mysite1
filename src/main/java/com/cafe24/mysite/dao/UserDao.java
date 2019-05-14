package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cafe24.mysite.vo.GuestbookVo;
import com.cafe24.mysite.vo.UserVo;

public class UserDao {
	
	public Boolean insertGuestbook(UserVo userVo) {

		Boolean result = true;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "insert" 
						+ " into user" 
						+ " values(null, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getEmail());
			pstmt.setString(3, userVo.getPassword());
			pstmt.setString(4, userVo.getGender());

			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.221:3307/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
	
}
