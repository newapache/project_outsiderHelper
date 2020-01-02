package model.service;

import model.dao.LikeDAO;

public class LikeManager {
	private static LikeManager likeMan = new LikeManager();
	private LikeDAO likeDAO;

	private LikeManager() {
		try {
			likeDAO = new LikeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	public static LikeManager getInstance() {
		return likeMan;
	}
	public int like(String userId, String boardId) {
		return likeDAO.like(userId, boardId);
	}

}
