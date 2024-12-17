package com.yedam.Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class RemoveCalendarControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 삭제
		String title = req.getParameter("title");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		
		ReplyDAO rdao = new ReplyDAO();
		
		
		if(rdao.deleteEvent(title,start_date,end_date)) {
			// {"retCode":"OK"}
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}else {
			// {"retCode":"Fail"}
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}

	}

}
