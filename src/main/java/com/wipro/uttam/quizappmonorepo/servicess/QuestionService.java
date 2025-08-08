package com.wipro.uttam.quizappmonorepo.servicess;

import java.util.List;

import com.wipro.uttam.quizappmonorepo.entities.Question;

public interface QuestionService {
	Question createQuestion(Question question);
    Question getQuestionById(long id);
    List<Question> getAllQuestions();
    Question updateQuestion(long id, Question question);
    void deleteQuestion(long id);
}
