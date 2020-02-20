package com.goutam;

import java.util.HashMap;

public class Server {
	private static HashMap<String, String> map = new HashMap<>();

	public static void clearAll() {
		map.clear();
	}

	public static void put(String key, String value) {
		map.put(key, value);
	}

	public static String get(String key) {
		return map.get(key);
	}

	public static boolean exists(String type) {
		return map.containsKey(type);
	}

	public static void showAll() {
		for (HashMap.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
