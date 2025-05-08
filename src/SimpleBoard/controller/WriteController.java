package SimpleBoard.controller;

import java.util.Scanner;

import SimpleBoard.dto.BoardDTO;
import SimpleBoard.service.BoardService;
import SimpleBoard.view.WriteView;

public class WriteController implements Controller {

	@Override
	public void execute() {
		BoardDTO dto = makeDTO();
		f_insert(dto);
	}
	
	public static void f_insert(BoardDTO dto) {
		BoardService service = new BoardService();
		System.out.println( service.insert(dto) + "건 수정" );
		;
	}
	
	public BoardDTO makeDTO() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("작성자>> ");
		String writer = sc.nextLine();
		System.out.print("제목>> ");
		String title = sc.nextLine();
		System.out.print("내용>> ");
		String content = sc.nextLine();
		
		BoardDTO dto = BoardDTO.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.build();
		
		return dto;
	}
	
}
