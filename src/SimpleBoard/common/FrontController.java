package SimpleBoard.common;

import java.util.Scanner;

public class FrontController {
    public static void main(String[] args) {
        new FrontController().process();
    }
    
    //WriteController → 글쓰기
    //ListController → 글 목록 조회
    //DetailController → 글 상세 조회, 수정, 삭제 기능 포함
    
    public void process() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. 글작성 | 2. 목록조회 | 3. 글상세조회 | 0. 종료");
            int menu = Integer.parseInt(sc.nextLine());
            Controller controller = null;

            switch(menu) {
                case 1: controller = new WriteController(); break;
                case 2: controller = new ListController(); break;
                case 3: controller = new DetailController(); break;
                case 0: System.exit(0);
            }
            if(controller != null) {
                controller.execute(sc);
            }
        }
    }
}