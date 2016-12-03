package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.GradesService;

@Controller
public class gradesController {

	private GradesService gradesService;

	@Autowired
	public void setGradesService(GradesService gradesService) {
		this.gradesService = gradesService;
	}
	
	/* ��� ���� ���*/
	@RequestMapping("/grades") 
	public String showGrades(Model model) {

		List<Offer> offers = gradesService.getCurrent();

		model.addAttribute("offers", offers);
		return "grades";
	}

	/* �б⺰ �̼� ���� ��ȸ*/
	@RequestMapping("/semestergrade")
	public String semesterGrade(Model model) {
		
		List<Offer> semesterList = gradesService.getAllGradeBySemester();
		model.addAttribute("allgradebysemester",semesterList);
		return "semestergrade";
	}
	
	/*���� �б⺰ ���� ����Ʈ*/
	@RequestMapping(value = "/semestergradedetail" , method = RequestMethod.GET)
	public String semesterGradeDetail(int year, int semester, Model model){
		
		List<Offer> selectSemesterList = gradesService.getSelectGradeBySemester(year, semester);
		model.addAttribute("selectsemester",selectSemesterList);
		
		
		return "semestergradedetail";
	}

	/* �̼� ���к� ���� ��ȸ*/
	@RequestMapping("/divisiongrade")
	public String divisionGrade(Model model) {
		List<Offer> gradeList = gradesService.getDivisionGrade();
		model.addAttribute("gradebydivision", gradeList);
		// System.out.println(offers);
		return "divisiongrade";
	}
	
	/*���� ��û �ϱ�*/
	@RequestMapping("/registercourse")
	public String registerGrade(Model model) {
		return "registercourse";
	}
	
	/*���� ��û �Ϸ�*/
	@RequestMapping("/doregistercourse")
	public String doRegisterCourse(Model model, Offer offer){
		offer.setYear(2017);
		offer.setSemester(1);
		
		
		gradesService.insert(offer);
		
		return "registeredcourse";
	}

	/* ���� ��û ��ȸ*/
	@RequestMapping("/checkregister")
	public String checkRegister(Model model) {
		List<Offer> checkRegisterList = gradesService.getSelectGradeBySemester(2017, 1);
		model.addAttribute("checkregister",checkRegisterList);
		return "checkregister";
	}

}
