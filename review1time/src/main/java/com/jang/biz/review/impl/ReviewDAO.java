package com.jang.biz.review.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.jang.biz.review.ReviewVO;

@Repository("ReviewDAO")
public class ReviewDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_insert="INSERT INTO REVIEW (TITLE,CONTENT,MID,PPK)VALUE(?,?,?,?)";
	final String sql_selectAll="SELECT * FROM REVIEW";
	final String sql_selectAll_M="SELECT * FROM REVIEW WHERE MID =?";
	final String sql_selectOne="SELECT * FROM REVIEW WHERE PPK=? AND MID=?";
	
	public void insertReview(ReviewVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getMid());
			pstmt.setInt(4, vo.getPpk());
			int num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public ReviewVO selectOneReview(ReviewVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getPpk());
			pstmt.setString(2, vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			ReviewVO vo1 = new ReviewVO();
			if(rs.next()) {
				vo1.setRpk(rs.getInt("RPK"));
				vo1.setTitle(rs.getString("TITLE"));
				vo1.setContent(rs.getString("CONTENT"));
				vo1.setMid(rs.getNString("MID"));
				vo1.setPpk(rs.getInt("PPK"));
				return vo1;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
	
	public ArrayList<ReviewVO> selectAllReview_M(ReviewVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		
		ArrayList<ReviewVO> datas = new ArrayList<ReviewVO>();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll_M);
			pstmt.setString(1, vo.getMid());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo1 = new ReviewVO();
				vo1.setRpk(rs.getInt("RPK"));
				vo1.setTitle(rs.getString("TITLE"));
				vo1.setContent(rs.getString("CONTENT"));
				vo1.setMid(rs.getNString("MID"));
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
	
	public ArrayList<ReviewVO> selectAllReview(ReviewVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		
		ArrayList<ReviewVO> datas = new ArrayList<ReviewVO>();
		
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewVO vo1 = new ReviewVO();
				vo1.setRpk(rs.getInt("RPK"));
				vo1.setTitle(rs.getString("TITLE"));
				vo1.setContent(rs.getString("CONTENT"));
				vo1.setMid(rs.getNString("MID"));
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
