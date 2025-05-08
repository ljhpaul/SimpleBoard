package SimpleBoard.controller;

import java.util.Scanner;

import SimpleBoard.controller.Controller;
import SimpleBoard.dto.BoardDTO;
import SimpleBoard.view.DetailView;
import SimpleBoard.view.ListView;

public class DetailController implements Controller {

	@Override
	public void execute() {
	    Scanner sc = new Scanner(System.in);
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

	private void f_delete() {
		DetailView.deleteDisplay();
	}

	private void f_update() {
		DetailView.updateDisplay();
	}

	public BoardDTO makeDTO() {
		BoardDTO dto = BoardDTO.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.build();
		
		return dto;
	}
}
