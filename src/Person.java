
public class Person {
	public String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this.name.equals(((Person)other).name)) {
			return true;
		}
		return false;
	}
}

