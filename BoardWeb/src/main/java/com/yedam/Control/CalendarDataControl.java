package com.yedam.Control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class CalendarDataControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fullcalendar data => json 출력
		resp.setContentType("text/json;charset=utf-8");
		
		ReplyDAO rdao = new ReplyDAO();
		List<Map<String,Object>> result = rdao.calendarData();
		System.out.println(result);
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
	}

}