package edu.deakin.sit218.examgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.deakin.sit218.examgeneration.dao.ExamDAO;
import edu.deakin.sit218.examgeneration.dao.ExamDAOImpl;
import edu.deakin.sit218.examgeneration.entity.Exam;

@Controller
public class ExamGenController {
	final static Logger logger = LogManager.getLogger(ExamGenController.class);

	@GetMapping("/examgen")
	public String showHome() {
		logger.info("User viewed the exam generation page");
		return "examgen";
	}

	@PostMapping("/find")
	public String viewResults(@RequestParam("att") String att, Model model) 
	{

		ExamDAO dao = new ExamDAOImpl();

		try 
		{
			// Create a client object
			List<Exam> exams = dao.retrieveExam(att);
			if (exams.isEmpty())
			{
				logger.error("No question found relevant to search keyword");
				exams.add(new Exam("No question with '" + att + "' as the knowldge area found","",""));
				model.addAttribute("exams", exams);
			}
			else
			{
				model.addAttribute("exams",exams);
				logger.error("Results pushed to the view layer");
			}
			
		} 
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "examgen";
	}
}
