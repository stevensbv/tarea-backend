package com.beltran.repository;

import com.beltran.models.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepo extends IGenericRepo<Person,Integer>{

}
