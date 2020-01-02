package model.dao;

public class LikeDAO {
	private JDBCUtil jdbcUtil = null;
	
	public LikeDAO() {			
		jdbcUtil = new JDBCUtil();	
	}
	public int like(String userID, String boardID) {
		String sql = "INSERT INTO LIKEY VALUES (?, ?)";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { userID, boardID});
		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;

	}


}
