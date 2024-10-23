package com.sunbeam.model;

enum Status{
	
	success,error;
}



public class Result {
      
	private Status status;
	private String message;
	private Object data;
	
	
	public Result() {
	
	}

	public Result(String message, Object data, Status status) {
		this.message = message;
		this.data = data;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Result [message=" + message + ", data=" + data + ", status=" + status + "]";
	}

 
	public static Result success(Object obj) {
		return new Result(null,obj,Status.success);
	}
	
	public static Result failed(String message) {
		return new Result(message,null,Status.error);
	}
	
}
