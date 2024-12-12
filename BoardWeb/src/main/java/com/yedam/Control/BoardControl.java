package com.yedam.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	private BoardDAO bdao;

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//GET방식: 조회 vs. post방식:등록
		if(req.getMethod().equals("GET")){
		//파라미터(board_no) + page + searchCondition+ keyword
		String bno = req.getParameter("board_no");
		//파라미터 추가작업. 2024 12.12
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno)); // 단건조회

		req.setAttribute("board", bvo); // board의 속성에 조회된 결과값 전달
		//파라미터 추가작업. 2024 12.12
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
		}else if(req.getMethod().equals("POST")) {
			
			//POST 요청일 경우에는 한글 인코딩 방식을 적용해 줘야함
			req.setCharacterEncoding("utf-8"); // tomcat 9.xx 버전은 이렇게
			
			//파마니터
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			
			BoardVO  board = new BoardVO();
			board.setTitle(title);
			board.setTitle(content);
			board.setTitle(writer);
			
			if(bdao.insertBoard(board)) {
				resp.sendRedirect("boardList.do"); //페이지 재지정
			}else{
				//등록화면으로 이동
				req.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(req, resp);
			}
		}
	}

}
