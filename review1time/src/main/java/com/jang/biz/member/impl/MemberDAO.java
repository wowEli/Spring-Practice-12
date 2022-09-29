package com.jang.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.jang.biz.member.MemberVO;

@Repository("MemberDAO")
public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	final String sql_login ="SELECT * FROM MEMBER WHERE MID = ? AND MPW = ?";
	
	public MemberVO selectOneMember(MemberVO vo) {
		conn = com.jang.biz.common.JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_login);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			
			ResultSet rs = pstmt.executeQuery();
			MemberVO vo1 = new MemberVO();
			
			if(rs.next()) {
				vo1.setMid(rs.getString("MID"));
				vo1.setMpw(rs.getString("MPW"));
				return vo1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			com.jang.biz.common.JDBCUtil.disconnect(pstmt, conn);
		}
		
		return null;
	}
}
