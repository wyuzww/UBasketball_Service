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
import com.ethan.service.LoginByPasswordService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginByPassword")
public class LoginByPasswordServlet extends HttpServlet {
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
		
//        user_number = "13612250855";
//        user_password = "123456";
        System.out.println(user_number + "--" + user_password);
        
        
        // 新建服务对象
        LoginByPasswordService ls = new LoginByPasswordService();
        
        // 验证处理
        int code = ls.login(user_number, user_password);
        
        String msg = null;
        if(code==0) {
        	msg = "登陆成功";
        } else if(code == 1) {
        	msg = "用户不存在";
        } else if(code == 2) {
        	msg = "密码错误";
        } else {
        	msg = "未知错误";
        }
        
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("user",ls.getManager().getUser());
        
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        
        
        
        PrintWriter printWriter = response.getWriter();
		printWriter.write(jsonString);
		printWriter.flush();
		printWriter.close();
        
//        if (code==0) {
//        	System.out.println(ls.getManager().getUser().getUser_token());
//        	PrintWriter printWriter = response.getWriter();
//    		printWriter.write("Succss:登录成功！");
//    		printWriter.close();
//            System.out.println("Succss:登录成功！");
////            request.getSession().setAttribute("user_number", user_number);
//            // response.sendRedirect("welcome.jsp");
//        } else {
//        	PrintWriter printWriter = response.getWriter();
//    		printWriter.write("Failed:登录失败！");
//    		printWriter.close();
//            System.out.println("Failed:登录失败！");
//        }
        
        
        
		
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
