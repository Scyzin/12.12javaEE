package annotation;
//创建一个注解类
public @interface MyAnnotation {
	/*注解的属性类型可以有哪些?
			1.基本类型
			2.String
			3.枚举类型
			4.注解类型
			5.Class类型
			6.以上类型的一维数组类型
*/
	int age() default 0;
	
	String name() default "";
	
	String sex() default "";
	
	//String value();
	String[] value();
	
	//MyAnno anno();
	
	//Color color();
	
}
