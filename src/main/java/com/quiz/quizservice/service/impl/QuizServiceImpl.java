package com.quiz.quizservice.service.impl;

import com.quiz.quizservice.entity.Question;
import com.quiz.quizservice.entity.Quiz;
import com.quiz.quizservice.repository.QuizRepository;
import com.quiz.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Mono<Quiz> addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Flux<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Mono<Quiz> getQuizById(long quizId) {
        return quizRepository.findById(quizId);
    }


    @Autowired
    private WebClient.Builder webClientBuilder;


    @Override
    public Flux<Question> fetchQuestionsFromQuestionService(long quizId) {
        return webClientBuilder.build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http") // Add the scheme
                        .host("localhost") // Add the host
                        .port(8081) // Add the port of questionservice
                        .path("/question/questions")
                        .queryParam("quizId", quizId)
                        .build())
                .retrieve()
                .bodyToFlux(Question.class);
    }
}
