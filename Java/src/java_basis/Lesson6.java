package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson6 {

	public static void main(String[] args) {
		// 5つのString型の配列インスタンスを生成
		String[] str = new String[5];

		try {
			
			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);
			
			// for文でループさせて5回文字入力の受付
			for (int j = 0, i = 0; j < 5; i++) {
				System.out.println("文字を入力してください" + (i + 1) + "個目");

				// i番目の配列にキーボードで入力された値を代入
				str[i] = br.readLine();
			}

		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}
		
		System.out.print("入力した文字は");
		
		for (String s : str) { // 拡張for文でstrの中身を一つずつ取り出して表示
			System.out.print(s);
			System.out.print(" ");
		}
	}

}
