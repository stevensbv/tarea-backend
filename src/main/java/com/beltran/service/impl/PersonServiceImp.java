package com.beltran.service.impl;

import com.beltran.models.Person;
import com.beltran.repository.IGenericRepo;
import com.beltran.repository.IPersonRepo;
import com.beltran.service.IPersonService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImp extends CRUDImpl<Person,Integer> implements IPersonService{

    private final IPersonRepo repo;

    @Override
    protected IGenericRepo<Person, Integer> getRepo() {
        return repo;
    }
}
