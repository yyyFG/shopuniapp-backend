package cn.demo_text3.entity;


public class PageBean {
    private int pageNum;    // 第几页
    private int pageSize;   // 每页记录数
    private int start;      // 起始页
    private String query;   //查询参数

    public PageBean() {
    }

    public PageBean(int pageNum, int pageSize, int start, String query) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.start = start;
        this.query = query;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
