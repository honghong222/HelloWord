package com.yedam.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시글 번호에 대한 조회 결과를 html/modifyForm.jsp 출력
		//수정항목은 제목,내용으로 제한.
		String bno = req.getParameter("board_no");
		
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = bdao.selectBoard(Integer.parseInt(bno));
		
		//조회한 board 정보를 jsp페이지에 전달
		req.setAttribute("board", bvo);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		//포워딩 페이지 전달
		req.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(req, resp);
	}

}