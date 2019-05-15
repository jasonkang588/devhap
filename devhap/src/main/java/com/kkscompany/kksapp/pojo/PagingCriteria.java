package com.kkscompany.kksapp.pojo;

import java.util.HashMap;
import java.util.Map;

public class PagingCriteria {	
	private Integer fetchSize;		
	private Integer blockSize;
	private Integer currentPage;	
	private Integer rowBoundsFrom;
	private Integer rowBoundsTo;
	private Integer totalCount;
	private Integer totalPageCount;
	private Integer startPage;
	private Integer endPage;
	
	public PagingCriteria(Integer currentPage, Integer totalCount, Integer fetchSize, Integer blockSize) {		
		this.currentPage = this.isValidParam(currentPage) ? currentPage : 1;		
		this.totalCount  = this.isValidParam(totalCount)  ? totalCount  : 0;
		this.fetchSize   = this.isValidParam(fetchSize)   ? fetchSize   : 1;
		this.blockSize   = this.isValidParam(blockSize)   ? blockSize   : 1;
		
		this.makePagingCriteria();
	}
	
	private void makePagingCriteria() {
		this.rowBoundsFrom = (this.currentPage-1)*this.fetchSize+1;
		this.rowBoundsTo = rowBoundsFrom+this.fetchSize-1;
		
		if(this.totalCount != 0) {
			this.totalPageCount = (int) Math.ceil(this.totalCount.doubleValue()/this.fetchSize);
			this.startPage = this.currentPage-(this.currentPage-1)%this.blockSize;
			this.endPage = this.startPage+this.blockSize-1;
			if(this.endPage > this.totalPageCount) this.endPage = this.totalPageCount;
		}
	}
	
	private boolean isValidParam(Integer param) {
		if(param == null || param < 1) {
			return false;
		}
		return true;
	}

	public Integer getFetchSize() {
		return fetchSize;
	}

	public Integer getBlockSize() {
		return blockSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getRowBoundsFrom() {
		return rowBoundsFrom;
	}

	public Integer getRowBoundsTo() {
		return rowBoundsTo;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}

	public void setBlockSize(Integer blockSize) {
		this.blockSize = blockSize;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setRowBoundsFrom(Integer rowBoundsFrom) {
		this.rowBoundsFrom = rowBoundsFrom;
	}

	public void setRowBoundsTo(Integer rowBoundsTo) {
		this.rowBoundsTo = rowBoundsTo;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	
}
