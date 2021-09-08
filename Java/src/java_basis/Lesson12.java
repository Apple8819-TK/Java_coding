package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson12 {
	public static void main(String[] args) {
		// subCalcクラスのインスタンスを生成
		subCalc sub = new subCalc();

		System.out.println("数字を2つ入力してください");
		System.out.println("入力した数字の積とそれを2で割った数を計算します");

		try {

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);

			System.out.println("数字1");

			// キーボード入力を受け付ける
			String str1 = br.readLine();
			// 文字列をint型に変換
			int num1 = Integer.parseInt(str1);

			System.out.println("数字2");

			// キーボード入力を受け付ける
			String str2 = br.readLine();
			// 文字列をint型に変換
			int num2 = Integer.parseInt(str2);

			// sankakuメソッドにキーボード入力された二つの数値を引数として渡し、
			// その戻り値をint型変数productに代入
			int product = sub.sankaku(num1, num2);

			// shikakuメッソドにキーボード入力された二つの数値を引数として渡し
			// その戻り値をint型変数divideに代入
			int divide = sub.shikaku(num1, num2);

			System.out.println("数字1と数字2の積は" + product + ", 積を2で割った数は" + divide + "です");

		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}
	}

}
