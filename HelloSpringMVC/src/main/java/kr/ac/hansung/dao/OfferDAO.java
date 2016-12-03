package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;

@Repository
public class OfferDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from mygrade";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);

	}

	// querying and returning a single object
	public Offer getOffer(String code) {
		String sqlStatement = " select * from mygrade where code =?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { code }, new OfferMapper());
	}

	// querying and returning multiple objects
	public List<Offer> getOffers() {
		String sqlStatement = " select * from mygrade";
		return jdbcTemplateObject.query(sqlStatement, new OfferMapper());
	}

	/* DB insert */
	public boolean insert(Offer offer) {
		String sqlStatement = "insert into mygrade values(?,?,?,?,?,?)";
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, division, grade }) == 1);

	}

	/* DB update */
	public boolean update(Offer offer) {
		String sqlStatement = "update mygrade set year=?,semester=?,name=?,division=?,grade=? where code=?";
		int year = offer.getYear();
		int semester = offer.getSemester();
		String code = offer.getCode();
		String name = offer.getName();
		String division = offer.getDivision();
		int grade = offer.getGrade();
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, name, division, grade, code }) == 1);

	}

	/* DB delete */
	public boolean delete(String code) {
		String sqlStatement = "delete from mygrade where code=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { code }) == 1);
	}

	/* 전체 학기별 이수 학점 */
	public List<Offer> getAllGradeBySemester() {
		String sqlStatement = "select year,semester,sum(grade) from mygrade group by year,semester";

		List<Offer> SemesterList = jdbcTemplateObject.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setYear(rs.getInt("year"));
				offer.setSemester(rs.getInt("semester"));
				offer.setGrade(rs.getInt("sum(grade)"));
				return offer;
			}
		});
		return SemesterList;
	}

	/* 특정 학기별 과목 리스트 */
	public List<Offer> getGradeBySemester(int year, int semester) {
		String sqlStatement = "select * from mygrade where year=? and  semester=?";

		List<Offer> selectSemesterList = jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester },
				new OfferMapper());
		return selectSemesterList;
	}

	/* 이수 구분별 학점 조회 */
	public List<Offer> getGradeByDivision() {
		String sqlStatement = " select division,sum(grade) from mygrade group by division ";

		List<Offer> gradeList = jdbcTemplateObject.query(sqlStatement, new RowMapper<Offer>() {

			@Override
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setDivision(rs.getString("division"));
				offer.setGrade(rs.getInt("sum(grade)"));
				return offer;
			}
		});
		return gradeList;
	}

}
