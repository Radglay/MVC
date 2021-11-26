package com.grupa5.biblioteka.repository;

import com.grupa5.biblioteka.model.Book;
import com.grupa5.biblioteka.model.User;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {


}
