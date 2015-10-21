package ch.bnntd.bfh.prgm.filesexc;

import java.io.IOException;

@SuppressWarnings("serial")
public class EmptyFileException extends IOException {

	public EmptyFileException(){};
	
	public EmptyFileException(String message) {
		super(message);
	}
}
