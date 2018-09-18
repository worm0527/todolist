package com.example.todolist.controller;

import com.example.todolist.config.ConfiguationTest;
import com.example.todolist.config.YmlConfig;
import com.example.todolist.dao.ReadingListRepo;
import com.example.todolist.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    private ReadingListRepo readingListRepo;

    @Autowired
    private ConfiguationTest.Inner inner;

    @Autowired
    private YmlConfig ymlConfig;

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

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        System.out.println(ymlConfig.getMenus().get(0).getName());
        System.out.println(ymlConfig.getMenus().get(1).getName());
        System.out.println(ymlConfig.getPerson().getAge());
        return inner.toString();
    }

}
