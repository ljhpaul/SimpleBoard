package SimpleBoard.controller;

import java.util.Scanner;
import SimpleBoard.dao.BoardDAO;
import SimpleBoard.controller.Controller;
import SimpleBoard.dto.BoardDTO;
import SimpleBoard.service.BoardService;
import SimpleBoard.view.DetailView;
import SimpleBoard.view.ListView;

public class DetailController implements Controller {
	static Scanner sc = new Scanner(System.in);
	static BoardService boardService = new BoardService();
	
	@Override
	public void execute() {
        DetailView view = new DetailView();
        while(true) {
        	view.menuDisplay();
            String menu = sc.nextLine();

            switch(menu) {
                case "1" -> { f_update(); }
                case "2" -> { f_delete(); }
                case "0" -> { return; }
                default -> { System.out.println("알림: 유효하지 않은 작업입니다."); }
            }
            System.out.println();
        }
	}

	private static void f_delete() {
		System.out.print("삭제할 글의 ID를 입력하세요 >> ");
		int id = Integer.parseInt(sc.nextLine());
		String result = boardService.delete(id);
		DetailView.display(result);
	}

	private static void f_update() {
		System.out.print("수정할 글의 ID를 입력하세요 >> ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("글의 제목을 수정하려면 입력하세요 >> ");
		String title = sc.nextLine();
		System.out.print("작성자를 수정하려면 입력하세요 >> ");
		String writer = sc.nextLine();
		System.out.print("내용을 수정하려면 입력하세요 >> ");
		String content = sc.nextLine();
		
		BoardDTO dto = BoardDTO.builder()
				.id(id)
				.title(title)
				.writer(writer)
				.content(content)
				.build();
		
		String result = boardService.update(dto);
		DetailView.display(result);
	}
// 잠시 추가
}
