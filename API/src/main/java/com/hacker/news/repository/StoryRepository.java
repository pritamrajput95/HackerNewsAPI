package com.hacker.news.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacker.news.entity.Story;

@Repository
public interface StoryRepository  extends JpaRepository<Story,Long> {

    List<Story> findBySubmissionTimeBefore(LocalDateTime time);

}
