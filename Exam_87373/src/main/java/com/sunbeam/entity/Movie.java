package com.sunbeam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_tb")
public class Movie {
    
	@Id
	private int m_id;
	private String movie_name;
	private String actor;
	private String actress;
	private double rating;
	
	
	public Movie() {
		
	}
	
	public Movie(int m_id, String movie_name, String actor, String actress, double rating) {
		this.m_id = m_id;
		this.movie_name = movie_name;
		this.actor = actor;
		this.actress = actress;
		this.rating = rating;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [m_id=" + m_id + ", movie_name=" + movie_name + ", actor=" + actor + ", actress=" + actress
				+ ", rating=" + rating + "]";
	}
	
	
	
}
