package com.hacker.news.exception;

public class StoryNotFoundException extends RuntimeException {

	public StoryNotFoundException(String msg) {
		
		super(msg);
	}
}

