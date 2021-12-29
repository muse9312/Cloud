package com.ggoreb.practice.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.AnswerRepository;
import com.ggoreb.practice.repository.QuestionRepository;

@Controller
public class QuestionController {
	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

	@GetMapping("/question/list")
	public String question(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		Page<Question> p = questionRepository.findAll(
				PageRequest.of(page - 1, 10, Sort.Direction.DESC, "createDate"));

		List<Question> list = p.getContent();

		model.addAttribute("list", list);
		return "question_list";
	}

	@GetMapping("/question/create")
	public String questionCreate() {
		return "question_create";
	}

	@PostMapping("/question/create")
	public String questionCreatePost(@ModelAttribute Question question, HttpSession session) {
		User user = (User) session.getAttribute("user");
		question.setUser(user);
		question.setCreateDate(new Date());
		questionRepository.save(question);
		return "redirect:/question/list";
	}

	@GetMapping("/question/detail")
	public String questionDetail(Model model, Long id) {
		Optional<Question> opt = questionRepository.findById(id);
		if (opt.isPresent()) {
			model.addAttribute("question", opt.get());

			model.addAttribute("answerList", answerRepository.findByQuestion(opt.get()));
		}
		return "question_detail";

	}

}
