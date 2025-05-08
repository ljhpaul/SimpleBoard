# SimpleBoard

- 프로젝트 개요

## 1. 프로젝트 전개

---

- 목적 : Github를 이용한 협업 경험 실습
    
    https://github.com/ljhpaul/SimpleBoard.git
    
- DB 공유 방법
    - 같은 공간에서 프로젝트 진행
    - 관리자PC에서 DB테이블 생성 후 호스트
        - board계정 : board / 1234

## 2. DB 설계

---

- 게시판 [**ID**, writer, title, content, createdDate]
    - 글번호(ID)는 sequence.nextval 사용 및 추적
    - 작성시간(createdDate)은 String(varchar2)로 받기

## 3. 개발 구조

---

- 패키지 구조 선택
    - **계층형** vs 도메인형
    - 소규모 프로젝트이기에 계층형으로 진행
        - controller
            - FrontController
            - Controller (Interface)
                - WriteController
                - ListController
                - DetailController
        - view
            - WriteView
            - ListView
            - DetailView
        - service
            - BoardService
        - dao
            - BoardDAO
        - dto
            - BoardDTO
        - util
            - DBUtil

## 4. 역할 분배

---

- **팀장 : 이정헌**
    - 프로젝트 초기 설정, 공통 모듈, Controller 설계
    - 담당 branch :  **feature/setting**

---

- **팀원1 : 유채승**
    - 게시글 작성 기능(**WriteController**) 구현
        - 작성자 → 제목 → 내용  순으로 입력받고 f_insert(dto) 실행 후 service.insert(dto)
    - BoardDAO.insert(dto) 구현
        
        ```sql
        insert into board(id, writer, title, content, createdDate)
                    values(seq_id.nextval, '홍길동', '제목', '안녕하세요~!', 
                           to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'))
        
        insert into board(id, writer, title, content, createdDate)
                    values(seq_id.nextval, ?, ?, ?, 
                           to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'))
        ```
        
    - 담당 branch :  **feature/write**

---

- **팀원2 : 이가윤**
    - 게시글 목록 조회 기능(**ListController**) 구현
        - f_selectList() 실행
        - 메뉴 :  **1. 글수정 | 2. 글삭제 | 0. 이전**
            - **case** 1: { f_update(); }
            - **case** 2: { f_delete(); }
            - **case** 0: { isStop = **true**; }
    - BoardDAO.selectList() 구현
        
        ```sql
        select * from board;
        ```
        
    - 담당 branch :  **feature/list**

---

- **팀원3 : 권용희**
    - 게시글 상세조회/수정/삭제 기능(**DetailController**) 구현
        - 조회ID  입력받고 f_selectOne() 실행
        - 메뉴 :  **1. 글수정 | 2. 글삭제 | 0. 이전**
            - **case** 1: { f_update(); }
            - **case** 2: { f_delete(); }
            - **case** 0: { isStop = **true**; }
    - BoardDAO.selectOne(id) / BoardDAO.update(dto) / BoardDAO.delete(id) 구현
        
        ```sql
        select * from board where id = ?;
        --------------------------------------
        update board
        set writer = '권용희',
            title = '제목수정',
            content = '내용수정'
        where id = 1;
        
        update board
        set writer = ?,
            title = ?,
            content = ?
        where id = ?;
        --------------------------------------
        delete from board where id = ?;
        ```
        
    - 담당 branch :  **feature/detail-update-delete**
