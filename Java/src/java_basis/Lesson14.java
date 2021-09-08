package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lesson14 {

	public static void main(String[] args) {

		int total = 0;

		// Integer型のArrayListを生成
		ArrayList<Integer> array = new ArrayList<>();

		System.out.println("平均を表示したい値を入力してください。");
		System.out.println("平均を表示したい値を全て入力したら「OK」を入力してください。");

		try {

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);

			// 終了条件を満たすまでループ
			while (true) {
				System.out.println("数字か「OK」を入力してください。");

				// キーボード入力を受け付ける
				String str = br.readLine();

				if (str.equals("OK")) { // 入力された文字列が「OK」だった場合、ループを終了
					break;
				} else if (str.equals("")) { // 入力された文字列が空文字だった場合、入力に戻る
					continue;
				} else { // 入力された文字列が数字だった場合
					// 文字列を数値に変換してからArrayListに入れる
					// 数値に変換できない文字列の場合、例外が発生
					array.add(Integer.parseInt(str));
				}
			}

		} catch (NumberFormatException e) { // OKまたは数値以外が入力された場合ここでcatch
			System.out.println("数字以外が入力されました。入力を終了します");

		} catch (IOException e) { // 入力で例外が発生した場合の処理
			System.out.println("入出力で例外が発生しました");
		}

		// 拡張for文でarrayの中身を一つずつ取り出して表示
		for (int i : array) {
			System.out.println(i);
			// arrayの中身を一つずつ変数totalに加算
			total += i;
		}
		// arrayの数値を合計した変数totalをarrayの要素の数で除算
		System.out.println("入力した値の平均は：" + total / array.size());

	}

}
