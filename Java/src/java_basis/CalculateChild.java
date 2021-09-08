package java_basis;

public class CalculateChild extends CalculateSuper {

	// int型の引数を二つ受け取るコンストラクタ
	public CalculateChild(int param1, int param2) {
		// 受け取った引数をさらにsuperクラスのコンストラクに引数として渡す
		super(param1, param2);
	}

	// CalculateSuperのflowメソッドをオーバーライド
	protected void flow() {
		// メソッドの呼び出しの順序を変更している
		sub();
		sum();
	}

}
