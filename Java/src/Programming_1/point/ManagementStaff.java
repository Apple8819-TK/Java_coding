package point;

/**
 * Staffクラスのサブクラス. 入力情報の保持. 管理職
 * 
 * @author takumi
 */
public class ManagementStaff extends Staff {

	String officialTitle;

	/**
	 * コンストラクタ
	 * 
	 * @param name          String 氏名
	 * @param age           int 年齢
	 * @param officialTitle String 役職
	 */
	public ManagementStaff(String name, int age, String officialTitle) {
		// スーパクラスのコンストラクタに引数を代入
		super(name, age);

		this.officialTitle = officialTitle;
	}

	/**
	 * フィールド変数officialTitleの取得
	 * 
	 * @return String 役職
	 */
	public String getOfficialTitle() {
		return this.officialTitle;
	}

	/**
	 * 引数をフィールド変数officialTitleに代入
	 * 
	 * @param officialTitle String 役職
	 */
	public void setOfficialTitle(String officialTitle) {
		this.officialTitle = officialTitle;
	}

	/**
	 * 変数に入力された情報を連結. 連結された情報の取得
	 * 
	 * @return String 入力情報
	 */
	public String getInformation() {
		String infomation = this.name + "\t\t" + this.age + "歳" + "\t\t" + this.officialTitle;
		return infomation;

	}

}
