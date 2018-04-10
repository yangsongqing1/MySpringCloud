package ysq.com.app.base;

public class PageReqestDTO<T> extends BaseObject {
    private T arguments;
    private int pageNum;
    private int pageSize;

    public T getArguments() {
        return arguments;
    }

    public void setArguments(T arguments) {
        this.arguments = arguments;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
