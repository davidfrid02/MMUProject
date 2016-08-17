package hit.memoryunits;

public class HardDisk {
	private static int _SIZE;
	private static String DEFAULT_FILE_NAME;
	private static HardDisk instance = new HardDisk();
	
	private HardDisk(){ 
	}
	
	public static HardDisk getInstance(){
		return instance;
	}
	
	
	private void writeHd() throws java.io.FileNotFoundException,java.io.IOException{
		
	}
	
	/***
	 * This method is called when a page is not in fast memory (RAM)
	 * @param pageId - given pageId
	 * @return the page with the given pageId
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 */
	public Page<byte[]> pageFault(Long pageId) throws java.io.FileNotFoundException, java.io.IOException{
		return null;
	}
	
	/***
	 * This method is called when a page is not in fast memory (RAM) and RAM is also with full capacity
	 * @param moveToHdPage - page which should be moved to HD
	 * @param moveToRamId - page id of the pages which should be moved to RAM
	 * @return the page with the given pageId
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 */
	public Page<byte[]> pageReplacement(Page<byte[]> moveToHdPage,Long moveToRamId) throws java.io.FileNotFoundException, java.io.IOException{		
		return moveToHdPage;
	}
}
