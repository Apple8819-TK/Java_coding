package java_basis;

class Person {
	private String name;

	public Person() {
		this.name = "名無し";
	}

	public Person(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println("私の名前は " + this.name + " です");
	}
}