package com.yedam;

import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyVO rv = new ReplyVO();
		rv.setBoardNo(224);
		rv.setReply("댓글 테스트");
		rv.setReplyer("user99");
		
        ReplyDAO rdao = new ReplyDAO();
		
		if(rdao.insertReply(rv)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		for(ReplyVO rvo : rdao.selectList(224)){
			System.out.println(rvo.toString());
		}
		
		
		//ReplyDAO rdao = new ReplyDAO();
		
		if(rdao.deleteReply(1)) {
			System.out.println("삭제됨");
		}else {
			System.out.println("삭제안됨");
		}
		for(ReplyVO rvo : rdao.selectList(224)){
			System.out.println(rvo.toString());
		}
	}
}
