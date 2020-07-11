package com.chinaedu.factory;

import com.chinaedu.food.Chicken;
import com.chinaedu.food.Fish;
import com.chinaedu.food.Food;
import com.chinaedu.food.Td;

/**
 * 简单工厂类，此类用于创建食材
 * @author Administrator
 *
 */
public class FoodFactory {
	
	public static Food createFood(String foodName) {
		
		if("fish".equals(foodName)) {
			return new Fish();
		}
		if("chicken".equals(foodName)) {
			return new Chicken();
		}
		if("td".equals(foodName)) {
			return new Td();
		}
		return null;
	}
}
