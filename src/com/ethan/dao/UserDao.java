package com.ethan.dao;

import java.sql.SQLException;

public interface UserDao {
	
	/*
	 * 将User保存至数据库中,成功返回user_id，失败返回0
	 */
	public int registersave(String user_number,String user_password) throws SQLException;
	
	/*
	 * 查询数据库中是否有对应的user_number，如果有，返回对应user_id，没有，返回0
	 */
	public int queryUserNumber(String user_number) throws SQLException;
	
	/*
	 * 根据User查询数据库中相应的user_id的user_password是否正确。如果正确，返回对应的user_id，否则返回0
	 */
	public int queryPassWord(int user_id, String user_password) throws SQLException;
	
	/*
	 * 更新用户的token
	 */
	public int updateToken(int user_id,String token) throws SQLException; 
	
	
	public void delete(int user_id) throws SQLException;

}
