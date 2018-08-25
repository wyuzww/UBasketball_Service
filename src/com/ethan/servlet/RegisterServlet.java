package com.ethan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ethan.service.RegisterService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		// 接收客户端信息
        String user_number = request.getParameter("user_number");
        String user_password = request.getParameter("user_password");
       // System.out.println(user_number + "--" + user_password);
        
//        user_number = "13612250855";
//        user_password = "123456";
        System.out.println(user_number + "--" + user_password);
     // 新建服务对象
        RegisterService rs = new RegisterService();

        // 验证处理,code为状态码
        int code = rs.register(user_number, user_password);
//        System.out.println(isReg);
        String msg = null;
        
        if (code==0) {
        	msg = "注册成功";
        } else if(code==1){
        	msg = "用户已存在";
        } else {
			msg = "未知错误";
		}
        
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        
        PrintWriter printWriter = response.getWriter();
		printWriter.write(jsonString);
		printWriter.flush();
		printWriter.close();
             
//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
