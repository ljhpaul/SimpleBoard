package SimpleBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
	public List<BoardDTO> selectList() {
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		conn = DBUtil.getConnection();
		try {
			String sql = "select * from board";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				BoardDTO dto = makeBoard(rs);
				boardlist.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return boardlist;
	}
	
	private BoardDTO makeBoard(ResultSet rs) throws SQLException {
		BoardDTO dto = BoardDTO.builder()
			.id(rs.getInt(1))
			.writer(rs.getString(2))
			.title(rs.getString(3))
			.content(rs.getString(4))
			.createdDate(rs.getString(5))
			.build();
		return dto;
	}
	

	
	
	//3.글상세조회(selectOne)
	
	
	
	//4.글수정(update)
	public int update(BoardDTO boardDTO) {
		conn = DBUtil.getConnection();
		
		String sql = "UPDATE BOARD SET CONTENT = ?, TITLE = ?,createdDate = to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')"
				+ "WHERE ID = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,boardDTO.getContent());
			pst.setString(2,boardDTO.getTitle());
			pst.setInt(3, boardDTO.getId());
			
			resultCount = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCount;
		
	}

	public int delete(int id) {
		conn = DBUtil.getConnection();
		
		String sql = """
				DELETE FROM BOARD 
				WHERE ID = ?
				""";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,id);
			
			resultCount = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCount;
	}
	
	
	//5.글삭제(delete)
	
	
}
