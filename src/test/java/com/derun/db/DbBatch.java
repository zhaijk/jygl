package com.derun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DbBatch {

	private Connection conn=null;
	private PreparedStatement statement=null;
	
	@Before
	public void init() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jylq?rewriteBatchedStatements=true","root","zhaijk");
		conn.setAutoCommit(false);
	}
	
	@Test
	public void normalOperation() throws SQLException{
		//conn.setAutoCommit(false);
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jylq?rewriteBatchedStatements=false","root","zhaijk");
		conn.setAutoCommit(false);
		String sql="insert into card_trade(tradedate,tradetime,tradetype,guncode,oiltype,cardcode,cardtype,volumn) values(?,?,?,?,?,?,?,?)";
		
		statement=conn.prepareStatement(sql);
		long start=System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			statement.setString(1, "2015-3-29");
			statement.setString(2, new SimpleDateFormat("HH:mm:ss").format(new Date()));
			statement.setString(3, "1");			
			statement.setString(4, "01");
			statement.setString(5, "23");
			statement.setString(6, "720000123456");
			statement.setString(7, "0");
			statement.setDouble(8, 123.45);			
			statement.executeUpdate();
			//if((i%1000)==0)
			//	conn.commit();
		}
		conn.commit();
		long end=System.currentTimeMillis();
		System.out.println("²Ù×÷ºÄ: "+(end-start)+"ms");
	}
	@Test
	public void batchOperation() throws SQLException{
		//conn.setAutoCommit(true);		
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jylq?rewriteBatchedStatements=true","root","zhaijk");
		conn.setAutoCommit(false);
		String sql="insert into card_trade(tradedate,tradetime,tradetype,guncode,oiltype,cardcode,cardtype,volumn) values(?,?,?,?,?,?,?,?)";
		statement=conn.prepareStatement(sql);
		long start=System.currentTimeMillis();
		
		for(int i=0;i<100000;i++){
			statement.setString(1, "2015-3-29");
			statement.setString(2, new SimpleDateFormat("HH:mm:ss").format(new Date()));
			statement.setString(3, "1");			
			statement.setString(4, "01");
			statement.setString(5, "23");
			statement.setString(6, "720000123456");
			statement.setString(7, "0");
			statement.setDouble(8, 123.45);
			
			//statement.executeUpdate();
			statement.addBatch();
			if(i%1000==0){
				statement.executeBatch();
				conn.commit();
				//int[] a=statement.executeBatch();
				//System.out.println(a.length);
			}
			
		}
		statement.executeBatch();
		conn.commit();
		long end=System.currentTimeMillis();
		System.out.println("²Ù×÷ºÄ: "+(end-start)+"ms");
	}
	
	@After
	public void destory() throws SQLException{
		statement.close();
		conn.close();
	}
}
