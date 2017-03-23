package com.derun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.derun.entity.userinfo;

public class UserinfoDAO {
	
	protected Connection getConn() throws Exception{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jygl","root","zhaijk");
		}catch(SQLException e1){
			throw new Exception("SQL 加载错误");
		}catch(ClassNotFoundException e2){
			throw new Exception("没有加载的类");
		}
	}
	
	public void create(userinfo obj){
		Connection conn=null;
		try{
			conn=getConn();
			String sql="insert into userinfo(builddate,operatorcode,operatorname,operatorpassword,operatortype,operatorrestrict,deleteflag,tmemo) "
					+ "values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, obj.getBuilddate());
			pstmt.setString(2, obj.getOperatorcode());
			pstmt.setString(3, obj.getOperatorname());
			pstmt.setString(4, obj.getOperatorpassword());
			pstmt.setString(5, obj.getOperatortype());
			pstmt.setString(6, obj.getOperatorrestrict());
			pstmt.setString(7, obj.getDeleteflag());
			pstmt.setString(8, obj.getTmemo());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}
	}
	public userinfo findByid(String username){
		userinfo obj=null;
		Connection conn=null;
		try{
			conn=getConn();
			PreparedStatement pstmt=conn.prepareStatement("select  * from operator_info where operatorcode=?");
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				System.out.println("operatorrestrict: "+rs.getString("operatorrestrict"));
			}			
			rs.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public static void main(String[] args){
		UserinfoDAO dao=new UserinfoDAO();
		dao.findByid("0001");
	}
}
