package com.ethan.dao;

import java.sql.SQLException;

import com.ethan.entity.News;

public interface  NewsDao {
	
	/**
	 * 更新News
	 * @param news
	 * @return
	 */
	public  int updateNews(News news) throws SQLException;

	
	
	
}
