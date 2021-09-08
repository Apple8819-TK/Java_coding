package java_basis;

public class subCalc implements AreaCalc {// AreaCalcインタフェースを実装
	// AreaCalcインタフェースのメソッドをオーバーライド

	public int sankaku(int a, int b) {
		return a * b;
	}

	public int shikaku(int a, int b) {
		return (a * b) / 2;
	}

}
