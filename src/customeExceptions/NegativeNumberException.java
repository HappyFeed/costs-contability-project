package customeExceptions;

@SuppressWarnings("serial")
public class NegativeNumberException extends Exception{

	double money;
	
	public NegativeNumberException(double money) {
		super("the data inserted is wrong, negative values is not a valid data");
		this.money=money;
	}
	
	public double getMoney() {
		return money;
	}
}
