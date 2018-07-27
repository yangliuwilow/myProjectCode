package com.willow.common.model;

import com.willow.common.page.Page;

import java.io.Serializable;
import java.util.List;

public class ResultList<T extends Serializable>  implements Serializable {
    private static final long serialVersionUID = 1L;

	private Page page;
    private List<T> list;

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
}
