package SimpleBoard.controller;

import java.util.Scanner;

import SimpleBoard.view.ListView;

public class ListController implements Controller {

	@Override
	public void execute() {
        Scanner sc = new Scanner(System.in);
        ListView view = new ListView();
        while(true) {
        	view.menuDisplay();
            String menu = sc.nextLine();

            switch(menu) {
                case "1" -> {  }
                case "2" -> {  }
                case "0" -> { return; }
                default -> { System.out.println("알림: 유효하지 않은 작업입니다."); }
            }
            System.out.println();
        }

	}

}
