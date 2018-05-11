package kr.or.dgit.coffee_pro.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.coffee_pro.MyBatisSqlSessionFactory;
import kr.or.dgit.coffee_pro.dto.CoffeeMng;




public class CoffeeService {
	private static final Log log = LogFactory.getLog(CoffeeService.class);
	private String namespace = "kr.or.dgit.coffee_pro.dao.CoffeeDao.";
	
	
	public String selectCoffeeName(String cName) {
		log.debug("selectCoffeeName()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			String res = sqlSession.selectOne(namespace+"selectCoffeeName",cName);
			return res;
		}
	}
	public int insertCoffee(CoffeeMng coffee) {
		log.debug("inSertCoffee()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			int res = sqlSession.insert(namespace + "insertcoffee",coffee);
			sqlSession.commit();
			return res;
		}
	}
	public List<CoffeeMng> selectCoffeeTotal(){
		log.debug("selectCoffeeTotal()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			List<CoffeeMng> res = sqlSession.selectList(namespace+"selectCoffeeTotal");
			return res;
		}
	}
	public List<CoffeeMng> selectCoffeeMargin(){
		log.debug("selectCoffeeMargin()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			List<CoffeeMng> res = sqlSession.selectList(namespace+"selectCoffeeMargin");
			return res;
		}
	}
	public List<CoffeeMng> selectCoffeeAll(){
		log.debug("selectCoffeeAll()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			List<CoffeeMng> res = sqlSession.selectList(namespace+"selectCoffeeAll");
			return res;
		}
	}
	public void updateCoffee(CoffeeMng coffee){
		log.debug("updateCoffee()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			sqlSession.update(namespace+"updateCoffee",coffee);
			sqlSession.commit();
		}
	}
	public void deleteCoffee(String cCode){
		log.debug("deleteCoffee()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			sqlSession.delete(namespace+"deleteCoffee",cCode);
			sqlSession.commit();
		}
	}
}
