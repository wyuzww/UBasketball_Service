package com.ethan.dao.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ethan.dao.UserDao;
import com.ethan.db.DBConnection;
import com.ethan.entity.User;

public class UserDaoImpl implements UserDao {
	private User user = new User();
	
	static int i=1,j=1;
	//第一步：创建queryRunner对象，用来操作sql语句
	QueryRunner qr = new QueryRunner(DBConnection.getDs());
	
	@Override
	public int registersave(String user_number,String user_password) throws SQLException {
		int code=0;
		String sql = "insert into user_info values(null,?,?,?,null,null,null,null)";
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
				// TODO 自动生成的方法存根
				//long startTime = System.currentTimeMillis();
					code = qr.update(sql,user_number,user_number,user_password);
//					System.out.println("4444:"+code);
					return code;				
				//long endTime = System.currentTimeMillis();
				//System.out.println("insert"+(i++)+": 用时："+(endTime-startTime));
//			}
//			
//		}).start();
		
		// TODO 自动生成的方法存根
		
	}

//	@Override
//	public int queryUserName(Connection connection, String user_number) throws SQLException {
//		// TODO 自动生成的方法存根
//		return 0;
//	}
//
//	@Override
//	public int queryPassWord(Connection connection, int user_id, String user_password) throws SQLException {
//		// TODO 自动生成的方法存根
//		return 0;
//	}

	@Override
	public int queryUserNumber(String user_number) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "select * from user_info where user_number=?";
		
		user = qr.query(sql, new BeanHandler<User>(User.class),user_number);
		System.out.println("queryUserNumber:"+user);
		if(user == null) {
			return 0;
		} else {
			return user.getUser_id();
		}
		//User user = qr.query(sql, new BeanHandler<User>(User.class), user_number);
		
//		if(user != null) {
//			return user.getUser_id();
//		} else {
//			return 0;
//		}
		
	}

	@Override
	public int queryPassWord(int user_id, String user_password) throws SQLException {
		// TODO 自动生成的方法存根
		
		String sql = "select * from user_info where user_id=? and user_password=?";
		user = qr.query(sql, new BeanHandler<User>(User.class), user_id, user_password);
		System.out.println("queryPassWord:"+user);
		if(user != null) {
			return user.getUser_id();
		} else {
			return 0;
		}
	}

	@Override
	public void delete(int user_id) throws SQLException {

//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
				// TODO 自动生成的方法存根
//				long startTime = System.currentTimeMillis();
				try {
					qr.update("delete from user_info where user_id=?", user_id);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
//				long endTime = System.currentTimeMillis();
//				System.out.println("delete"+(j++)+": 用时："+(endTime-startTime));
//			}
//			
//		}).start();
		
		// TODO 自动生成的方法存根
		
	}
	
	public User getUser() {
		return this.user;
	}

	@Override
	public int updateToken(int user_id, String token) throws SQLException {
		// TODO 自动生成的方法存根
		int code=0;
		String sql="update user_info set user_token=? where user_id=?";
		code = qr.update(sql,token,user_id);
		
		return code;
	}
}
