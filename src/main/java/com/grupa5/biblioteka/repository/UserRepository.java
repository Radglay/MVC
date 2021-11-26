package com.grupa5.biblioteka.repository;

import com.grupa5.biblioteka.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    @Query("SELECT u FROM User u")
    List<User> findAllQUERY();

}
