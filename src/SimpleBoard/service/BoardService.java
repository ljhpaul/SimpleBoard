package SimpleBoard.service;

import SimpleBoard.dao.BoardDAO;
import SimpleBoard.dto.BoardDTO;

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
		BoardDTO board = DAO.selectOne(id);
		return board;
	}
	
	
	//4.글수정(update)
	public int update(BoardDTO dto) {
		int result = DAO.update(dto);
		return result;
	}
	
	
	//5.글삭제(delete)
	public int delete(int id) {
		int result = DAO.delete(id);
		return result;
	}
	
	
}
