package com.internousdev.login3.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login3.dao.LoginDAO;
import com.internousdev.login3.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String username;
	private String password;
	private Map<String,Object> session;
	public String execute (){
		String ret = ERROR;
		LoginDAO dao = new  LoginDAO();
		LoginDTO dto = dao.select(username, password);

		if(username.equals(dto .getUsername())){
				session.put("username","taro");
				System.out.println((String)session.get("username"));

				session.put("password","123");
				System.out.println((String)session.get("password"));

				session.put("user","jiro");
				System.out.println((String)session.get("user"));

				session.put("pass","456");
				System.out.println((String)session.get("pass"));

				ret = SUCCESS;
			}
		return ret;
		}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}

}
