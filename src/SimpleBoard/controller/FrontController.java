package SimpleBoard.controller;

import java.util.Scanner;

public class FrontController {
	public static void main(String[] args) {
		new FrontController().process();
	}

	// WriteController → 글쓰기
	// ListController → 글 목록 조회
	// DetailController → 글 상세 조회, 수정, 삭제 기능 포함
	
	
	// ANSI 색상 코드 정의
    public static final String RESET = "\u001B[0m";
    public static final String GRAY = "\u001B[90m";
    public static final String ACCENT = "\u001B[36m";  // 청록 (포인트 컬러)
    public static final String BOLD = "\u001B[1m";
    public static final String YELLOW = "\u001B[33m"; // 황금 (강조)

	public void process() {
		Scanner sc = new Scanner(System.in);
		while (true) {
            System.out.println(); // 줄바꿈
            System.out.println(BOLD + ACCENT + "📋 SIMPLE BOARD 📋" + RESET);
            System.out.println(GRAY + "──────────────────────────────────────────" + RESET);
            System.out.println(" 1. 글 작성 " + ACCENT + "🖋️" + RESET);
            System.out.println(" 2. 글 목록 조회 " + ACCENT + "📜" + RESET);
            System.out.println(" 3. 글 상세 조회 " + ACCENT + "🔍" + RESET);
            System.out.println(" 0. 프로그램 종료 " + ACCENT + "❌" + RESET);
            System.out.println(GRAY + "──────────────────────────────────────────" + RESET);
            System.out.print(ACCENT + "👉 작업 번호를 입력하세요 → " + RESET);
			String menu = sc.nextLine();

			switch (menu) {
			case "1" -> {
			    System.out.println("\n" + ACCENT + "🖋️ 글 작성을 시작합니다..." + RESET);
				new WriteController().execute();
			}
			case "2" -> {
				 System.out.println("\n" + ACCENT + "📜 목록을 불러옵니다..." + RESET);
				new ListController().execute();
			}
			case "3" -> {
			    System.out.println("\n" + ACCENT + "🔍 글 상세 조회를 시작합니다..." + RESET);
				new DetailController().execute();
			}
			case "0" -> {
			    System.out.println("\n" + ACCENT + "시스템을 종료합니다. 이용해 주셔서 감사합니다." + RESET);
			    sc.close();
			    return;
			}
			default -> {
			    System.out.println(GRAY + "⚠ 유효하지 않은 작업 번호입니다. 다시 입력해주세요 ⚠" + RESET);
			}
			}
		}
	}
}
