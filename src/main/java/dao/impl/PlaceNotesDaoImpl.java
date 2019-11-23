package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototy.IPlaceNotesDao;
import entity.PlaceNotes;

@Repository("placeNotesDaoImpl")
public class PlaceNotesDaoImpl implements IPlaceNotesDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<PlaceNotes> find() {
		return jt.query(
				"SELECT	* FROM	airsys_order o LEFT JOIN airsys_ticket t on o.idcard= t.idcard LEFT JOIN airsys_plan p on p.plan_id = t.plan_id ",
				new BeanPropertyRowMapper<PlaceNotes>(PlaceNotes.class));
	}

	@Override
	public PlaceNotes findByOid(int oid) {
		return jt.queryForObject("SELECT	* FROM	airsys_order o LEFT JOIN airsys_ticket t on o.idcard= t.idcard LEFT JOIN airsys_plan p on p.plan_id = t.plan_id WHERE oid = ?",
								new Object[] {oid},
								new BeanPropertyRowMapper<PlaceNotes>(PlaceNotes.class));
	}

}
