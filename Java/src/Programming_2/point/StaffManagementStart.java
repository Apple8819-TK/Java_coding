package point;

import common.BusinessException;

/**
 * エントリーポイントを持つクラス
 * 
 * @author takumi
 */
public class StaffManagementStart {
	/**
	 * mainメソッド
	 * 
	 * @throws BusinessException
	 */
	public static void main(String[] args) {
		
		// StaffManagementクラスのインスタンスを生成
		StaffManagement staff = new StaffManagement();
		// logicMenuメソッドの呼び出し
		try {
			staff.logicMenu();
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

}
