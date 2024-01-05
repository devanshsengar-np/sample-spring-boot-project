package com.devtiro.dbprep.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.devtiro.dbprep.domain.Book;

public interface BookRepository extends CrudRepository<Book, String>,
        PagingAndSortingRepository<Book, String> {
    // List<Book> listBooks();
}
