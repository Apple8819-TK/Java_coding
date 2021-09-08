package java_basis;

class CalculateSuper {
	// フィールド変数
	protected int param1;
	protected int param2;

	// コンストラクタ
	// 引数を二つ受け取りそれぞれの値をフィールドに代入
	protected CalculateSuper(int param1, int param2) {
		this.param1 = param1;
		this.param2 = param2;
	}

	// sumメソッドとsubメソッドを呼び出すメソッド
	protected void flow() {
		sum();
		sub();
	}

	// 変数param1とparam2を加算した結果を表示
	protected void sum() {
		System.out.println(param1 + "と" + param2 + "足すと" + (param1 + param2));
	}

	// 変数param1とparam2を減算した結果を表示
	protected void sub() {
		System.out.println(param1 + "と" + param2 + "引くと" + (param1 - param2));
	}
}