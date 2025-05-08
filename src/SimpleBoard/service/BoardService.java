package SimpleBoard.service;

import SimpleBoard.dao.BoardDAO;
import SimpleBoard.dto.BoardDTO;
import lombok.extern.java.Log;

//BoardService: 비즈니스 로직 수행, DB에 가는 업무는 DAO 호출.
public class BoardService {
	
	BoardDAO DAO = new BoardDAO();
	
	//1.글작성(insert)
	public int insert(BoardDTO dto) {
		return DAO.insert(dto);
	}
	
	//2.목록조회(selectList)
	
	
	
	//3.글상세조회(selectOne)
	public BoardDTO selectOne(int id) {
		BoardDTO dto = DAO.selectOne(id);
		return dto;
	}
	
	
	//4.글수정(update)
	public String update(BoardDTO dto) {
		int result = DAO.update(dto);
		return result > 0 ? "글 수정 성공" : "글 수정 실패";
	}
	
	
	//5.글삭제(delete)
	public String delete(int id) {
		int result = DAO.delete(id);
		return result > 0 ? "글 삭제 성공" : "글 삭제 실패";
	}
	
	
}
