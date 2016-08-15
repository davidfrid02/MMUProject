package com.hit.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MRUAlgoCacheImpl<K,V> implements IAlgoCache<K, V> {

	Map<K,V> map;
	int capacity;
	
	public MRUAlgoCacheImpl(int capacity){
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
			//get youngest key
			K youngestKey = new ArrayList<>(map.keySet()).get(map.size() - 1);
			//save old entry value
			oldValue = map.get(youngestKey);
			//remove oldest entry value
			removeElement(youngestKey);
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
