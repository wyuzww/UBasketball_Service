package com.ethan.service;

import java.sql.SQLException;

import com.ethan.dao.daoimpl.UserDaoImpl;
import com.ethan.utils.TokenManager;

public class LoginByPasswordService {
	
	private UserDaoImpl manager = new UserDaoImpl();
	public int login(String user_number, String user_password) {
		// TODO 自动生成的方法存根
//		System.out.println("0000");
		
		try {
//			System.out.println("1111");
			int user_id = manager.queryUserNumber(user_number);
			if(user_id == 0) {
//				System.out.println("2222");
				System.out.println("用户不存在！");
				return 1;
			}else {				
				int code = manager.queryPassWord(user_id,user_password);
				if(code == 0) {
					System.out.println("密码错误！");
					return 2;
				}else {
					TokenManager tm = new TokenManager();
					manager.getUser().setUser_token(tm.makeToken(user_id));
					manager.updateToken(user_id,manager.getUser().getUser_token());
					System.out.println(manager.getUser().getUser_token());
					return 0;
				}			
			}		
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 1001;
		}
	}
	
	
	public UserDaoImpl getManager() {
		return manager;
	}

}
