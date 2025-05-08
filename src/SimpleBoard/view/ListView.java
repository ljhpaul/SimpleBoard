package SimpleBoard.view;

import java.util.List;

import SimpleBoard.dto.BoardDTO;
import SimpleBoard.service.BoardService;

public class ListView {

	    // ANSI 색상
	    public static final String RESET = "\u001B[0m";
	    public static final String GRAY = "\u001B[90m";
	    public static final String ACCENT = "\u001B[36m";  // 청록
	    public static final String BOLD = "\u001B[1m";
	    public void menuDisplay() {
	        System.out.println();
	        System.out.println(GRAY + "----------------------------------------" + RESET);
	        System.out.println(BOLD + " ✏  1. 글 수정     🗑  2. 글 삭제     ❌  0. 돌아가기" + RESET);
	        System.out.println(GRAY + "----------------------------------------" + RESET);
	        System.out.print(ACCENT + "작업 번호를 입력하세요 → " + RESET);
	    }
	    public void f_selectList(List<BoardDTO> list) {
	        System.out.println();
	        System.out.println(BOLD + ACCENT + "📄 게시글 목록" + RESET);
	        System.out.println(GRAY + "────────────────────────────────────────" + RESET);
	        if (list == null || list.isEmpty()) {
	            System.out.println(GRAY + "표시할 게시글이 없습니다." + RESET);
	        } else {
	            for (BoardDTO b : list) {
	                System.out.println("🔹 번호: " + b.getId());
	                System.out.println("📌 제목: " + b.getTitle());
	                System.out.println("👤 작성자: " + b.getWriter());
	                System.out.println("📝 내용: " + b.getContent());
	                System.out.println("🕒 작성일: " + b.getCreatedDate());
	                System.out.println(GRAY + "----------------------------------------" + RESET);
	            }
	        }
	    }
	}
