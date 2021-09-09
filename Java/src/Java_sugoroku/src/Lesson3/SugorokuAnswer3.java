package Lesson3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * プレイヤーの名前、人数を扱うクラス
 * 
 * @author takumi
 * @version 2.0
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
	 * @param num 引数、整数値
	 */
	public void addNum(int num) {
		// 引数をフィールド変数nameに加算
		this.num += num;
	}

	/**
	 * setNumメソッド
	 * 
	 * @param num、文字列
	 */
	public void setNum(int num) {
		// 受け取った引数をフィールド変数nameに代入
		this.num = num;
	}

	/**
	 * getNumメソッド
	 * 
	 * @return フィールド変数numの整数
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
 * @version 2.0
 */
public class SugorokuAnswer3 {
	// Player型を扱うListクラスのフィールド変数
	List<Player> playerList = new ArrayList<Player>();

	// フィールド変数
	int GOAL;

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
			SugorokuAnswer3 sugo = new SugorokuAnswer3();

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
			}

			// 二重ループ。 このコードで変数numの大きい順にソート
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
	 * 0か1を戻り値で返す
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

			// 下のif文で使うローカル変数
			int masu1;
			int masu2;
			int masu3;

			// もし進んだマスの数がGOALを超えてしまったら
			if (GOAL < playerList.get(i).getNum()) {
				masu1 = playerList.get(i).getNum(); // 変数aに、getNum(進んだマスの合計)の値を一時的に保管
				masu2 = masu1 - GOAL; // 変数bに、進んだマスの数から変数GOAL分のマスを引いた値を代入
				masu3 = GOAL - masu2; // 変数cに、変数GOALからbマス分引いた値を代入
				// 上記の計算でGOALを超えたマス分戻ることになる

				// 変数cの値をフィールド変数numに入れる
				playerList.get(i).setNum(masu3);

				// もしnumの値がマイナスになった場合はnumに0が入る
				if (playerList.get(i).getNum() < 0) {
					playerList.get(i).setNum(0);
				}

				System.out.println(playerList.get(i).getName() + " はゴールを超えたので" + masu2 + "マス分戻りました");
				System.out.println(playerList.get(i).getName() + " は " + playerList.get(i).getNum() + " まで進みました ");

				// もしGOALと進んだマスの合計がイコールだったら、変数finishに1を代入
			} else if (GOAL == playerList.get(i).getNum()) {

				System.out.println(playerList.get(i).getName() + " は " + playerList.get(i).getNum() + " まで進みました ");
				System.out.println(playerList.get(i).getName() + " は ゴールしました");

				finish = 1;

			} else { // 上記の選択肢に当てはまらない場合は
				System.out.println(playerList.get(i).getName() + " は " + playerList.get(i).getNum() + " まで進みました ");
			}
		}
		return finish;
	}

	/**
	 * saikoroメソッド 1~6の整数値をランダムに生成
	 * 
	 * @return 変数diesを返す
	 */
	public int saikoro() {
		// ランダムで1〜6の数字を取得
		int dies = new Random().nextInt(6) + 1;
		return (dies);
	}
}
