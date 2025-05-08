package SimpleBoard.view;

import java.util.List;

import SimpleBoard.dto.BoardDTO;
import SimpleBoard.service.BoardService;

public class ListView {
	
	public void menuDisplay() {
    	System.out.println("=========================");
        System.out.println(" 1.글수정 | 2.글삭제 | 0.종료");
        System.out.println("=========================");
        System.out.print("작업>> ");
	}

	public void f_selectList(List<BoardDTO> list) {
		for(BoardDTO b : list) {
			System.out.println(b.getId() + " / " + b.getTitle() + " / " + b.getWriter() + " / " + b.getContent() + b.getCreatedDate());
			
			System.out.println(" ");
		
	}
	
	}
}
