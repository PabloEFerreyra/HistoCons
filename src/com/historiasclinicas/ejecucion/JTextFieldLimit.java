package com.historiasclinicas.ejecucion;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
public class JTextFieldLimit extends PlainDocument {
	/**
	 *
	 */
	private static final long serialVersionUID = -233919011095708792L;

	private final int limit;
	public JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	public void insertString( int offset, String  str, javax.swing.text.AttributeSet attr ) throws BadLocationException {
		if (str == null) return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}
