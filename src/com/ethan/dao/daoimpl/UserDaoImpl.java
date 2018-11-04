package com.ethan.dao.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ethan.dao.UserDao;
import com.ethan.db.DBConnection;
import com.ethan.entity.User;

public class UserDaoImpl implements UserDao {
	private User user = new User();
	private List<List<User>> userList;
	
	public User getUser() {
		return this.user;
	}
	
	public List<List<User>> getUserList() {
		return userList;
	}

	// static int i=1,j=1;
	//第一步：创建queryRunner对象，用来操作sql语句
	QueryRunner qr = new QueryRunner(DBConnection.getDs());
	
	@Override
	public int registersave(String user_number, String user_password) throws SQLException {
		int code = 0;
		String sql = "insert into user_info values(null,?,null,?,?,null,null,null,null)";
		code = qr.update(sql, user_number, user_number, user_password);

		return code;

	}


	@Override
	public int queryUserNumber(String user_number) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "select * from user_info where user_number=?";
		
		user = qr.query(sql, new BeanHandler<User>(User.class),user_number);
//		System.out.println("queryUserNumber:"+user);
		if(user == null) {
			return 0;
		} else {
			return user.getUser_id();
		}
		
	}

	@Override
	public int queryPassWord(int user_id, String user_password) throws SQLException {
		// TODO 自动生成的方法存根
		
		String sql = "select * from user_info where user_id=? and user_password=?";
		user = qr.query(sql, new BeanHandler<User>(User.class), user_id, user_password);
//		System.out.println("queryPassWord:"+user);
		if(user != null) {
			return user.getUser_id();
		} else {
			return 0;
		}
	}

	@Override
	public void delete(int user_id) throws SQLException {
		try {
			qr.update("delete from user_info where user_id=?", user_id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	@Override
	public int updateToken(int user_id, String token) throws SQLException {
		// TODO 自动生成的方法存根
		int code=0;
		String sql="update user_info set user_token=? where user_id=?";
		code = qr.update(sql,token,user_id);
		
		return code;
	}

	@Override
	public int checkToken(String user_token) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "select * from user_info where user_token=?";
		user = qr.query(sql, new BeanHandler<User>(User.class),user_token);
		if(user == null) {
			return 0;
		} else {
			return user.getUser_id();
		}
	}

	@Override
	public int updateUser(int user_id,String user_image,String user_name,String user_sex,String user_birth,String user_signature) throws SQLException {
		// TODO 自动生成的方法存根
		int code=0;
		String sql=null;
		if (user_image!=null) {
			sql="update user_info set user_image=?,user_name=?,user_sex=?,user_birth=?,user_signature=? where user_id=?";
			code = qr.update(sql, user_image,user_name,user_sex,user_birth,user_signature,user_id);
		} else {
			sql="update user_info set user_name=?,user_sex=?,user_birth=?,user_signature=? where user_id=?";
			code = qr.update(sql,user_name,user_sex,user_birth,user_signature,user_id);
		}

		return code;
	}


	@Override
	public int resetPassword(int user_id, String user_password) throws SQLException {
		// TODO 自动生成的方法存根
		int code = 0;
		String sql = "update user_info set user_password =? where user_id=?";
		
		code = qr.update(sql, user_password,user_id);
		
		
		
		return code;
	}


	@Override
	public int getFollowing(int user_id) throws SQLException {
		// TODO 自动生成的方法存根
		int code = 0;
		String sql = "SELECT\r\n" + 
				"follow.follow_id,\r\n" + 
				"user_info.user_id,\r\n" + 
				"user_info.user_image,\r\n" + 
				"user_info.user_name,\r\n" + 
				"user_info.user_sex,\r\n" + 
				"user_info.user_birth,\r\n" + 
				"user_info.user_signature\r\n" + 
				"FROM\r\n" + 
				"follow ,\r\n" + 
				"user_info\r\n" + 
				"WHERE\r\n" + 
				"follow.user_id = user_info.user_id AND\r\n" + 
				"follow.follow_user_id = ? \r\n" + 
				"ORDER BY\r\n" + 
				"follow.follow_id DESC\r\n" ;
		userList = qr.execute(sql, new BeanListHandler<User>(User.class), user_id);
		if (userList == null) {
			return 1;
		}
		return code;
	}


	
}
