package com.zhaoliu.blog.domain;

public class BlogType {
    private Integer tid;

    private String tname;

    
    public BlogType() {
		super();
	}

	public BlogType(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }
}