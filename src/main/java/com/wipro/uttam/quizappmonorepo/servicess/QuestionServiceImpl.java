package com.wipro.uttam.quizappmonorepo.servicess;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.uttam.quizappmonorepo.entities.Question;
import com.wipro.uttam.quizappmonorepo.exceptions.QuestionNotFoundException;
import com.wipro.uttam.quizappmonorepo.reepositorys.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	
	private final QuestionRepository questionRepository;

	@Override
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question getQuestionById(long id) {
		return questionRepository.findById(id)
				.orElseThrow(() -> new QuestionNotFoundException("Question with ID " + id + " not found"));
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question updateQuestion(long id, Question question) {
		Question existing = getQuestionById(id);

		if (question.getQuestionTitle() != null)
			existing.setQuestionTitle(question.getQuestionTitle());
		if (question.getOption1() != null)
			existing.setOption1(question.getOption1());
		if (question.getOption2() != null)
			existing.setOption2(question.getOption2());
		if (question.getOption3() != null)
			existing.setOption3(question.getOption3());
		if (question.getOption4() != null)
			existing.setOption4(question.getOption4());
		if (question.getCorrectAnswer() != null)
			existing.setCorrectAnswer(question.getCorrectAnswer());
		if (question.getDifficultyLevel() != null)
			existing.setDifficultyLevel(question.getDifficultyLevel());
		if (question.getCategory() != null)
			existing.setCategory(question.getCategory());

		return questionRepository.save(existing);
	}

	@Override
	public void deleteQuestion(long id) {
		if (!questionRepository.existsById(id)) {
			throw new QuestionNotFoundException("Cannot delete. Question with ID " + id + " does not exist");
		}
		questionRepository.deleteById(id);
	}

}
