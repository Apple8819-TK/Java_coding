package point;

import java.util.ArrayList;
import java.util.List;

import common.BusinessException;
import common.InputData;
import common.SystemMessage;
import common.SystemMessage.ID_MESSAGE;

/**
 * 入力情報の管理
 * 
 * @author takumi
 * @param staffList Staff 社員リスト
 * @param inputDate InputData 情報入力
 */
public class StaffManagement {

	// Staffインスタンスのリスト生成用
	List<Staff> staffList = new ArrayList<>();

	// InputDataクラスのインスタンス生成
	InputData inputData = new InputData();

	/**
	 * メニュー番号の入力、及び実行の終了の判定
	 * 
	 * @throws BusinessException 業務例外
	 */
	public void logicMenu() throws BusinessException {

		// 条件一致までループ
		while (true) {
			
			// キーボード入力された数値の代入
			int menuNum1 = inputData.inputInt(ID_MESSAGE.N0001, 0, 1);
			
			// 入力続行か終了の判定
			if (menuNum1 == 0) {
				addStaff();
			} else if (menuNum1 == 1) {
				break;
			}
		}
	}

	/**
	 * メニュー番号の入力
	 * メニュー番号による判定でメソッドの呼び出し
	 * 
	 * @throws BusinessException 業務例外
	 */
	private void addStaff() throws BusinessException {

		// キーボード入力された数値の代入
		int menuNum2 = inputData.inputInt(ID_MESSAGE.N0002, 0, 1);
		
		// 入力された数字により呼び出すメソッドの判定
		if (menuNum2 == 0) {
			addGeneralStaff();
		} else if (menuNum2 == 1) {
			addManagementStaff();
		}
		// メッセージ表記
		SystemMessage.outMessage(ID_MESSAGE.N0007);

		// staffListの要素分繰り返し、各インスタンスの情報を表示
		for (Staff stf : staffList) {
			System.out.println(stf.getInformation());
		}
	}

	/**
	 * 「氏名」「年齢」「職種」の入力
	 * 入力情報を引数にインスタンスの生成
	 * 
	 * @throws BusinessException 業務例外
	 */
	private void addGeneralStaff() throws BusinessException {
		// キーボード入力し、入力された値を各変数に代入
		String name1 = inputData.inputString(ID_MESSAGE.N0003, 10);
		int age1 = inputData.inputInt(ID_MESSAGE.N0004, 0);
		String role = inputData.inputString(ID_MESSAGE.N0005, 5);
		
		// 入力した要素をもとにインスタンスを生成してリストに代入
		staffList.add(new GeneralStaff(name1, age1, role));
	}

	/**
	 * 「氏名」「年齢」「役職」の入力
	 * 入力情報を引数にインスタンスの生成
	 *
	 * @throws BusinessException 業務例外
	 */
	private void addManagementStaff() throws BusinessException {
		// キーボード入力し、入力された値を各変数に代入
		String name2 = inputData.inputString(ID_MESSAGE.N0003, 10);
		int age2 = inputData.inputInt(ID_MESSAGE.N0004, 0);
		String officialTitle = inputData.inputString(ID_MESSAGE.N0006, 5);
		
		// 入力した要素をもとにインスタンスを生成してリストに代入
		staffList.add(new ManagementStaff(name2, age2, officialTitle));
	}

}
