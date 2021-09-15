package common;

/**
 * GeneralStaff,ManagementStaffのスーパークラス.
 * 入力情報の保持
 * 
 * @author takumi
 */
public class Staff {
	String name;
	int age;
	
	/**
	 * コンストラクタ
	 * 
	 * @param name String 氏名
	 * @param age int 年齢
	 */
	public Staff(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * フィールド変数nameの取得
	 * 
	 * @return String 氏名
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 引数をフィールド変数nameに代入
	 * 
	 * @param name String 氏名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * フィールド変数ageの取得
	 * 
	 * @return String 年齢
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * 引数をフィールド変数ageに代入
	 * 
	 * @param age int 年齢
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 変数に入力された情報を連結.
	 * 連結された情報の取得
	 * 
	 * @return String 入力情報
	 */
	public String getInformation() {
		String infomation = this.name +		 this.age + "歳";
		return infomation;
		
	}

}
