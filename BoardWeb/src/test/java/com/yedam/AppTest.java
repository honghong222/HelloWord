package com.yedam;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyDAO rdao = new ReplyDAO();
		List<Map<String,Object>> result = rdao.chartDate();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		
		
		
//		ReplyVO rv = new ReplyVO();
//		rv.setBoardNo(224);
//		rv.setReply("댓글 테스트");
//		rv.setReplyer("user99");
//		
//        ReplyDAO rdao = new ReplyDAO();
//		
//		if(rdao.insertReply(rv)) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//		
//		
//		
//		//ReplyDAO rdao = new ReplyDAO();
//		
//		if(rdao.deleteReply(1)) {
//			System.out.println("삭제됨");
//		}else {
//			System.out.println("삭제안됨");
//		}
		
	}
}
