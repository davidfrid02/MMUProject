package hit.memoryunits;

public class Page<T> {


	private T content; 
	private Long pageId;
	
	public Page(Long id, T content){
		this.content = content;
		this.pageId = id;
	}
	
	public T getContent() {
		return content;
	}
	
	public void setContent(T content) {
		this.content = content;
	}

	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Page))
			return false;
		if(obj == this)
			return true;
		if(this.hashCode() == obj.hashCode())
			return true;
					
		return false;
	}

	@Override
	public int hashCode() {
		//multiple two prime numbers
        int prime = 17*31;
        int result = 150;
        
        result += prime * result;
        result += prime * result + ((pageId == null) ? 0 : pageId.hashCode());;
        result += prime * result + ((content == null) ? 0 : content.hashCode());
        return result;

	}

	@Override
	public String toString() {
		return "PageId: '" + this.pageId.toString() + "', Content: '" + this.content.toString() + "'";
	}

}
