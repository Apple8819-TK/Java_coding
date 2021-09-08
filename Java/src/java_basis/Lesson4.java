package java_basis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesson4 {
	public static void main(String[] args) {
		
		System.out.println("数字を入力してください");
		System.out.println("「100」を入力した数字で除算します");

		try {

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);
			// キーボード入力を受け付ける
			String str = br.readLine();

			// 入力された文字列を数値に変換
			// 入力された文字列が数字以外だった場合、例外が発生しcatchされる
			int num = Integer.parseInt(str);

			if (num == 0) { // 入力された数値が0だった場合
				throw new ArithmeticException();
			}
			// 100を入力された数値で除算して代入
			int number = 100 / num;
			System.out.println("答えは" + number);

		} catch (ArithmeticException e) {
			System.out.println("0で除算できません。");
		} catch (NumberFormatException e) {
			System.out.println("数字以外が入力されました。");
		} catch (IOException e) {
			System.out.println("キーボード入力で例外が発生しました");
		} finally {
			System.out.println("終了");
		}
	}
}
