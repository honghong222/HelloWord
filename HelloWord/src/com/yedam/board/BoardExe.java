package com.yedam.board;

import java.util.Date;

//
//1등록 2목록
//
public class BoardExe {
	private Board[] storage;// 필드

	public BoardExe() { // 초기화
		storage = new Board[10];
		storage[1] = new Board(2, "자바 재미있음", "열공이야~", "user01", new Date());
		storage[2] = new Board(3, "오늘 화욜", "3일이면 주말", "user01", new Date());
		storage[9] = new Board(1, "프로그래밍", "개추요", "user01", new Date());
	}

	// 게시글 등록
	public boolean insertBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = board;
				return true;
			}
		}
		return false;
	}

	// 목록
	public Board[] boardList() {
		// 정렬
		for (int j = 0; j < storage.length - 1; j++) {
			for (int i = 0; i < storage.length - 1; i++) {
				//뒷자리가 nulㅣ이면 nothing.
				if(storage[i+1] == null) {
					continue;
				}
				
				Board temp = null;
				if(storage[i]==null// 
						|| storage[i].getBoardNo() > storage[i+1].getBoardNo()) {
					//위치변경 [i] <->[i+1]
					temp = storage[i];
					storage[i] = storage[i+1];
					storage[i+1] = temp;
				}
			}//1for
			
		}//2for
		return storage;
	}

	// 글번호 가져오는 메소드
	// null이 아닌 카운트에 +1 한 값을 반환
	public int getNextNo() {
		int cnt = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				int boardNo = storage[i].getBoardNo();
				if (cnt < boardNo) {// 현재의 맥스값ㅂ다 큰 값일 경우에
					cnt = boardNo;
				}
			}
		}
		return cnt + 1;
	}

	// 글삭제 기능 ->매개값은 글번호 반환값은 true/ false, deleteBoard()
	public boolean deleteBoard(int boardNo) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == boardNo) {
				storage[i] = null;
				return true;
			}
		}
		return false;
	}

	// 글수정기능 =>매개값은 글번호 내용 제목 , 반환값은 true/false, updateBoard()
	public boolean updateBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == board.getBoardNo()) {
				storage[i].setConrent(board.getConrent());
				storage[i].setTitle(board.getTitle());
				return true;
			}

		}
		return false;
	}

// 삭제 수정 권한있는지 체크 => 매개값은 글번호,작성자,반환값은 글번호에 작성자가 일치하면 true,false
// checkResponsibility()
	public boolean checkResponsibility(int boardNo, String writer) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				if (storage[i].getBoardNo() == boardNo && storage[i].getWriter().equals(writer)) {
					return true;
				}
			}
			return false;
		}
	}
}
