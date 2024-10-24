package com.sunbeam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

enum Status1{
	success,error
}

@JsonInclude(Include.NON_NULL)
public class CustResult {
     
	private Status1 status;
	private String message;
	private Object data;
	
	public CustResult() {
		// TODO Auto-generated constructor stub
	}

	public CustResult(Status1 status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Status1 getStatus() {
		return status;
	}

	public void setStatus(Status1 status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CustResult [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	public static CustResult success(Object obj) {
		return new CustResult(Status1.success,null,obj);
	}
	
	public static CustResult failed(String message) {
		return new CustResult(Status1.error,message,null);
	}
}
