package kr.or.dgit.coffee_pro.dao;

import java.util.List;

import kr.or.dgit.coffee_pro.dto.CoffeeMng;

public interface CoffeeDao {
	public String selectCoffeeName(String cCode);
	public int insertCoffee(CoffeeMng coffee);
	public List<CoffeeMng> selectCoffeeTotal();
	public List<CoffeeMng> selectCoffeeMargin();
	public List<CoffeeMng> selectCoffeeAll();
	public void updateCoffee(CoffeeMng coffee);
	public void deleteCoffee(String cCode);
}
