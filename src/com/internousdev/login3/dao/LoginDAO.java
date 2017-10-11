package com.internousdev.login3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internous.login3.util.DBConnector;
import com.internousdev.login3.dto.LoginDTO;


public class LoginDAO {

	public LoginDTO select (String username, String password){

		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users where username = ? and password = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dto;
	}
}
