package SimpleBoard.controller;

import java.util.Scanner;

import SimpleBoard.dto.BoardDTO;
import SimpleBoard.service.BoardService;
import SimpleBoard.view.WriteView;

public class WriteController implements Controller {

	WriteView wv = new WriteView();

	@Override
	public void execute() {
		BoardDTO dto = makeDTO();
		f_insert(dto);
	}

	public void f_insert(BoardDTO dto) {
		BoardService service = new BoardService();

		int result = service.insert(dto);

		wv.Message(result, "건 수정");
	}

	public BoardDTO makeDTO() {

		BoardDTO dto = wv.writeMenu();

		return dto;
	}

}
