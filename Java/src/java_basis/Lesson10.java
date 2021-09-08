package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson10 {
	public static void main(String[] args) {

		System.out.println("ここでは名前を入力しません");

		// Personクラスのインスタンスを引数なしで生成
		Person p = new Person();
		// PersonクラスのprintNameメソッドを呼び出してコンソールに表示
		p.printName();

		try {

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);

			System.out.print("名前を入力してください：");
			// キーボード入力の受付
			String str = br.readLine();

			// Personクラスのインスタンスを引数ありで生成
			Person p1 = new Person(str); // 引数にはキーボード入力された文字列を渡す
			// PersonクラスのprintNameメソッドを呼び出してコンソールに表示
			p1.printName();

		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}
	}

}
