package SimpleBoard.controller;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

import SimpleBoard.dto.BoardDTO;
import SimpleBoard.service.BoardService;
import SimpleBoard.view.ListView;

public class ListController implements Controller {
    Scanner sc = new Scanner(System.in);
	BoardService service = new BoardService();
	
	@Override
	public void execute() {
        ListView view = new ListView();
        while(true) {
    		List<BoardDTO> list = service.selectList();
        	view.f_selectList(list);
        	view.menuDisplay();
            String menu = sc.nextLine();

            switch(menu) {
                case "1" -> {f_update(); }
               // case "2" -> {f_delete(); }
                case "0" -> { return; }
                default -> { System.out.println("알림: 유효하지 않은 작업입니다."); }
            }
            System.out.println();
        }

	}
	
	private void f_update() {
		System.out.print("수정할 글 ID>> ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("수정할 내용>> ");
		String content = sc.nextLine();
		
		int resultCount = service.update(id,content);
		
		if(resultCount == 0) {
			System.out.println("수정실패");
		}else {
			System.out.println("수정성공!!");
		}
		
		
	}


	
}
