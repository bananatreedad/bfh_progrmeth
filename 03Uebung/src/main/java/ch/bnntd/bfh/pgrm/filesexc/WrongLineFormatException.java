package ch.bnntd.bfh.pgrm.filesexc;

import java.io.IOException;

@SuppressWarnings("serial")
public class WrongLineFormatException extends IOException {

	public WrongLineFormatException(){};
	
	public WrongLineFormatException(String message) {
		super(message);
	}
}
