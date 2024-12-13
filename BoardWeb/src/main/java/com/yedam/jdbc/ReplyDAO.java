package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.ReplyVO;

public class ReplyDAO extends DAO{
	String query = "select * from tbl_reply where board_no = ? order by reply_no";
	String insertQuery = "insert into tbl_reply (reply_no, reply, replyer, board_no)"
			+ "           values(?, ?, ?, ?)";
	String deletQuery = "delete from tbl_reply where reply_no = ?";
	
	//댓글 등록
	public boolean insertReply(ReplyVO rvo) {
		getConn();
		
		try {
			psmt = conn.prepareStatement("select reply_seq.nextval from dual ");
			rs = psmt.executeQuery();
			int rno =0; //시퀀스 값을 먼저 생성해서 rvo 에 저장.
			if(rs.next()) {
				rno = rs.getInt(1);
				rvo.setReplyNo(rno);
			}
			
			psmt = conn.prepareStatement(insertQuery);
			
			psmt.setInt(1, rno);
			psmt.setString(2, rvo.getReply());
			psmt.setString(3, rvo.getReplyer());
			psmt.setInt(4, rvo.getBoardNo());
			int r = psmt.executeUpdate();
			if(r > 0) {
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return false;
	}
	
	
	//댓글 삭제
	public boolean deleteReply(int replyNo) {
		getConn();
		String sql = "delete from tbl_reply where reply_no = ?";
		
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, replyNo);
			int r = psmt.executeUpdate();
			if(r > 0) {		
					return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return false;
	}
	
	public List<ReplyVO> selectList(int boardNo){
		getConn();
		List<ReplyVO> rlist = new ArrayList<>();
		try {
		psmt = conn.prepareStatement(query);
		psmt.setInt(1, boardNo);
		
		rs = psmt.executeQuery();
		while(rs.next()) {
			ReplyVO rvo = new ReplyVO();
			rvo.setReplyNo(rs.getInt("reply_no"));
			rvo.setReply(rs.getString("reply"));
			rvo.setReplyer(rs.getString("replyer"));
			rvo.setReplyDate(rs.getDate("reply_date"));
			rvo.setBoardNo(rs.getInt("board_no"));
			
			rlist.add(rvo);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			disConnect();
		}
		return rlist;
	}
}
