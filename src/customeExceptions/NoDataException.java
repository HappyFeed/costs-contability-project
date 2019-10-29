package customeExceptions;

@SuppressWarnings("serial")
public class NoDataException extends Exception{

	String data;
	
	public NoDataException(String data) {
		super("the data inserted is wrong, null is not a valid data");
		this.data=data;
	}
	
	public String getData() {
		return data;
	}
}
