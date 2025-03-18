package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
