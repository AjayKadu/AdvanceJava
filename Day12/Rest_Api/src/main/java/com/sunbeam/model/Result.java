package com.sunbeam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

enum Status{
	
	success,error;
}


@JsonInclude(Include.NON_NULL)
public class Result {
      
	private Status status;
	
	@JsonProperty("Info")
	private String message;
	private Object data;
	
	@JsonIgnore
	private String remark;
	
	
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
