package com.ethan.utils.news;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ethan.dao.daoimpl.NewsDaoImpl;
import com.ethan.entity.News;
import com.ethan.entity.News2;

public class GetNews {
//	static long start = System.currentTimeMillis();
//	static MyThread t;
		/**
		 * 测试主方法
		 * 
		 * @param args
		 */
		public static void main(String[] args) {
			Map<String, String> mapParam = new HashMap<String, String>();
			mapParam.put("type", "tiyu");
			mapParam.put("key", "0b07cf4039266357696483f562a077da");
			String pathUrl = "http://v.juhe.cn/toutiao/index";
			String result = GetNewsSevice.sendPost(pathUrl, mapParam);
			Pjson(result);
			

		}
		
		
		public static void Pjson(String response) {
//			System.out.println(response);
			
			JSONObject msg = JSONObject.parseObject(response);
//			System.out.println(msg);
			
			
			String string = msg.getString("result");
//			System.out.println(string);
			
			JSONObject msg1 = JSONObject.parseObject(string);
//			System.out.println(msg1);
			
		
			JSONArray data = (JSONArray)msg1.getJSONArray("data");
//			System.out.println(data);
			
			
			
			String string1 = JSONObject.toJSONString(data);
//			System.out.println(string1);
			
			List<News2> list = JSONObject.parseArray(string1,News2.class);
			
			for(int i=0;i<data.size();i++) {
				News news = new News(i, list.get(i).getTitle(), list.get(i).getDate(), list.get(i).getAuthor_name(), list.get(i).getUrl(), list.get(i).getThumbnail_pic_s(), list.get(i).getThumbnail_pic_s02(), list.get(i).getThumbnail_pic_s03());   
				NewsDaoImpl ls = new NewsDaoImpl();
				try {
					int code = ls.updateNews(news);
					System.out.println(code);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				//System.out.println(list.get(i).getTitle());
			}
		
		}
		
		
		
		
		
//		int i=1;
//		
//		Scanner in = new Scanner(System.in);
//		String string = in.next();
//		System.out.println(string);
//		long startTime = System.currentTimeMillis();
//		for(i=1;i<2;i++) {		
//			MyThread2 t = new MyThread2();
//			t.start();
////			MyThread t1 = new MyThread();
////			t1.start();
//		}
//		if(i==5000) {
//			long endTime = System.currentTimeMillis();
//			System.out.println("总用时1："+(endTime-startTime));
//			System.out.println("总用时2："+(end-start));
//			
////		}
//		System.out.println(start);
		
	}
//	static long end = System.currentTimeMillis();
