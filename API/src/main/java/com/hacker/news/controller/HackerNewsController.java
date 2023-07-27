package com.hacker.news.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.news.entity.Comment;
import com.hacker.news.entity.Story;
import com.hacker.news.service.NewsService;

@RestController
public class HackerNewsController {
  
	@Autowired
	NewsService newsService;
	
    @GetMapping("/top-stories")
    public List<Story> getTopStories() {
    	
        return this.newsService.getTopStories();
    }

    @GetMapping("/past-stories")
    public List<Story> getPastStories() {
       
        return  this.newsService.getPastStories();
    }

    @GetMapping("/comments/{storyId}")
    public List<Comment> getCommentsForStory(@PathVariable String storyId) {
        
        return this.newsService.getCommentsForStory(storyId);
    }
}

