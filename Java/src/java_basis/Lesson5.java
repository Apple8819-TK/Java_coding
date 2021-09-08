package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson5 {
	public static void main(String[] args) {
		
		System.out.println("0~6の数字を入力し、対応した曜日を表示してください");
		System.out.println("整数を入力してください");

		try {
			
			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);
			
			// キーボード入力を受け付ける
			String str = br.readLine();
			
			// 文字列をint型に変換。数値以外の場合例外が発生
			int num = Integer.parseInt(str);
			
			//switch分による条件判定。numの値と一致する条件を表示
			switch (num) {
			case 0:
				System.out.println("日曜日");
				break;
			case 1:
				System.out.println("月曜日");
				break;
			case 2:
				System.out.println("火曜日");
				break;
			case 3:
				System.out.println("水曜日");
				break;
			case 4:
				System.out.println("木曜日");
				break;
			case 5:
				System.out.println("金曜日");
				break;
			case 6:
				System.out.println("土曜日");
				break;
			default: // 0~6以外の数値が入力された場合の処理
				System.out.println("0~6の範囲で入力してください");
			}

		} catch (NumberFormatException e) { //数値以外が入力された場合の例外をcatch
			System.out.println("数字以外が入力されました");

		}  catch (IOException e) {
			System.out.println("入出力で例外が発生しました");
		}

	}

}
