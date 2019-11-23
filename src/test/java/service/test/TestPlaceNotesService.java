package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.PlaceNotes;
import service.prototy.IPlaceNotesService;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestPlaceNotesService {

	@Autowired
	private IPlaceNotesService placeNotesService;
	
	@Test
	public void testFindAll() {
		List<PlaceNotes> findAll = placeNotesService.findAll();
		for (PlaceNotes placeNotes : findAll) {
			System.out.println(placeNotes);
		}
	}
	@Test
	public void testFindByOid() {
		PlaceNotes findByOid = placeNotesService.findByOid(1);
		System.out.println(findByOid);
	}
	
}
