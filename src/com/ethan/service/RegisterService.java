package com.ethan.service;

import java.sql.SQLException;

import com.ethan.dao.daoimpl.UserDaoImpl;

public class RegisterService {
	UserDaoImpl manager = new UserDaoImpl();
	public int register(String user_number, String user_password) {
		// TODO 自动生成的方法存根
		try {
			int user_id = manager.queryUserNumber(user_number);
			if(user_id == 0) {//用户不存在
				int code = manager.registersave(user_number,user_password);
				if(code == 0) {
					return 1001;//未知错误
				}else {
					return 0;//注册成功
				}			
			}else {
				return 1;//用户已存在
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 1001;//未知错误			
		}		
	}
}
