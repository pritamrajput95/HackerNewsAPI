package com.hacker.news.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacker.news.entity.Comment;
import com.hacker.news.entity.Story;
import com.hacker.news.repository.CommentRepository;
import com.hacker.news.repository.StoryRepository;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private  StoryRepository storyRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public List<Story> getTopStories() {

		LocalDateTime fifteenMinutesAgo;
    	fifteenMinutesAgo= LocalDateTime.now().minus(15, ChronoUnit.MINUTES);
    	System.out.println("fifteenMinutesAgo>>>>>>>>"+fifteenMinutesAgo);
        List<Story> topStoriesInLast15Minutes;
        
        topStoriesInLast15Minutes= storyRepository.findAll().stream()
                .filter(story -> story.getSubmissionTime().isAfter(fifteenMinutesAgo))
                .sorted(Comparator.comparingInt(Story::getScore).reversed())
                .limit(10)
                .collect(Collectors.toList());
        
    	System.out.println("topStoriesInLast15Minutes>>>>>>>>"+topStoriesInLast15Minutes);

        return topStoriesInLast15Minutes;
	}

	@Override
	public List<Story> getPastStories() {
		
		return storyRepository.findAll();
	}

	@Override
	public List<Comment> getCommentsForStory(String storyId) {
	
      return commentRepository.findByStoryId(storyId);
     
	}

}
