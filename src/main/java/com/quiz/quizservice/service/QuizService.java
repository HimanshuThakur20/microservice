package com.quiz.quizservice.service;

import com.quiz.quizservice.entity.Question;
import com.quiz.quizservice.entity.Quiz;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public interface QuizService {
    Mono<Quiz> addQuiz(Quiz quiz);

    Flux<Quiz> getAllQuiz();

    Mono<Quiz> getQuizById(long quizId);
    Flux<Question> fetchQuestionsFromQuestionService(long quizId);
}
