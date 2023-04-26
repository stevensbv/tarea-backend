package com.beltran.repository;

import com.beltran.models.Movie;
import com.beltran.models.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepo extends IGenericRepo<Movie,Integer>{

}
