package listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements Serializable, HttpSessionBindingListener {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("user���󱻰���");
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("user������������");
	}
	
	
}
