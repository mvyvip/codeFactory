package ${basePackage}.${typePackage};

public class PageResult {
	
	private Integer count; // 总条数
	private Integer currentPage;  // 当前页
	private Integer pageSize; // 每页显示的条数
	private Integer totalPage; // 总页数
	private Object rows;
	
	public PageResult(Integer count, Integer currentPage, Integer pageSize,
			Object rows) {
		this.count = count;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.rows = rows;
		this.totalPage = ((count - 1)/this.pageSize) + 1;
	}

	/**
	 * 返回easyui分页工具的总条数
	 * @return
	 */
	public Integer getTotal() {
		return count;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PageResult [count=" + count + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", rows=" + rows + "]";
	}

}