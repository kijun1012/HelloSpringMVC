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

	/* �̼� ���к� ���� ��ȸ */
	public List<Offer> getDivisionGrade() {
		int sumPoint = 0;
		List<Offer> gradeList = offerDao.getGradeByDivision();
		for (Offer data : gradeList) {
			sumPoint += data.getGrade();
		}

		Offer sumData = new Offer();
		sumData.setDivision("������");
		sumData.setGrade(sumPoint);
		gradeList.add(sumData);

		return gradeList;
	}

	/* ��ü �б⺰ �̼� ���� */
	public List<Offer> getAllGradeBySemester() {
		List<Offer> semesterList = offerDao.getAllGradeBySemester();

		return semesterList;
	}

	/* ���� �б⺰ ���� ����Ʈ */
	public List<Offer> getSelectGradeBySemester(int year, int semester) {
		List<Offer> selectSemesterList = offerDao.getGradeBySemester(year, semester);
		return selectSemesterList;
	}

	/* ���� ��û ���� insert */
	public void insert(Offer offer) {
		offerDao.insert(offer);

	}
}
