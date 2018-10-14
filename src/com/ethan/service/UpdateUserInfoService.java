package com.ethan.service;

import java.sql.SQLException;

import com.ethan.dao.daoimpl.UserDaoImpl;

public class UpdateUserInfoService {
	UserDaoImpl manager = new UserDaoImpl();
	public int update(String user_token,String user_image,String user_name,String user_sex,String user_birth,String user_signature) {
		
		try {
			int user_id = manager.checkToken(user_token);
			if(user_id == 0) {//登录信息过期
				return 1;
			} else {
				int code = manager.updateUser(user_id, user_image,user_name, user_sex, user_birth, user_signature);
				if(code == 0) {
					return 1001;//未知错误
				}else {
					return 0;//修改成功
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 1001;
		}
	}
	
	

}
