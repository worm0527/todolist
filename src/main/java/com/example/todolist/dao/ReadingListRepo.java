package com.example.todolist.dao;

import com.example.todolist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepo extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);

}
