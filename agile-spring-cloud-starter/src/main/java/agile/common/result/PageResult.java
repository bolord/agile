package agile.common.result;

/**
 * RESTful API 统一分页数据装饰类
 *
 * @author Alex
 */
public class PageResult extends Result {

    /**
     * 当前页码
     */
    private int current = 1;

    /**
     * 每页数据量
     */
    private int size = 10;

    /**
     * 总数据量
     */
    private long total;

    /**
     * 总页数
     */
    private long pages;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long l) {
        this.pages = l;
    }

}