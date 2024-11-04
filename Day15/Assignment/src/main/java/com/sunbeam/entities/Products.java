package com.sunbeam.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="products")
public class Products {
  
	@Id
	private int id;
	private String name;
	private double price;
	
	  @ManyToOne
	    @JoinColumn(name="category_id")
	private Categories cat;
    
}
