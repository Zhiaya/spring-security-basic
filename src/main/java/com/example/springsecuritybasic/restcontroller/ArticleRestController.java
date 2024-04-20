package com.example.springsecuritybasic.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleRestController {
    //read all
    @GetMapping
    public String getAllArticles() {
        return "All articles";
    }

    //read by id
    @GetMapping("/read/{id}")
    public String readSingleArticle() {
        return "Single article";
    }

    //write (create a new article)
    @PostMapping("/write")
    public String createArticle() {
        return "Article created";
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
        return "Article deleted";
    }

}
