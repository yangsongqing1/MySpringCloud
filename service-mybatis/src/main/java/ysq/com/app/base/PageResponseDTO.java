package ysq.com.app.base;

import java.util.List;

public class PageResponseDTO<T> extends BaseObject {
    private List<T> data;
    private int totalRow;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }
}
