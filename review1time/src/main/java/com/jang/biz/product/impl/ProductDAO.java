package com.jang.biz.product.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.jang.biz.product.ProductVO;

@Repository("ProductDAO")
public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_selectAll="SELECT * FROM PRODUCT";
	
	public ArrayList<ProductVO> selectAllProduct(ProductVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo1 = new ProductVO();
				vo1.setPpk(rs.getInt("PPK"));
				vo1.setPname(rs.getString("PNAME"));
				vo1.setPrice(rs.getInt("PRICE"));
				datas.add(vo1);
			}
			
			return datas;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
		
		return null;
	}
}
