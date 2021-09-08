package java_basis;

public class Lesson11 {

	public static void main(String[] args) {
		
		// CalculateSuperクラスのインスタンスをint型の引数を二つ渡して生成
		CalculateSuper c1 = new CalculateSuper(5, 3);
		// CalculateSuperクラスのflowメソッドを呼び出し
		c1.flow();
		
		//CalculateChildクラスのインスタンスをint型の引数を二つ渡して生成
		CalculateChild c2 = new CalculateChild(10, 7);
		// CalculateChildクラスのflowメソッドを呼び出し
		c2.flow();
	}

}
