package exception;

public class RefInvalidException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RefInvalidException(String msgExpcEmploye) {
		super(msgExpcEmploye +"**");
	}

}
