package com.yc.crbook.bean;

public class CrShow implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Integer id;

    private String page;

    private String board;

    private String relatb;

    private Integer relaid;

    private Integer sort;
    
    /**
     * 关联图书的对象
     */
    private CrBook book;
    /**
     * 关联文章的对象
     */
    private CrArticle article;
    
    public CrBook getBook() {
		return book;
	}

	public void setBook(CrBook book) {
		this.book = book;
	}

	public CrArticle getArticle() {
		return article;
	}

	public void setArticle(CrArticle article) {
		this.article = article;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board == null ? null : board.trim();
    }

    public String getRelatb() {
        return relatb;
    }

    public void setRelatb(String relatb) {
        this.relatb = relatb == null ? null : relatb.trim();
    }

    public Integer getRelaid() {
        return relaid;
    }

    public void setRelaid(Integer relaid) {
        this.relaid = relaid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}