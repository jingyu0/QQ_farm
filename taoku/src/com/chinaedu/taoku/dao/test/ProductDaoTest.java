package com.chinaedu.taoku.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chinaedu.taoku.dao.ProductDao;
import com.chinaedu.taoku.pojo.Product;

public class ProductDaoTest {
	
	ProductDao dao;
	@Before
	public void setUp() throws Exception {
		System.out.println("setUP..");
		dao = new ProductDao();
		
	}

	@Test
	public void testFindProduct() {
		List<Product> data =  dao.findProduct();
		for (Product product : data) {
			System.out.println(product);
		}
	}
	
	@Test
	public void testAddProduct() {
		
		
		List<Product> data =  dao.findProduct();
	}

}
