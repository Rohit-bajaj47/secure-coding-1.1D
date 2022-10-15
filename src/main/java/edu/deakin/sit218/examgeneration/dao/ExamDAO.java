package edu.deakin.sit218.examgeneration.dao;

import java.util.List;

import edu.deakin.sit218.examgeneration.entity.Exam;

public interface ExamDAO {
	public void updateExam(Exam exam);
	public void insertExam(Exam exam);
	public List<Exam> retrieveExam(String att);
	public boolean existsExam(Exam exam);
}
