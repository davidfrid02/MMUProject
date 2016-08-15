package com.hit.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class LRUAlgoCacheImpl<K, V> implements IAlgoCache<K, V> {
	
	Map<K,V> map;
	int capacity;
	
	public LRUAlgoCacheImpl(int capacity){
		this.capacity = capacity;
		map = new LinkedHashMap<K, V>();
	}
	
	@Override
	public V getElement(K key) {
		if(!map.isEmpty())
			return map.get(key);
		return null;
	}

	@Override
	public V putElement(K key, V value) {
		V oldValue = null;	
		if(checkCapacity()){
			//get oldest entry
			Entry<K,V> oldestEntry = map.entrySet().iterator().next();
			//save old entry value
			oldValue = oldestEntry.getValue();
			//remove oldest entry value
			removeElement(oldestEntry.getKey());
			//put new key&value entry
			map.put(key, value);
		}
		else
			map.put(key, value);			
		return oldValue;
	}

	@Override
	public void removeElement(K key) {
		map.remove(key);
	}
	
	//check if we run out of space
	public boolean checkCapacity(){
		if(map.size() >= this.capacity)
			return true;
		return false;			
	}

}
