package online.babylove.www.io.demo6;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = -254016405508214405L;

	public Student() {
	}
	
	public Student(String stuno, String stuname, int age) {
		super();
		this.stuno = stuno;
		this.stuname = stuname;
		this.age = age;
	}
	
	//学号
	private String stuno;
	//学生名册
	private String stuname;
	/*
	 * 年龄
	 * transient关键字,该元素不会进行jvm默认的序列化
	 * 也可以自己完成这个元素的序列化
	 */
	private transient int age;
	
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [stuno=" + stuno + ", stuname=" + stuname + ", age=" + age + "]";
	}
	
	private void writeObject(java.io.ObjectOutputStream s)
	        throws java.io.IOException{
		//把jvm能默认序列化的元素进行序列化操作
		s.defaultWriteObject();
		//自己完成age的序列化
		s.writeInt(age);
	}
	
	private void readObject(java.io.ObjectInputStream s)
	        throws java.io.IOException, ClassNotFoundException {
		//把jvm能默认反序列化的元素进行反序列化操作
		s.defaultReadObject();
		//自己完成age的反序列化操作
		this.age = s.readInt();
	}
}
