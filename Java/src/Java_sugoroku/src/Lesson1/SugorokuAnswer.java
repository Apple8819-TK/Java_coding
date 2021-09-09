package Lesson1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * プレイヤーの名前、人数を扱うクラス
 * 
 * @author takumi
 * @version 1.0
 */
class Player {

	// フィールド変数
	public String name;
	public int num;

	/**
	 * Playerコンストラクタ
	 * 
	 * @param name 引数、文字列
	 */
	Player(String name) {
		// 受け取った引数と"Player"を連結してnameフィールドに代入
		this.name = "Player" + name;
		// numフィールドには0を代入
		this.num = 0;
	}

	/**
	 * setNameメソッド 引数をフィールド変数nameに代入
	 * 
	 * @param name 引数、文字列
	 */
	public void setName(String name) {
		// 受け取った引数をフィールド変数nameに代入
		this.name = name;
	}

	/**
	 * getNameメソッド
	 * 
	 * @return フィールド変数nameの文字列
	 */
	public String getName() {
		// フィールド変数nameを返す
		return this.name;
	}

	/**
	 * addNumメソッド
	 * 
	 * @param num 引数
	 */
	public void addNum(int num) {
		// 引数をフィールド変数nameに加算
		this.num += num;
	}

	/**
	 * getNumメソッド
	 * 
	 * @return フィールド変数numの数値
	 */
	public int getNum() {
		// フィールド変数numを返す
		return this.num;
	}
}

/**
 * エントリーポイントを持つクラス
 * 
 * @author takumi
 * @version 1.0
 */
public class SugorokuAnswer {
	// Player型を扱うListクラスのフィールド変数
	List<Player> playerList = new ArrayList<Player>();
	// フィールド変数
	int GOAL;
	// staticなフィールド変数
	static int count = 0;

	/**
	 * メイン 各インスタンスの生成やメソッドを呼び出して結果を出力する
	 * 
	 * @throws キーボード入出力時に例外が発生する可能性
	 */
	public static void main(String[] args) {

		try {
			System.out.printf("参加するプレイヤーの人数を入力してください:");

			// 入力された文字データを変換する橋渡し
			InputStreamReader isr = new InputStreamReader(System.in);
			// 文字データをバッファリング
			BufferedReader br = new BufferedReader(isr);

			// キーボード入力を受け付ける。参加する人数を入れる
			String input = br.readLine();
			// 入力された文字列を数値に変換して代入
			int playerNum = Integer.parseInt(input);

			// SugorokuAnswerクラスのインスタンスの生成
			SugorokuAnswer sugo = new SugorokuAnswer();

			//
			for (int i = 0; i < playerNum; i++) { // 参加人数の回数ループ
				// PlayerListの中に番号「i+1」のPlayerインスタンスを生成して入れる
				sugo.playerList.add(new Player(String.valueOf(i + 1)));
			}

			System.out.printf("ゴールまでのマスの数:");

			// キーボード入力を受け付ける。ゴールまでのマスの数を入力
			input = br.readLine();
			// 入力された文字列を数値に変換して変数GOALに代入
			sugo.GOAL = Integer.parseInt(input);
			System.out.println(""); // 改行

			// ローカル変数
			int isEnd = 0;

			// ここからすごろくゲームのループ
			while (isEnd == 0 && !input.equals("q")) { // 条件が一致するまでループ

				// 変数isEndにsugorokuメソッドの戻り値を入れる(０か1が帰ってくる)
				// 1が返ってきたきた場合ループを抜ける
				isEnd = sugo.sugoroku();
				System.out.printf("終了する場合は q を入力してください:");

				// キーボード入力で「q」を入力するとループが終了する
				input = br.readLine();
				System.out.println("");

				// 変数countの値をインクリメントで＋1する
				count++;
			}

			/*
			 * 二重ループ。 このコードで変数numの大きい順にソート
			 */
			for (int i = 0; i < sugo.playerList.size() - 1; i++) { // 外周ループ
				for (int j = 0; j < sugo.playerList.size() - 1; j++) { // 内周ループ

					/*
					 * j番目のPlayerインスタンスの変数numとj+1番目の変数numを比較し、 前者の値の方が小さければif文の処理を実行
					 */
					if (sugo.playerList.get(j).getNum() < sugo.playerList.get(j + 1).getNum()) {

						// Playerインスタンスを生成。
						Player temp = new Player("temp");
						// 変数tempにplayerListに格納されているj番目のPlayerインスタンスを代入
						temp = sugo.playerList.get(j);

						// playerListのj番目にj+1番目の要素を上書き
						sugo.playerList.set(j, sugo.playerList.get(j + 1));

						// playerListのj+1番目にtempに入れたj番目のインスタンスを入れる
						sugo.playerList.set(j + 1, temp);
						// 上記の処理によりj番目の要素とj+1番目の要素が入れ替わる

					}
				}
			}

			System.out.println("順位発表");

			// 参加人数の回数ループさせて順位を表示
			for (int i = 0; i < playerNum; i++) {
				System.out.println((i + 1) + "位:" + sugo.playerList.get(i).getName() + ","
						+ sugo.playerList.get(i).getNum() + "マス");
			}

		} catch (Exception e) {
			System.out.println("例外：" + e);
		}
	}

	/**
	 * sugorokuメソッド Playerクラスのフィールドnumに整数値を加算 <br>
	 * 0か1を返す
	 * 
	 * @return 変数finish 整数値
	 */
	public int sugoroku() {
		// ローカル変数
		int finish = 0;

		for (int i = 0; i < playerList.size(); i++) { // 参加人数分ループ

			/*
			 * i番目のPlayerインスタンスのaddNumメソッドの引数にsaikoroメソッドの戻り値を入れる
			 * addNumメソッドは受け取った引数の数値をフィールド変数numに入れる
			 */
			playerList.get(i).addNum(saikoro());

			System.out.println(playerList.get(i).getName() + " は " + playerList.get(i).getNum() + " まで進みました ");

			// もしインスタンス変数numの値が変数GOAL以上の場合は、
			// 変数finishに1を入れる
			if (playerList.get(i).getNum() >= GOAL) {
				finish = 1;
			}
		}
		return finish;
	}

	/**
	 * saikoroメソッド
	 * 
	 * @return 除算した整数値
	 */
	public int saikoro() {
		return (count % 6);
	}
}
