package org.kpu.myweb.domain;

public class SchedulVO {
	private String id;
	private String sDate;
	private String eDate;
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSDate() {
		return sDate;
	}

	public void setSDate(String sDate) {
		this.sDate = sDate;
	}

	public String getEDate() {
		return eDate;
	}

	public void setEDate(String eDate) {
		this.eDate = eDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", sDate=" + sDate + ", eDate=" + eDate + ", content=" + content + "]";
	}
}
