package com.willow.core.system.model.query;


import com.willow.core.system.model.ItcastUser;

public class ItcastUserQuery extends ItcastUser {
	private static final long serialVersionUID = 1L;
	
	/** 关键字查询 */
	private java.lang.String keyWord;

	public java.lang.String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(java.lang.String keyWord) {
		this.keyWord = keyWord;
	}
	
}
