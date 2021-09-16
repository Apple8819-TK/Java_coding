package point;

/**
 * Staffクラスのサブクラス.
 * 入力情報の保持.
 * 一般社員
 * 
 * @author takumi
 */
public class GeneralStaff extends Staff{
	
	String role;
	
	/**
	 * コンストラクタ
	 * 
	 * @param name String 氏名
	 * @param age int 年齢
	 * @param role String 職種
	 */
	public GeneralStaff(String name, int age, String role) {
		// スーパクラスのコンストラクタに引数を渡す
		super(name, age);
		this.role = role;
	}
	
	/**
	 * フィールド変数roleの取得
	 * 
	 * @return String 職種
	 */
	public String getRole() {
		return this.role;
	}
	
	/**
	 * 引数をフィールド変数roleに代入
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * 変数に入力された情報を連結.
	 * 連結された情報の取得
	 * 
	 * @return String 入力情報
	 */
	public String getInformation() {
		String infomation = this.name + "\t\t" + this.age + "歳" + "\t\t" + this.role;
		return infomation;
		
	}

}
