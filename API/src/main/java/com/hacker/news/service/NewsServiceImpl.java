package com.hacker.news.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacker.news.entity.Comment;
import com.hacker.news.entity.Story;
import com.hacker.news.exception.StoryNotFoundException;
import com.hacker.news.repository.CommentRepository;
import com.hacker.news.repository.StoryRepository;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private CommentRepository commentRepository;

	private List<Story> topStories;
	private List<Comment> comments;
	@Override
	public List<Story> getTopStories() {
		LocalDateTime fifteenMinutesAgo = LocalDateTime.now().minus(15, ChronoUnit.MINUTES);
		System.out.println("fifteenMinutesAgo>>>>>>>>" + fifteenMinutesAgo);

		topStories = storyRepository.findAll().stream()
				.filter(story -> story.getSubmissionTime().isAfter(fifteenMinutesAgo))
				.sorted(Comparator.comparingInt(Story::getScore).reversed()).limit(10).collect(Collectors.toList());
		System.out.println("topStoriesInLast15Minutes>>>>>>>>" + topStories);
		return topStories;
	}

	@Override
	public List<Story> getPastStories() {

		return topStories;
	}

	@Override
	public List<Comment> getCommentsForStory(Long storyId) {
     
		
        comments = commentRepository.findByStoryId(storyId);

        // Sort the comments by childComments in descending order.
        comments.sort(Comparator.comparingInt(Comment::getChildComments).reversed());

        // Return at most 10 comments.
        return comments.stream().limit(10).collect(Collectors.toList());
       }

	@Override
	public Story createStory(Story newStory) {
		
		newStory.setSubmissionTime(LocalDateTime.now());
		
		return storyRepository.save(newStory);
	}

	@Override
	public Comment addCommentToStory(Comment newComment) {
		 Long storyId = newComment.getStoryId();
		 if (storyId == null) {
		        throw new IllegalArgumentException("Comment must have a valid storyId.");
		    }
		 
		   storyRepository.findById(storyId).orElseThrow(() -> new StoryNotFoundException("Story not found for ID: " + storyId));

	 	    return commentRepository.save(newComment);
	}


}
