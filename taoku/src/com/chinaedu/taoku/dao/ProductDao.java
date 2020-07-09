package com.chinaedu.taoku.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chinaedu.taoku.pojo.Product;
import com.chinaedu.taoku.utils.DbUtil;

public class ProductDao {

	
	public List<Product> findProduct() {
		
		//sql���
		String sql = "select * from product limit 0, 12";

		List<Product> products = new ArrayList<Product>();
		
		try {
			//��������
			Connection conn = DbUtil.open();
			//�����������
			PreparedStatement pst = conn.prepareStatement(sql);
			
			//ִ������
			ResultSet set = pst.executeQuery();
			
			
			while(set.next()) {
				//��ȡ�������ÿһ�е�ֵ
				int pid = set.getInt("pid");
				String pname = set.getString("pname");
				int pprice = set.getInt("pprice");
				int ppricezk = set.getInt("ppricezk");
				String pimg = set.getString("pimg");
				String pdes = set.getString("pdes");
				int pcata = set.getInt("pcata");
				//���ݻ�ȡ��ֵ����һ������
				Product p= new Product();
				p.setPcata(pcata);
				p.setPdes(pdes);
				p.setPid(pid);
				p.setPimg(pimg);
				p.setPname(pname);
				p.setPprice(pprice);
				p.setPpricezk(ppricezk);
				//����Ʒ���뼯����
				products.add(p);
					
			}			
			//�ر�����
			DbUtil.close(null, pst, conn);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return products;
	}
}
