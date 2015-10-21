package ch.bnntd.bfh.prgm.filesexc;

import java.io.IOException;

@SuppressWarnings("serial")
public class WrongLineFormatException extends IOException {

	public WrongLineFormatException(){};
	
	public WrongLineFormatException(String message) {
		super(message);
	}
}
