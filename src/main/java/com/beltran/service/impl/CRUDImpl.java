package com.beltran.service.impl;

import com.beltran.exception.ModelNotFoundException;
import com.beltran.repository.IGenericRepo;
import com.beltran.service.ICRUD;
import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {


    String mesanje;
    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) {
        findById(id);
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
    return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NO ENCONTRADO "+id));
    }
    @Override
    public void deleteById(ID id) {
        findById(id);
        getRepo().deleteById(id);
    }
}
