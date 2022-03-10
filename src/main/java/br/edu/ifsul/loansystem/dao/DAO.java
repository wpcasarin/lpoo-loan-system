package br.edu.ifsul.loansystem.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Integer create(T t);

    Integer update(T t);

    Integer delete(Long id);

    List<T> findAll();

    Optional<T> findById(Long id);

}
