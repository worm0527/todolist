package com.example.todolist.controller;

import com.example.todolist.dao.ReadingListRepo;
import com.example.todolist.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    private ReadingListRepo readingListRepo;

    @GetMapping(value = "/{reader}")
    public String readersBooks(@PathVariable String reader, Model model) {
        List<Book> books = readingListRepo.findByReader(reader);
        if (books != null) {
            model.addAttribute("books", books);
        }
        return "readingList";
    }

    @PostMapping(value="/{reader}")
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepo.save(book);
        return "redirect:/{reader}";
    }

}
