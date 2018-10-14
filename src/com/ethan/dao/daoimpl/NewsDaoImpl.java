package com.ethan.dao.daoimpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.ethan.dao.NewsDao;
import com.ethan.db.DBConnection;
import com.ethan.entity.News;

public class NewsDaoImpl implements NewsDao{

	QueryRunner qr = new QueryRunner(DBConnection.getDs());
	
	@Override
	public int updateNews(News news) throws SQLException {
		int code=0;
		String sql = "insert into news values(null,?,?,?,?,?,?,?)";
		code = qr.update(sql,news.getNews_title(),news.getNews_date(),news.getNews_author(),news.getNews_url(),news.getNews_pic_url1(),news.getNews_pic_url2(),news.getNews_pic_url3());
		return code;
	}

}
