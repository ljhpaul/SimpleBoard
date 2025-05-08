package SimpleBoard.view;

import java.util.Scanner;

import SimpleBoard.dto.BoardDTO;

public class WriteView {

	public BoardDTO writeMenu() {
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
	
	public void Message(int result, String ms) {
		
		String insertMessage = result + ms;
		
		System.out.println(insertMessage);
		
	}

}
