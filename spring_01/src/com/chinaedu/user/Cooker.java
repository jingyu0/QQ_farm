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

	//��⿷���
	public void cook() {
		
		//���������㣺�����Ҫ�޸�ʳ�ģ���ô��ʦ��Ĵ�����ҪƵ�����޸�
		//��Ĵ���Υ���������������ԭ��OCP(����:����չ���ţ����޸Ĺر�)ԭ��
		//���ģʽ:һ�׹̶�����·
		//����ģʽ(�򵥹���ģʽ)
		
		
//		Food chk = new Chicken();
//		Food fish = new Fish();
//		Food td = new Td();

		String food = PropertiesUtil.read();
		Food td = FoodFactory.createFood(food);
		
		System.out.println("��ʦ��"+td);
	}
	
}
