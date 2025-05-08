package SimpleBoard.controller;

import java.util.Scanner;

import SimpleBoard.dao.BoardDAO;
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
        	int id = f_selectOne();
        	
        	
        	
        	view.menuDisplay();
            String menu = sc.nextLine();

            switch(menu) {
                case "1" -> { f_update(id); }
                case "2" -> { f_delete(id); }
                case "0" -> { return; }
                default -> { System.out.println("알림: 유효하지 않은 작업입니다."); }
            }
            System.out.println();
        }

	private static int f_selectOne() {
		System.out.print("ID를 입력하세요 >> ");
		int id = Integer.parseInt(sc.nextLine());
		
		BoardDTO dto = boardService.selectOne(id);
		DetailView.display(dto);
		return id;
	}

	private static void f_delete(int id) {
		String result = boardService.delete(id);
		DetailView.display(result);
	}

	private static void f_update(int id) {
		System.out.print("글의 제목을 수정하려면 입력하세요 (입력 필수) >> ");
		String title = sc.nextLine();
		System.out.print("내용을 수정하려면 입력하세요 (입력 필수) >> ");
		String content = sc.nextLine();
		
		BoardDTO dto = BoardDTO.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
		
		String result = boardService.update(dto);
		DetailView.display(result);
	}
// 잠시 추가
}
