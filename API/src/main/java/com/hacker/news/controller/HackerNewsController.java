package com.hacker.news.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.news.entity.Comment;
import com.hacker.news.entity.Story;
import com.hacker.news.service.NewsService;

@RestController
public class HackerNewsController {
  
	@Autowired
	NewsService newsService;
	
	 @PostMapping("/create-story")
	    public Story createStory(@RequestBody Story newStory) {
	        return newsService.createStory(newStory);
	    }

	    @PostMapping("/add-comment")
	    public Comment addCommentToStory( @RequestBody Comment newComment) {
	      
	    	return newsService.addCommentToStory(newComment);
	    }
	    
    @GetMapping("/top-stories")
    public List<Story> getTopStories() {
    	
        return this.newsService.getTopStories();
    }

    @GetMapping("/past-stories")
    public List<Story> getPastStories() {
       
        return  this.newsService.getPastStories();
    }

    @GetMapping("/comments/{storyId}")
    public List<Comment> getCommentsForStory(@PathVariable Long storyId) {
        
        return this.newsService.getCommentsForStory(storyId);
    }
}

