package com.cscs.cscore.repository;

import com.cscs.cscore.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ScoreRepository extends JpaRepository<Score, Long>, QuerydslPredicateExecutor<Score> {
}
