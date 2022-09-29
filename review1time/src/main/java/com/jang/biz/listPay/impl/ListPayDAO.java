package com.jang.biz.listPay.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jang.biz.listPay.ListPayVO;

public class ListPayDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_selectAll="SELECT * FROM LISTPAY WHERE MID=? ORDER BY LPK DESC";
	final String sql_insert="INSERT INTO LISTPAY (MID,PPK)VALUE (?,?)";
	
	public void insertListPay(ListPayVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getPpk());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public ArrayList<ListPayVO> selectAllListPay(ListPayVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		
		ArrayList<ListPayVO> datas = new ArrayList<ListPayVO>();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setString(1, vo.getMid());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ListPayVO vo1 = new ListPayVO();
				vo1.setLpk(rs.getInt("LPK"));
				vo1.setMid(rs.getString("MID"));
				vo1.setPpk(rs.getInt("PPK"));
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

