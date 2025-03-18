package com.app.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MovieDto {
	 private String title;
	    private String genre;
	    private Integer duration; 
	    private String language;
	    private LocalDate releaseDate;
	    private String descripton;
}
