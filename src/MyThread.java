import java.sql.SQLException;

import com.ethan.dao.daoimpl.UserDaoImpl;

public class MyThread extends Thread{
	static int i=1;

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		UserDaoImpl ud = new UserDaoImpl();
		try {
			ud.delete(i++);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	

}
