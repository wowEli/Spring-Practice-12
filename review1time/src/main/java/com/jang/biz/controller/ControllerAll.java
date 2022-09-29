package com.jang.biz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jang.biz.listPay.ListPayVO;
import com.jang.biz.listPay.impl.ListPayDAO;
import com.jang.biz.member.MemberVO;
import com.jang.biz.member.impl.MemberDAO;
import com.jang.biz.product.ProductVO;
import com.jang.biz.product.impl.ProductDAO;
import com.jang.biz.review.ReviewVO;
import com.jang.biz.review.impl.ReviewDAO;

@Controller
public class ControllerAll {

	@RequestMapping("/productAll.do")
	public String selectAllProduct(ProductVO vo,ProductDAO dao, ReviewVO rvo,ReviewDAO rdao, Model model) {

		model.addAttribute("pDatas", dao.selectAllProduct(vo)); // 전체 상품
		model.addAttribute("rDatas", rdao.selectAllReview(rvo)); // 전체 댓글

		return "productAll.jsp";
	}

	@RequestMapping("/login.do")
	public String login(MemberVO vo, MemberDAO dao, HttpSession session) {

		MemberVO data = dao.selectOneMember(vo);

		if(data==null) {
			return "login.jsp";
		}
		else {
			session.setAttribute("member", data);
			return "redirect:productAll.do";
		}
	}
	
	@RequestMapping("/insertR.do")
	public String insertReview(ReviewVO vo, ReviewDAO dao, Model model) {
		dao.insertReview(vo);
		return "redirect:productAll.do";
	}
	
	@RequestMapping("/listPay.do")
	public String insertListPay(ListPayVO vo, ListPayDAO dao, Model model) {
		dao.insertListPay(vo);
		return "redirect:productAll.do";
	}
	
	@RequestMapping("/listPayAll.do")
	public String selectAllListPay(ListPayVO lvo, ListPayDAO ldao,ReviewVO rvo, ReviewDAO rdao, Model model) {
		
		ArrayList<ListPayVO> lDatas = ldao.selectAllListPay(lvo); // 로그인 한 회원의 구매목록
		ArrayList<ReviewVO> rDatas =  rdao.selectAllReview_M(rvo); // 로그인 한 회원의 리뷰가 있음
		
		
		for(ListPayVO l: lDatas) {
			for(ReviewVO r: rDatas) {
				if(l.getPpk() == r.getPpk()) {
					l.setFlag(false);
				}
				else {
					l.setFlag(true);
				}
				
			}
		}
		// 리뷰 테이블에 mid와 ppk 랑 구매목록에서 mid 와 ppk가 같아야지만 후기작성이 불가
		// 다르면 후기 작성 가능
		
		model.addAttribute("lDatas", lDatas);
		
		return "listPay.jsp";
	}
	
}
