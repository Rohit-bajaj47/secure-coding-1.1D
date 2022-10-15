package edu.deakin.sit218.examgeneration.controller;




import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.deakin.sit218.examgeneration.dao.ExamDAO;
import edu.deakin.sit218.examgeneration.dao.ExamDAOImpl;
import edu.deakin.sit218.examgeneration.entity.Exam;

@Controller
public class QuestionAnswerController {
	final static Logger logger = LogManager.getLogger(QuestionAnswerController.class);

	@GetMapping("/question-answer")
	public String showHome() {
		logger.info("User viewed the question answer page");
		return "question-answer";
	}

	@PostMapping("/push")
	public String pushIntoDb(@RequestParam("ques") String ques, @RequestParam("ans") String ans,
			@RequestParam("att") String att, Model model) {
		
		ExamDAO dao = new ExamDAOImpl();
		try 
		{
			// Create a client object
			Exam exam = new Exam(ques,ans,att);
			if (!dao.existsExam(exam))
			{
				dao.insertExam(exam);
				model.addAttribute("message","Added : " + exam.toString());
				logger.info("question set pushed into the db");

			}
			else
			{
				model.addAttribute("message","Question already exists");
			}
		} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.warn("error while pushing the question set into the db");

		}
		return "question-answer";
	}
}
