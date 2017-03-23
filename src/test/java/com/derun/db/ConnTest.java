package com.derun.db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnTest {
	
	public static String dbDriver="com.mysql.jdbc.Driver";
	public static String dbServername="localhost";
	public static String dbName="jygl";
	public static String dbURL="jdbc:mysql://localhost:3306/jygl";
	public static String dbUsername="root";
	public static String dbPassword="zhaijk";
	
	
	
	public Connection getConnection_class(String url,String username,String password) throws Exception{
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jygl","root","zhaijk");			
//		} catch (ClassNotFoundException e) {			
//			throw new Exception("找不到驱动类");
//		} catch (SQLException e) {
//			throw new Exception("加载驱动异常");
//		}
		try {
			Class.forName(dbDriver);
			return DriverManager.getConnection(url,username,password);			
		} catch (ClassNotFoundException e) {			
			throw new Exception("找不到驱动类");
		} catch (SQLException e) {
			throw new Exception("加载驱动异常");
		}
	}
	
	public Connection getConnection(String serverName,String databaseName,String username,String password) throws SQLException{
		MysqlDataSource ds=new MysqlDataSource();
		ds.setServerName(serverName);
		ds.setDatabaseName(databaseName);
		//ds.setUrl(url);
		Connection conn=ds.getConnection(username,password);
		//ds.setUrl(url);
		return conn;
	}
	
	public Connection getConnection(String url,String username,String password) throws SQLException{
		MysqlDataSource ds=new MysqlDataSource();
		ds.setUrl(url);
		Connection conn=ds.getConnection(username,password);
		return conn;
	}
	
	public ResultSet query(Connection conn,String sqlStr) throws SQLException{
		
		Statement stmt=conn.createStatement();
		stmt.setFetchSize(2);
		return stmt.executeQuery(sqlStr);
	}
	public ResultSet query(int Type,Connection conn,String sqlStr) throws SQLException{
		
		return conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery(sqlStr);
	}
	public static void main(String[] args) throws SQLException{
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=new ConnTest().getConnection_class(dbURL,dbUsername, dbPassword);
			System.out.println(conn);
			conn=new ConnTest().getConnection(dbServername,dbName,dbUsername, dbPassword);
			System.out.println(conn);
			conn=new ConnTest().getConnection(dbURL,dbUsername, dbPassword);
			System.out.println(conn);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		rs=new ConnTest().query(conn, "select *  from card_trade");
		while(rs.next()){
			System.out.println(rs.getString("cardcode"));
		}
	}
}
