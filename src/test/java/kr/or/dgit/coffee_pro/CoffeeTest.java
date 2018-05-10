package kr.or.dgit.coffee_pro;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.coffee_pro.dto.Coffee;
import kr.or.dgit.coffee_pro.dto.CoffeeMng;
import kr.or.dgit.coffee_pro.service.CoffeeService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CoffeeTest {
	private static CoffeeService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new CoffeeService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	
	@Test
	public void test1selectCoffee() {
		
		List<CoffeeMng> cf = service.selectCoffeeTotal();
		for(CoffeeMng c:cf) {
			System.out.println(c);
		}
		
	}
	
}
