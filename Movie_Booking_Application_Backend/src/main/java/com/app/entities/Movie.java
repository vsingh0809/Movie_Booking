package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String title;
    private String genre;
    private Integer duration; 
    private String language;
    private LocalDate releaseDate;
    private String descripton;
    @OneToMany(mappedBy ="movie",fetch= FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Show> show;
    
}
