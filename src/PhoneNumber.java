
public class PhoneNumber {

	public String number;

	public PhoneNumber(String number) {
		this.number = number;
	}
	
	@Override
	public int hashCode() {
		return number.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this.number.equals(((PhoneNumber)other).number)) {
			return true;
		}
		return false;
	}
}