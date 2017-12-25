package util;

import java.util.HashMap;
import java.util.Map;

import entity.Book;


public class DBUtil {
	private static Map<String, Book> books =new  HashMap<String, Book>();
	
	static{
		books.put("1", new Book("1", "��ƿ÷", 20, "������"));
		books.put("2", new Book("2", "��������", 20, "�����"));
		books.put("3", new Book("3", "�����澭", 30, "�¹�"));
		books.put("4", new Book("4", "��Ů�ľ�", 10, "��־��"));
	}
	//�õ���������б�
	public static Map<String, Book> findAllBooks(){
		return books;
	}
	
	//��ʾÿ�����������Ϣ
	public static Book findBookById(String id ){
		return books.get(id);
	}
}