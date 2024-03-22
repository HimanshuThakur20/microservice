package com.quiz.quizservice.controller;

import com.quiz.quizservice.entity.Question;
import com.quiz.quizservice.entity.Quiz;
import com.quiz.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;



@RestController
@RequestMapping("/quiz")
public class QuizController {


@Autowired
private QuizService quizService;

@PostMapping
    public Mono<Quiz> addQuiz(@RequestBody Quiz quiz){
    return quizService.addQuiz(quiz);
}

@GetMapping
    public Flux<Quiz> getAllQuiz(){
    return quizService.getAllQuiz();
}

@GetMapping("/{quizId}")
    public Mono<Quiz> getQuizById(@PathVariable String quizId){
        return quizService.getQuizById(Long.parseLong(quizId));
    }




    @GetMapping("/questions")
    public Flux<Question> getQuiz(@RequestParam Long quizId) {
        return quizService.fetchQuestionsFromQuestionService(quizId);
    }


}
