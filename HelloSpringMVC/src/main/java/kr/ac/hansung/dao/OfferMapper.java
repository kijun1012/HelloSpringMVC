package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Offer;

public class OfferMapper implements RowMapper<Offer> {

	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Offer offer = new Offer();

		offer.setYear(rs.getInt("year"));
		offer.setSemester(rs.getInt("semester"));
		offer.setCode(rs.getString("code"));
		offer.setName(rs.getString("name"));
		offer.setDivision(rs.getString("division"));
		offer.setGrade(rs.getInt("grade"));

		return offer;
	}
}
