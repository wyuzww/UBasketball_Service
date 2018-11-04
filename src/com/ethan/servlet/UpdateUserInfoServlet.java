package com.ethan.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.alibaba.fastjson.JSON;
import com.ethan.service.UpdateUserInfoService;
import com.ethan.utils.Util;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet("/UpdateUserInfo")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        Map<String, String> param = null;
        String ImagePath = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();


        ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setHeaderEncoding("UTF-8");
		

		
		try {
			List<?> items = upload.parseRequest(request);
			
			param = new HashMap<String, String>(); 
			for(Object object:items){
			    FileItem fileItem = (FileItem) object; 
			    if (fileItem.isFormField()) { 
			        param.put(fileItem.getFieldName(), fileItem.getString("utf-8"));//页面编码是utf-8的 
			    } else {
			    	//如果是文件字段
			        String fieldName = fileItem.getFieldName();
					String fileName = fileItem.getName();
					ImagePath = fieldName+"/"+fileName;
					
					System.out.println(fieldName);
					System.out.println(fileName);
					    
					InputStream inputStream = fileItem.getInputStream();
					String parentDir = this.getServletContext().getRealPath(fieldName);
					File imageFile = new File(parentDir, fileName);
					if (!imageFile.getParentFile().exists()) {
						imageFile.getParentFile().mkdirs();
					}
					FileOutputStream outputStream = new FileOutputStream(imageFile);
					byte[] buf = new byte[1024];
					int lenth = -1;
					while ((lenth = inputStream.read(buf)) !=-1) {
                        outputStream.write(buf, 0, lenth);
                    }
					if(inputStream!=null)
					inputStream.close();
					if(outputStream!=null)
					outputStream.close();
			    }
			    fileItem.delete();
			}
			System.out.println(param.get("user_token"));
			System.out.println(param.get("user_name"));
			System.out.println(param.get("user_sex"));
			System.out.println(param.get("user_birth"));
			System.out.println(param.get("user_signature"));
		} catch (FileUploadException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		String user_image = ImagePath;
        String user_token = param.get("user_token");
        String user_name = param.get("user_name");
        String user_sex = param.get("user_sex");
        String user_birth = param.get("user_birth");
        String user_signature = param.get("user_signature");
       
        
        
//        String user_token = request.getParameter("user_token");
//        String user_name = request.getParameter("user_name");
//        String user_sex = request.getParameter("user_sex");
//        String user_birth = request.getParameter("user_birth");
//        String user_signature = request.getParameter("user_signature");
        
        
     // 新建服务对象
        UpdateUserInfoService us = new UpdateUserInfoService();
        
     // 验证处理
        
        
        int code = us.update(user_token,user_image, user_name, user_sex, user_birth, user_signature);
        
        String msg = null;
        if(code==0) {
        	msg = "保存成功";
        } else if(code == 1) {
        	msg = "登录信息已过期";
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
        
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
