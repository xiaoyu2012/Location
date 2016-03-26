package test;

import org.junit.Test;

import service.AlarmInfoService;
import service.AlarmInfoServiceImpl;

public class AlarmInfoTest {
	
	@Test
	public void changeState() {
		AlarmInfoService ais = new AlarmInfoServiceImpl();
		ais.chageState(3, 2);
	}

}
