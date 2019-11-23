package dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IPlaceNotesDao;
import entity.PlaceNotes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class PlaceNotesTest {
	@Autowired
	private IPlaceNotesDao placeNotesDao;
	
	
	@Test
	public void testfind() {
		List<PlaceNotes> find = placeNotesDao.find();
		for (PlaceNotes placeNotes : find) {
			System.out.println(placeNotes);
		}
	}
	@Test
	public void testFindOne() {
		PlaceNotes findByOid = placeNotesDao.findByOid(1);
		System.out.println(findByOid);
	}
}
