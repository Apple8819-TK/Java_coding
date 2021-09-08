package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson2 {

	public static void main(String[] args) {
		
		//文字列の出力
		System.out.println("整数を入力してください");

		try {
			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);
			
			// キーボード入力を受け付ける
			String str = br.readLine();
			// 文字列をint型に変換
			int num = Integer.parseInt(str);

			if (num % 2 == 0) { // 入力された数字が偶数の場合
				//文字列の出力
				System.out.println("偶数です");

			} else { // 入力された数字が奇数の場合
				//文字列の出力
				System.out.println("奇数です");
			}

		} catch (IOException e) { //　例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}
	}
}
