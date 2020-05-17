package bean;

public class Student {
	private String stuId;
	private String stuName;
	private String stuSex;
	private int chinese;
	private int math;
	private int english;
	private int classId;
 
	public String getStuId() {
		return stuId;
	}
 
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
 
	public String getStuName() {
		return stuName;
	}
 
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
 
	public String getStuSex() {
		return stuSex;
	}
 
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
 
	public int getChinese() {
		return chinese;
	}
 
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
 
	public int getMath() {
		return math;
	}
 
	public void setMath(int math) {
		this.math = math;
	}
 
	public int getEnglish() {
		return english;
	}
 
	public void setEnglish(int english) {
		this.english = english;
	}
 
	public int getClassId() {
		return classId;
	}
 
	public void setClassId(int classId) {
		this.classId = classId;
	}
 
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", chinese=" + chinese
				+ ", math=" + math + ", english=" + english + ", classId=" + classId + "]";
	}
 
}