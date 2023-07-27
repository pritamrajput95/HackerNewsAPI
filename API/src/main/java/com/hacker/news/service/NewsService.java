package com.hacker.news.service;

import java.util.List;

import com.hacker.news.entity.Comment;
import com.hacker.news.entity.Story;

public interface NewsService {

	List<Story> getTopStories();

	List<Story> getPastStories();

	List<Comment> getCommentsForStory(String storyId);

}
