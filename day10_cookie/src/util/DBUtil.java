package util;

import java.util.HashMap;
import java.util.Map;

import entity.Book;


public class DBUtil {
	private static Map<String, Book> books =new  HashMap<String, Book>();
	
	static{
		books.put("1", new Book("1", "金瓶梅", 20, "王瑞鑫"));
		books.put("2", new Book("2", "葵花宝典", 20, "杨成毅"));
		books.put("3", new Book("3", "九阴真经", 30, "陈光"));
		books.put("4", new Book("4", "玉女心经", 10, "陈志家"));
	}
	//得到所有书的列表
	public static Map<String, Book> findAllBooks(){
		return books;
	}
	
	//显示每本书的所有信息
	public static Book findBookById(String id ){
		return books.get(id);
	}
}
