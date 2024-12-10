package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yedam.Control.BoardControl;
import com.yedam.Control.BoardFormControl;
import com.yedam.Control.BoardListControl;
import com.yedam.common.Control;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//
//url pattern 에서  ??.do -> FrontControl울 실행
//
public class FrontControl extends HttpServlet {
	Map<String, Control> map;

	public FrontControl() {
		map = new HashMap<>(); // 필드의 값을 초기화
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		//게시글 등록
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/board.do", new BoardControl());
		//게시글 수정
		map.put("/modifyForm.do", new modifyFormControl());
		map.put("/modifyBoard.do", new modifyBoardControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http://localhost:80/BoardWeb/hello.do
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path); // "/hello.do" 공통부분을 제외한 나머지 부분

		// 요청url === 실행할 컨트롤
		Control contol = map.get(path);
		contol.exec(req, resp);
	}

}
