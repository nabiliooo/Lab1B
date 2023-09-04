
public class SocSecException extends Exception{

	public SocSecException(String error) {
		super("ERROR: Invalid Social Security Number, " + error);
	}
}