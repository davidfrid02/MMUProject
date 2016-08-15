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
		if(checkCapacity()){
			//LRU???
		}else{
			pages.put(page.getPageId(), page);
		}
		
	}
	
	public void removePage(Page<byte[]> removePage){
		pages.remove(removePage.getPageId());
	}

	public Page<byte[]>[] getPages(Long[] pageIds){

		@SuppressWarnings("unchecked")
		Page<byte[]>[] pagesArray = (Page<byte[]>[]) new Object[pageIds.length];
		for (int i = 0; i < pageIds.length; i++) {
			pagesArray[i] = pages.get(pageIds[i]);
		}
		return pagesArray;
		
	}

	public void addPages(Page<byte[]>[] addPages){
		for (Page<byte[]> page : addPages) {
			if(checkCapacity()){
				//LRU???
			}else{
				pages.put(page.getPageId(), page);
			}
		}

	}
	
	public void removePages(Page<byte[]>[] removePages){
		for (Page<byte[]> page : removePages) {
			pages.remove(page.getPageId());
		}
	}
	
	//check if we run out of space
	public boolean checkCapacity(){
		if(pages.size() >= this.initialCapacity)
			return true;
		return false;			
	}
}
