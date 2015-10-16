package ch.bnntd.bfh.pgrm.filesexc;

import java.io.IOException;
//TODO replace EmptyFileException with this class
@SuppressWarnings("serial")
public class BadFileDataException extends IOException {

	public BadFileDataException(){};
	
	public BadFileDataException(String message) {
		super(message);
	}
}
