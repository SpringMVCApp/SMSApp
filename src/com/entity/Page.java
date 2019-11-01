package com.entity;

public class Page {
	//������
	private int totalCount=0;
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if(totalCount>0) {
			totalPageCount=totalCount % pageSize==0 ? totalCount / pageSize : (totalCount / pageSize)+1;
			this.totalCount = totalCount;
		}
		
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	//��ҳ��
	private int totalPageCount=0;
	
	//ҳ��С
	private int pageSize=5;
	
	//��ǰҳ��
	private int currentPageNo=0;

}
