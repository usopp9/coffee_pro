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

	//@Test
	public void testAselectSaleByAll() {
		
		List<CoffeeMng> cf = service.selectCoffeeAll();
		for(CoffeeMng c:cf) {
			System.out.println(c);
		}
		
	}
	//@Test
	public void testBselectSaleByNo() {
		
		String cf = service.selectCoffeeName("A001");
		System.out.println(cf);
		
	}
	//@Test
	public void testCinsertProduct() {
		
		CoffeeMng cf = new CoffeeMng();
		cf.setcCode(new Coffee("A001"));
		cf.setcPrice(2500);
		cf.setcCount(150);
		cf.setcMargin(11);
		service.insertCoffee(cf);	
	}
	//@Test
	public void testDupdateProduct() {
		CoffeeMng cf = new CoffeeMng();
		cf.setcCode(new Coffee("A001"));
		cf.setcPrice(2500);
		cf.setcCount(150);
		cf.setcMargin(11);
		service.updateCoffee(cf);
	}
	//@Test
	public void testEdeleteProduct() {
		service.deleteCoffee("A001");
	}
	//@Test
	public void testFcallSaleDetail() {
		
		List<CoffeeMng> cf = service.selectCoffeeMargin();
		for(CoffeeMng c:cf) {
			System.out.println(c);
		}	
	}
	//@Test
	public void testGcallgetTotal() {
		
		List<CoffeeMng> cf = service.selectCoffeeTotal();
		for(CoffeeMng c:cf) {
			System.out.println(c);
		}	
	}
}
