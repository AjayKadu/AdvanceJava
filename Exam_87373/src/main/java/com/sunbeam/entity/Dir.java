package com.sunbeam.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dir {
    
	private String name;
	private String email;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date date;
	private String password;
}
