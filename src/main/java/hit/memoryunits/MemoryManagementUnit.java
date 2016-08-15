package hit.memoryunits;

import java.io.IOException;

import com.hit.algorithm.IAlgoCache;

public class MemoryManagementUnit {
	private IAlgoCache<Long,Long> algo;
	private RAM ram;
	
	public MemoryManagementUnit(int ramCapacity,IAlgoCache<Long,Long> algo){
		this.ram = new RAM(ramCapacity);
		this.algo = algo;
	}
	
	/***
	 * This method is the main method which returns array of pages that are requested from the user
	 * @param pageIds - array of page ids
	 * @return returns array of pages that are requested from the user
	 * @throws IOException
	 */
	public Page<byte[]>[] getPages(Long[] pageIds) throws IOException{
		return null;
	}
	
	public IAlgoCache<Long,Long> getAlgo(){
		return algo;
	}
	
	public void setAlgo(IAlgoCache<Long,Long> algo){
		this.algo = algo;
	}
	
	public RAM getRam(){
		return ram;
	}
	
	public void setRam(RAM ram){
		this.ram = ram;
	}
}
