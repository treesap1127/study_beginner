package kr.ac.kopo.polycms.model;

public class ArticleCount {
	private Long boardId;
	private Long articleId;
	private String uerId;
	private String type;
	
	public Long getBoardId() {
		return boardId;
	}
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public String getUerId() {
		return uerId;
	}
	public void setUerId(String uerId) {
		this.uerId = uerId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
