package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class GradesService {

	private OfferDAO offerDao;

	@Autowired
	public void setOfferDao(OfferDAO offerDao) {
		this.offerDao = offerDao;
	}

	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}

	/* 이수 구분별 학점 조회 */
	public List<Offer> getDivisionGrade() {
		int sumPoint = 0;
		List<Offer> gradeList = offerDao.getGradeByDivision();
		for (Offer data : gradeList) {
			sumPoint += data.getGrade();
		}

		Offer sumData = new Offer();
		sumData.setDivision("총학점");
		sumData.setGrade(sumPoint);
		gradeList.add(sumData);

		return gradeList;
	}

	/* 전체 학기별 이수 학점 */
	public List<Offer> getAllGradeBySemester() {
		List<Offer> semesterList = offerDao.getAllGradeBySemester();

		return semesterList;
	}

	/* 선택 학기별 과목 리스트 */
	public List<Offer> getSelectGradeBySemester(int year, int semester) {
		List<Offer> selectSemesterList = offerDao.getGradeBySemester(year, semester);
		return selectSemesterList;
	}

	/* 수강 신청 과목 insert */
	public void insert(Offer offer) {
		offerDao.insert(offer);

	}
}
