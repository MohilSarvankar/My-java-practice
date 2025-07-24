package collectionFramework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "One");
		map1.put(2, "Two");
		map1.put(3, null);
		map1.put(4, "Four");
		map1.put(null, "Five");
		System.out.println("Orginal map: "+map1);
		
		System.out.println("Get 2: "+map1.get(2));
		System.out.println("Keyset: "+map1.keySet());
		System.out.println("Values: "+map1.values());
		System.out.println("Entry set: "+map1.entrySet());
		System.out.println("Containskey: "+map1.containsKey(2));
		System.out.println("Containsvalue: "+map1.containsValue("Five"));
		System.out.println("Remove 4: "+map1.remove(null));
		
		System.out.println("Get or default: "+map1.getOrDefault(2, "Default two"));
		System.out.println("Put if absent: "+map1.putIfAbsent(2, "new two"));
		System.out.println("Put if absent: "+map1.putIfAbsent(6, "Six"));
		
		System.out.println("Final map: "+map1);
		
		
		System.out.println("\n====Map of user defined classes=====");
		Map<User,Product> map2 = new HashMap<>();
		
		User user1 = new User(1, "mohil");
		Product product1 = new Product(100,"mobile");
		
		map2.put(user1, product1);
		System.out.println("Original map2: "+map2);
		
		User user2 = new User(1,"mohil");
		System.out.println("Get with user1: "+map2.get(user1));
		
		//works only afteradding hashcode and equals method in key i.e User class
		System.out.println("Get with user1: "+map2.get(user2)); 
		
		
		System.out.println("\n====Sorting map entries using list====");
		List<Entry<Integer, String>> list1 = new ArrayList<>(map1.entrySet());
		System.out.println("Original list: "+list1);
		
		Collections.shuffle(list1);
		System.out.println("Shuffled list: "+ list1);
		
//		list1.sort(Entry.comparingByKey());
//		System.out.println("List sort by key: "+list1);
//		
//		list1.sort(Entry.comparingByValue());
//		System.out.println("List sort by value: "+list1);
		
		
		System.out.println("\n====Navigable map=====");
		NavigableMap<Integer, String> map3 = new TreeMap<>();
		map3.put(3, "Three");
		map3.put(1, "One");
		map3.put(5, "Five");
		map3.put(4, "Four");
		map3.put(2, "Two");
		System.out.println("Original map: "+map3);
		
		System.out.println("lowerEntry: " + map3.lowerEntry(4));
		System.out.println("lowerKey: " + map3.lowerKey(4));
		System.out.println("floorEntry: " + map3.floorEntry(4));
		System.out.println("ceilingEntry: " + map3.ceilingEntry(2));
		System.out.println("higherEntry: " + map3.higherEntry(2));
		System.out.println("firstEntry: " + map3.firstEntry());
		System.out.println("lastEntry: " + map3.lastEntry());
		System.out.println("descendingMap: " + map3.descendingMap());
		System.out.println("navigableKeySet: " + map3.navigableKeySet());
		System.out.println("subMap: " + map3.subMap(2,4));
		System.out.println("headMap: " + map3.headMap(3));
		System.out.println("tailMap: " + map3.tailMap(3));
	}

}
