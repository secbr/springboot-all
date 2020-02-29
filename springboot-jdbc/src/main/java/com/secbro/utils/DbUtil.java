package com.secbro.utils;

import java.sql.*;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/28 4:50 PM
 **/
public class DbUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/spring";
	private static final String USER = "root";
	private static final String PASSWORD = "genesis_123";

	public static void main(String[] args) {

		Connection conn = null;
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2. 建立数据库连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//3.创建数据库操作对象，实现增删改查
			Statement stmt = conn.createStatement();
			//4.定义操作的SQL语句
			//5.执行数据库操作
			ResultSet rs = stmt.executeQuery("SELECT order_no, amount FROM tb_order");
			//6.获取并操作结果集
			while (rs.next()) {
				System.out.println("订单号：" + rs.getString("order_no") + " 金额：" + rs.getInt("amount"));
			}
		} catch (Exception e) {
			// 日志信息
		} finally {
			// 7、关闭资源
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
