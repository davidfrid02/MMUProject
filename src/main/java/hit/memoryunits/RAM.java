package hit.memoryunits;

import java.util.Map;

public class RAM {
	private int	initialCapacity;
	private Map<Long,Page<byte[]>> pages;
	
	public RAM(int initialCapacity){
		this.initialCapacity = initialCapacity;
	}

	public int getInitialCapacity() {
		return initialCapacity;
	}

	public void setInitialCapacity(int initialCapacity) {
		this.initialCapacity = initialCapacity;
	}

	public Page<byte[]> getPage(Long pageId) {
		return pages.get(pageId);
	}

	public void addPage(Page<byte[]> page) {
		pages.put(page.getPageId(), page);
	}
	
	public void removePage(Page<byte[]> removePage){
		
	}

	public Page<byte[]>[] getPages(Long[] pageIds){
		return null;
		
	}

	public void addPages(Page<byte[]>[] addPages){
		
	}
	
	public void removePages(Page<byte[]>[] removePages){
		
	}
}
