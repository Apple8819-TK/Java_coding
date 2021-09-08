package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson7 {

	public static void main(String[] args) {
		System.out.println("整数を昇順で並び替えます。");
		System.out.println("5個の整数を入力してください。");

		// 5つのint型の配列インスタンスを生成
		int[] num = new int[5];

		try {

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);

			// for文でループさせて5回文字入力の受付
			for (int i = 0, j = 1; i < 5; i++) {

				System.out.print(j++ + "個目の整数：");
				String str = br.readLine();

				// i番目の配列にキーボードで入力された値を代入
				num[i] = Integer.parseInt(str);
			}

		} catch (IOException e) { // 例外が発生した場合の処理
			System.out.println("例外が発生しました");
		}

		// 二重ループで配列の値を昇順でソート
		for (int i = 0; i < num.length - 1; i++) { // ループ回数は配列の数から1引いた回数

			for (int j = 0; j < num.length - i - 1; j++) { // ループを繰り返すごとにさらにi分引いていく
				
				// 配列numのj番目の要素とj+1番目の要素を比較。j番目の方が大きければif文内の処理を実行
				if (num[j] > num[j + 1]) {
					int temp = num[j]; // 一時的にこのtempにj番目の値を補完
					num[j] = num[j + 1]; // j番目にj+1番目の要素を代入
					num[j + 1] = temp; // 補完していた元のj番目の要素を代入
					// 上記の処理にてj番目に小さい値が、j+1番目に大き値が入る
				}
			}
		}

		// for文で配列の中身を一つずつ取り出して表示
		for (int number : num) {
			System.out.println(number + " ");
		}
		// 配列の中身は昇順でソートされているので、配列の最初と最後がそれぞれ最小値と最大値になっている
		System.out.println("最大値は" + num[4] + "で、" + "最小値は" + num[0] + "です");

	}

}
