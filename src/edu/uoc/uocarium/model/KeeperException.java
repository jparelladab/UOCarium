package edu.uoc.uocarium.model;

public class KeeperException extends Exception {
	public final static String MSG_ERR_TANKS_SIZE = "[ERROR] A keeper cannot take care of more than 5 tanks!!";
	public final static String MSG_ERR_ID_VALUE = "[ERROR] A keeper's id must start with letter 'G'!!";
	public final static String MSG_ERR_ID_LENGTH = "[ERROR] A keeper's id must have 5 characters!!";
	public KeeperException() {
		super();
	}
	public KeeperException(String msg) {
		super(msg);
	}

}
