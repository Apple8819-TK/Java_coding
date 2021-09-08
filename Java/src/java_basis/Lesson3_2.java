package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson3_2 {
	public static void main(String[] args) {
		// 文字列の出力
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

					// 外周ループの変数iと内周ループの変数jの値が同じ時「＊」を表示する
					// 変数iと変数jが異なる場合は「・」を表示する (三項演算子を使用)
					System.out.print(i == j ? "*" : "・");
				}
				System.out.println();
			}
			// 内周ループが終わったら改行
			System.out.println();

		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}

	}
}
