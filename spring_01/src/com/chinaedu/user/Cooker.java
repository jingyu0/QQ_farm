package com.chinaedu.user;

import com.chinaedu.factory.FoodFactory;
import com.chinaedu.food.Food;
import com.chinaedu.food.Td;
import com.chinaedu.utils.PropertiesUtil;

/**
 * 
 * @author Administrator
 *
 */
public class Cooker {

	//烹饪方法
	public void cook() {
		
		//代码的问题点：如果需要修改食材，那么厨师类的代码需要频繁的修改
		//你的代码违背了面向对象的设计原则：OCP(开闭:对扩展开放，对修改关闭)原则
		//设计模式:一套固定的套路
		//工厂模式(简单工厂模式)
		
		
//		Food chk = new Chicken();
//		Food fish = new Fish();
//		Food td = new Td();

		String food = PropertiesUtil.read();
		Food td = FoodFactory.createFood(food);
		
		System.out.println("厨师煮："+td);
	}
	
}
