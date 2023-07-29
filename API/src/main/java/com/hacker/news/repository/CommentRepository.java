package com.hacker.news.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hacker.news.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long > {

	List<Comment> findByStoryId(Long storyId);

    
}
