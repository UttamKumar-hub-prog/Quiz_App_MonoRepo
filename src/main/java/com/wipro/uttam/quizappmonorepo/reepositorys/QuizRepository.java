package com.wipro.uttam.quizappmonorepo.reepositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.uttam.quizappmonorepo.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // No need to declare findById – inherited from JpaRepository
}
