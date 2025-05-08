package SimpleBoard.view;

import SimpleBoard.dto.BoardDTO;

public class DetailView {

	public void menuDisplay() {
		System.out.println("============= SIMPLE BOARD ============");
        System.out.println(" 1.글수정 | 2.글삭제 | 0.이전");
        System.out.println("=======================================");
        System.out.print("작업>> ");
	}
	  
	public static void display(String message) {
		System.out.println("알림 : " + message);
	}
	
	public static void display(BoardDTO dto) {
		if(dto == null) {
			display("해당하는 글이 존재하지 않습니다.");
			return;
		}
		System.out.printf("글 ID : %d, 제목 : %s, 내용 : %s, 작성자 : %s, 작성 일자 : %s\n",
		dto.getId(), dto.getTitle(), dto.getContent(), dto.getWriter(), dto.getCreatedDate());
		}
	}
	
