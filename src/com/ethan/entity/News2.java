package com.ethan.entity;

public class News2 {
//    private int news_id;
    private String title;
    private String date;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;
    private String thumbnail_pic_s03;
    
    
	public News2( String title, String date, String author_name, String url, String thumbnail_pic_s,
			String thumbnail_pic_s02, String thumbnail_pic_s03) {
		super();
//		this.news_id = news_id;
		this.title = title;
		this.date = date;
		this.author_name = author_name;
		this.url = url;
		this.thumbnail_pic_s = thumbnail_pic_s;
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}
	
	public News2() {
		// TODO 自动生成的构造函数存根
	}

//	public int getNews_id() {
//		return news_id;
//	}
//	public void setNews_id(int news_id) {
//		this.news_id = news_id;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnail_pic_s() {
		return thumbnail_pic_s;
	}
	public void setThumbnail_pic_s(String thumbnail_pic_s) {
		this.thumbnail_pic_s = thumbnail_pic_s;
	}
	public String getThumbnail_pic_s02() {
		return thumbnail_pic_s02;
	}
	public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
	}
	public String getThumbnail_pic_s03() {
		return thumbnail_pic_s03;
	}
	public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}
    
    

}
