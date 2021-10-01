package com.joyandbiz.board;

public class Criteria {
	private int page;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;

	// ��������ȣ, �������簴�� �ʱ�ȭ
	public Criteria() {
		this.page = 1;
		this.perPageNum = 5;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	/* Ư�� �������� �Խñ� ���۹�ȣ, �Խñ� ���� �� ��ȣ */
    /* ���� �������� �Խñ� ���� ��ȣ = (���� ������ ��ȣ - 1) * �������� ������ �Խñ� ���� */
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}

	/*
	 * �������� ��Ÿ���� ������ �ε��� ���
	 * EX) 1 2 3 4 5  ���� 
	 */
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}
	
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}
}
