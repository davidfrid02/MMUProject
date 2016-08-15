package com.hit.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomReplacementAlgoCacheImpl<K,V> implements IAlgoCache<K, V> {

	Map<K,V> map;
	int capacity;
	
	public RandomReplacementAlgoCacheImpl(int capacity){
		this.capacity = capacity;
		map = new HashMap<K, V>();
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
			//create random number
			Random generator = new Random();
			int n = generator.nextInt(this.capacity);
			//get random key
			K randomKey = new ArrayList<>(map.keySet()).get(n);
			//save old entry value
			oldValue = map.get(randomKey);
			//remove oldest entry value
			removeElement(randomKey);
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
