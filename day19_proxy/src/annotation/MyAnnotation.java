package annotation;
//����һ��ע����
public @interface MyAnnotation {
	/*ע����������Ϳ�������Щ?
			1.��������
			2.String
			3.ö������
			4.ע������
			5.Class����
			6.�������͵�һά��������
*/
	int age() default 0;
	
	String name() default "";
	
	String sex() default "";
	
	//String value();
	String[] value();
	
	//MyAnno anno();
	
	//Color color();
	
}
