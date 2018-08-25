import java.sql.SQLException;

import com.ethan.dao.daoimpl.UserDaoImpl;
import com.ethan.entity.User;

public class MyThread2 extends Thread{
	static int i=1;

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		User u = new User();
		u.setUser_number("111");
		u.setUser_password("222");
		UserDaoImpl ud = new UserDaoImpl();
		try {
			ud.registersave(u.getUser_number(), u.getUser_password());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
	}
	

}
