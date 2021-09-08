package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson9 {

	public static void main(String[] args) {
		// Lesson9のインスタンスを生成
		Lesson9 m = new Lesson9();

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

			// calcメッソドに、キーボード入力された二つの数値を引数として渡し その戻り値をint型変数productに代入
			int product = m.calc(num1, num2);
			System.out.println("数字1と数字2の積は" + product + "です");

			// calc2メッソドに引数としてproduct渡し、 その戻り値をint型変数divideに代入
			int divide = m.calc2(product);
			System.out.println("積を2で割った数は" + divide + "です");

		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("例外が発生しました");
		}

	}

	// int型の引数を二つ受け取り、その数値を乗算した結果を返す
	public int calc(int num1, int num2) {
		return num1 * num2;

	}

	// int型の引数を一つ受け取り、その数値を2で除算した結果を返す
	public int calc2(int num) {
		return num / 2;
	}

}
