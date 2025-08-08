package com.wipro.uttam.quizappmonorepo.servicess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.uttam.quizappmonorepo.entities.Question;
import com.wipro.uttam.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.uttam.quizappmonorepo.entities.Quiz;
import com.wipro.uttam.quizappmonorepo.entities.Response;
import com.wipro.uttam.quizappmonorepo.reepositorys.QuestionRepository;
import com.wipro.uttam.quizappmonorepo.reepositorys.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl {

    private final QuizRepository quizRepo;
    private final QuestionRepository questionRepo;

    public Quiz createQuiz(String category, String level, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategoryAndLevel(category, level);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        return quizRepo.save(quiz);
    }

    public List<QuestionWrapper> getQuizQuestions(Long id) {
        Quiz quiz = quizRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<QuestionWrapper> wrapperList = new ArrayList<QuestionWrapper>();
        List<Question> questions = quiz.getQuestions();

        for (Question q : questions) {
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(q.getId());
            qw.setQuestionTitle(q.getQuestionTitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            wrapperList.add(qw);
        }

        return wrapperList;
    }

    public Integer calculateResult(Long id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        List<Question> questions = quiz.getQuestions();
        int score = 0;

        for (Response response : responses) {
            for (Question question : questions) {
                if (question.getId().equals(response.getId())
                        && question.getCorrectAnswer().equalsIgnoreCase(response.getUserAnswer())) {
                    score++;
                    break;
                }
            }
        }

        return score;
    }

}
