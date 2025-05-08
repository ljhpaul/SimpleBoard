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
	
	// ANSI 색상
    public static final String RESET = "\u001B[0m";
    public static final String GRAY = "\u001B[90m";
    public static final String ACCENT = "\u001B[36m";  // 청록
    public static final String BOLD = "\u001B[1m";

	
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
               case "2" -> {f_delete(); }
                case "0" -> { return; }
                default -> { System.out.println("알림: 유효하지 않은 작업입니다."); }
            }
            System.out.println();
        }

	}
	
	// 수정
	private void f_update() {
	    System.out.print(ACCENT + "📝 수정할 글 ID를 입력하세요 → " + RESET);
	    int id = sc.nextInt();
	    sc.nextLine(); // 버퍼 비우기
	    System.out.print(ACCENT + "✏️ 새 제목을 입력하세요 → " + RESET);
	    String title = sc.nextLine();
	    System.out.print(ACCENT + "✏️ 새 내용을 입력하세요 → " + RESET);
	    String content = sc.nextLine();
	  
	    BoardDTO boardDTO = BoardDTO.builder().id(id).title(title).content(content).build();
	    
	    
	    String result = service.update(boardDTO);
	    System.out.println(); // 줄바꿈
	    if (result.equals("글 수정 실패")) {
	        System.out.println(BOLD + "\u001B[31m❗ 수정에 실패했습니다. 존재하지 않는 글이거나 오류가 발생했습니다." + RESET);
	    } else {
	        System.out.println(BOLD + "\u001B[32m✅ 수정이 완료되었습니다!" + RESET);
	    }
	}
	
	// 삭제
	private void f_delete() {
	    System.out.print(ACCENT + "📝 삭제할 글 ID를 입력하세요 → " + RESET);
	    int id = sc.nextInt();
	    sc.nextLine(); // 버퍼 비우기

	    String result = service.delete(id);
	    
	    System.out.println(); // 줄바꿈
	    if (result.equals("글 삭제 실패")) {
	        System.out.println(BOLD + "\u001B[31m❗삭제에 실패했습니다. 존재하지 않는 글이거나 오류가 발생했습니다." + RESET);
	    } else {
	        System.out.println(BOLD + "\u001B[32m✅ 삭제가 완료되었습니다!" + RESET);
	    }
	}
		


	
}
