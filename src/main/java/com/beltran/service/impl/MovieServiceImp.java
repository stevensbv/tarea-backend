package com.beltran.service.impl;

import com.beltran.models.Movie;
import com.beltran.repository.IGenericRepo;
import com.beltran.repository.IMovieRepo;
import com.beltran.service.IMovieService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImp extends CRUDImpl<Movie,Integer> implements IMovieService{

    private final IMovieRepo repo;

    @Override
    protected IGenericRepo<Movie, Integer> getRepo() {
        return repo;
    }
}
