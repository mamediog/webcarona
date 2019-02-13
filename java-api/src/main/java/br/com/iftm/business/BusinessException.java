package br.com.iftm.business;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	public BusinessException(String message) {
		super(message);
	}
}
