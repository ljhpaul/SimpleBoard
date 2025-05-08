package SimpleBoard.controller;

import java.util.Scanner;

public class FrontController {
    public static void main(String[] args) {
        new FrontController().process();
    }
    
    //WriteController  → 글쓰기
    //ListController   → 글 목록 조회
    //DetailController → 글 상세 조회, 수정, 삭제 기능 포함
    
    public void process() {
        Scanner sc = new Scanner(System.in);
        while(true) {
        	System.out.println("============= SIMPLE BOARD ============");
            System.out.println(" 1.글작성 | 2.목록조회 | 3.글상세조회 | 0.종료");
            System.out.println("=======================================");
            System.out.print("작업>> ");
            String menu = sc.nextLine();

            switch(menu) {
                case "1" -> { new WriteController().execute(); }
                case "2" -> { new ListController().execute(); }
                case "3" -> { new DetailController().execute(); }
                case "0" -> { System.out.println("\n=============== 시스템 종료 =============="); sc.close(); return; }
                default -> { System.out.println("알림: 유효하지 않은 작업입니다."); }
            }
            System.out.println();
        }
    }
}


