package com.ggoreb.practice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ggoreb.practice.model.Answer;
import com.ggoreb.practice.model.FileAtch;
import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.AnswerRepository;
import com.ggoreb.practice.repository.FileAtchRepository;
import com.ggoreb.practice.repository.QuestionRepository;
import com.ggoreb.practice.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	FileAtchRepository fileAtchRepository;
	@Autowired
	QuestionService questionService;
	@Autowired
	QuestionRepository questionRepository;

	@GetMapping("/question/list")
	public String question(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {

		List<Question> list = questionService.getQuestionList(page);

		model.addAttribute("list", list);
		return "question_list";
	}

	@GetMapping("/question/create")
	public String questionCreate() {
		return "question_create";
	}

	@PostMapping("/question/create")
	public String questionCreatePost(@ModelAttribute Question question, HttpSession session,
			@RequestParam("image") MultipartFile image) {
		try {
			image.transferTo(new File("../img" + image.getOriginalFilename()));
		} catch (IllegalStateException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		User user = (User) session.getAttribute("user");
		questionService.addQuestion(question, user, image.getOriginalFilename());

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

	@PostMapping("/answer/create")
	public String answerCreatePost(
			@ModelAttribute Answer answer, @RequestParam Long question_id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		answer.setUser(user);
		answer.setCreateDate(new Date());
		Question question = questionRepository.findById(question_id).get();
		answer.setQuestion(question);
		answerRepository.save(answer);
		return "redirect:/question/ditail?id=" + question_id;
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> download(Long id) throws Exception {
		Question question = questionRepository.findById(id).get();
		FileAtch fileAtch = fileAtchRepository.findByQuestion(question);
		String fileName = fileAtch.getFileName();
		File file = new File("c:/study/" + fileName);

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity.ok()
				.header("content-disposition",
						"filename=" + URLEncoder.encode(file.getName(), "utf-8"))
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				// .contentType(MediaType.parseMediaType("image/png"))
				.body(resource);
	}
}
