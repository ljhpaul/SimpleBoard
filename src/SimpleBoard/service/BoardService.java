package SimpleBoard.service;

import java.util.List;



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

	public List<BoardDTO> selectList() {
		List<BoardDTO> list = DAO.selectList();
		return list;
	}

	public String delete(int id) {
		int resultCount = DAO.delete(id);
		String result = "";
		if(resultCount == 1) {
			result = "글 삭제 성공";
		}else {
			result = "글 삭제 실패";
		}
		
		return result;
	}

	public String update(BoardDTO boardDTO) {
		int reusultCount = DAO.update(boardDTO);
		return reusultCount;
		
	}
	
	
	//3.글상세조회(selectOne)
	
	
	
	//4.글수정(update)
	
	
	
	//5.글삭제(delete)
	
	
	
}
