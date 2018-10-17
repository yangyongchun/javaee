package dao;

public class PageBean {
private int firstPage=1;
private int prePage;
private int nextPage;
private int totalPage;
private int curPage=1;
private int pageSize=3;
private int totalSize;
public int getFirstPage() {
	return firstPage;
}
public void setFirstPage(int firstPage) {
	this.firstPage = firstPage;
}
public int getPrePage() {
	return prePage;
}
public void setPrePage(int prePage) {
	this.prePage = prePage;
}
public int getNextPage() {
	return nextPage;
}
public void setNextPage(int nextPage) {
	this.nextPage = nextPage;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getCurPage() {
	return curPage;
}
public void setCurPage(int curPage) {
	this.curPage = curPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalSize() {
	return totalSize;
}
public void setTotalSize(int totalSize) {
	this.totalSize = totalSize;
}
}
