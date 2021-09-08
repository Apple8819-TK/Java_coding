package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson8_2 {

	public static void main(String[] args) {
		// Lesson8_2クラスのインスタンスを生成
		Lesson8_2 m = new Lesson8_2();
		// inputメソッドの呼び出し
		m.input();

	}

	public void input() {
		System.out.println("数字を入力してください");
		// 入力された文字データを変換する橋渡し
		InputStreamReader isr = new InputStreamReader(System.in);
		// 文字データをバッファリング
		BufferedReader br = new BufferedReader(isr);

		try {
			// キーボード入力の受付
			String str = br.readLine();
			// 入力された文字列を数値に変換
			int num = Integer.parseInt(str);

			for (int i = 0; i < num; i++) { // 入力された数値の分処理をループ
				for (int j = 0; j < num; j++) {// 入力された数値の分処理をループ
					if (i == j) { // 外周ループの変数iと内周ループの変数jの値が同じ時「＊」を表示する
						System.out.print("＊");
					} else { // 変数iと変数jが異なる場合は「・」を表示する
						System.out.print("・");
					}
				}
				// 内周ループが終わったら改行
				System.out.println();
			}
		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}
	}

}
