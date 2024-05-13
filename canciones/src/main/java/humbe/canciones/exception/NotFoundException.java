package humbe.canciones.exception;

public class NotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String menssage) {
		super(menssage);
	}

}
