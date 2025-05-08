package SimpleBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SimpleBoard.dto.BoardDTO;
import SimpleBoard.util.DBUtil;

public class BoardDAO {
	//field
	Connection conn;	//DB연결
	Statement st;		//SQL문을 DB에 전송
	PreparedStatement pst;
	ResultSet rs;		//SELECT 결과
	int resultCount;	//DML의 영향 받은 건수
	
	//1.글작성(insert)
	public int insert(BoardDTO dto) {
		resultCount = 0;	//삽입 건수 초기화
		Connection conn = DBUtil.getConnection();	//DB연결
		
		try {
			String sql = """
					insert into board(id, writer, title, content, createdDate)
					       		values(seq_id.nextval, ?, ?, ?, 
					              	   to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss'))
					""";
			pst = conn.prepareStatement(sql);	//통로 뚫기
			pst.setString(1, dto.getWriter());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			resultCount = pst.executeUpdate();		//쿼리문 실행 및 결과값 가져오기
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, null);
		}
		
		return resultCount;
	}
    
	//2.목록조회(selectList)
	
	
	
	//3.글상세조회(selectOne)
	
	
	
	//4.글수정(update)
	
	
	
	//5.글삭제(delete)
	
	
	
}
