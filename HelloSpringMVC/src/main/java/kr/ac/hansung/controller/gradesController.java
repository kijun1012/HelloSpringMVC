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
	
	/* 모든 정보 출력*/
	@RequestMapping("/grades") 
	public String showGrades(Model model) {

		List<Offer> offers = gradesService.getCurrent();

		model.addAttribute("offers", offers);
		return "grades";
	}

	/* 학기별 이수 학점 조회*/
	@RequestMapping("/semestergrade")
	public String semesterGrade(Model model) {
		
		List<Offer> semesterList = gradesService.getAllGradeBySemester();
		model.addAttribute("allgradebysemester",semesterList);
		return "semestergrade";
	}
	
	/*선택 학기별 과목 리스트*/
	@RequestMapping(value = "/semestergradedetail" , method = RequestMethod.GET)
	public String semesterGradeDetail(int year, int semester, Model model){
		
		List<Offer> selectSemesterList = gradesService.getSelectGradeBySemester(year, semester);
		model.addAttribute("selectsemester",selectSemesterList);
		
		
		return "semestergradedetail";
	}

	/* 이수 구분별 학점 조회*/
	@RequestMapping("/divisiongrade")
	public String divisionGrade(Model model) {
		List<Offer> gradeList = gradesService.getDivisionGrade();
		model.addAttribute("gradebydivision", gradeList);
		// System.out.println(offers);
		return "divisiongrade";
	}
	
	/*수강 신청 하기*/
	@RequestMapping("/registercourse")
	public String registerGrade(Model model) {
		return "registercourse";
	}
	
	/*수강 신청 완료*/
	@RequestMapping("/doregistercourse")
	public String doRegisterCourse(Model model, Offer offer){
		offer.setYear(2017);
		offer.setSemester(1);
		
		
		gradesService.insert(offer);
		
		return "registeredcourse";
	}

	/* 수강 신청 조회*/
	@RequestMapping("/checkregister")
	public String checkRegister(Model model) {
		List<Offer> checkRegisterList = gradesService.getSelectGradeBySemester(2017, 1);
		model.addAttribute("checkregister",checkRegisterList);
		return "checkregister";
	}

}
