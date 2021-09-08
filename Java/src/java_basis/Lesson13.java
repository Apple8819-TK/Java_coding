package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson13 {

	public static void main(String[] args) {

		System.out.println("2つの同じ言葉を入力してください。");

		try {

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				System.out.println("一つ目");

				// キーボード入力を受け付ける
				String str1 = br.readLine();

				System.out.println("二つ目");

				// キーボード入力を受け付ける
				String str2 = br.readLine();

				if (str1.equals("") || str2.equals("")) { // str1またはstr2が空文字だったら、改行して入力に戻る
					System.out.println();

				} else if (str1.equals(str2)) { // str1とstr2が同じ文字列なら「同じ言葉です」を表示してbreakでループを抜ける
					System.out.println("同じ言葉です。");
					break;

				} else { // それ以外の場合は「違う言葉です。同じ言葉で入力してください。」と表示し、改行して入力に戻る
					System.out.println("違う言葉です。同じ言葉で入力してください。");
					System.out.println();
				}
			}
		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}
		System.out.println("終了");

	}

}
