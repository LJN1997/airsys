package dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import dao.prototy.IAirsysDao;
import entity.Ticket;
import entity.UserSelect;
import entity.UserSelectAll;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestAirsysDao {
	@Autowired
	private IAirsysDao asDao;
	
	@Test
	public void testFind() {
		List<UserSelectAll> fgt = asDao.find("2019-11-06","太原", "北京");
		for (Object o : fgt) {
			System.out.println(o);
		}
	}
	
	@Test
	public void testFindAll() {
		List<UserSelectAll> fgt = asDao.findAll();
		for (Object o : fgt) {
			System.out.println(o);
		}
	}
	@Test
	public void testDelete() {
		asDao.delete(1,2,"economy_class_remain_seats");
	}
	@Test
	public void testSaveOrUpdate() {
		asDao.saveOrUpdate(new Ticket("50","成人",550,2,1), 2, "economy_class_remain_seats");
	}
	
}
