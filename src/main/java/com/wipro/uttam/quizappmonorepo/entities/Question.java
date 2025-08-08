package com.wipro.uttam.quizappmonorepo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Question title is required")
	private String questionTitle;
	@NotBlank(message = "Option1 is required")
	private String option1;
	@NotBlank(message = "Option2 is required")
	private String option2;
	@NotBlank(message = "Option3 is required")
	private String option3;
	@NotBlank(message = "Option4 is required")
	private String option4;
	@NotBlank(message = "Correct answer is required")
	private String correctAnswer;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Difficulty level is required")
	private DifficultyLevel difficultyLevel;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Category is required")
	private Category category;

	public enum DifficultyLevel {
		EASY, MEDIUM, HARD
	}

	public enum Category {
		JAVA, SPRING, GIT, SPRINGBOOT

	}

}
