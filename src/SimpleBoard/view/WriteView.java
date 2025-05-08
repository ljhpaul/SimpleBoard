package SimpleBoard.view;

import java.util.Scanner;

import SimpleBoard.dto.BoardDTO;

public class WriteView {

	// ANSI 색상 코드 정의
	public static final String RESET = "\u001B[0m";
	public static final String GRAY = "\u001B[90m";
	public static final String ACCENT = "\u001B[36m"; // 청록 (포인트 컬러)
	public static final String BOLD = "\u001B[1m";
	public static final String YELLOW = "\u001B[33m"; // 황금 (강조)

	public BoardDTO writeMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.print(ACCENT + "작성자 >> " + RESET);
		String writer = sc.nextLine();

		System.out.print(ACCENT + "제목 >> " + RESET);
		String title = sc.nextLine();

		System.out.print(ACCENT + "내용 >> " + RESET);
		String content = sc.nextLine();

		BoardDTO dto = BoardDTO.builder().writer(writer).title(title).content(content).build();

		return dto;
	}

	public void Message(int result, String ms) {

		String insertMessage = ACCENT + "✨ 작업 결과: " + RESET + BOLD + YELLOW + result + " " + ms + RESET;
		System.out.println(insertMessage);

	}

}
