package com.ventura.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class convertSetList {

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		set1.add("gregre");
		set1.add("kivrenj");
		set1.add("niwef");
		set1.add("afewjn");

		System.out.println(set1);
		System.out.println(setToList(set1));

	}

	public static <T> List<T> setToList(Set<T> setCollection) {
		List<T> convetedList = new ArrayList<>();

//		for(T item : setCollection) {
//			convetedList.add(item);
//		}

		convetedList.addAll(setCollection);

		return convetedList;

	}

}
