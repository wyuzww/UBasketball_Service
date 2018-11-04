package com.ethan.dao.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ethan.dao.NewsDao;
import com.ethan.db.DBConnection;
import com.ethan.entity.News;

public class NewsDaoImpl implements NewsDao{

	QueryRunner qr = new QueryRunner(DBConnection.getDs());
	private List<List<News>> news;
	
	
	public List<List<News>> getNews() {
		return news;
	}

	@Override
	public int updateNews(News news) throws SQLException {
		int code=0;
		String sql = "insert into news values(null,?,?,?,?,?,?,?)";
		code = qr.update(sql,news.getNews_title(),news.getNews_date(),news.getNews_author(),news.getNews_url(),news.getNews_pic_url1(),news.getNews_pic_url2(),news.getNews_pic_url3());
		return code;
	}

	@Override
	public int getAllNews() throws SQLException {
		// TODO 自动生成的方法存根
		int code = 0;
		String sql = "select * from news order by rand() desc limit 30 ";
		news = qr.execute(sql,new BeanListHandler<News>(News.class));
		if (news == null) {
			code = 1;
		}
		return code;
	}

}
