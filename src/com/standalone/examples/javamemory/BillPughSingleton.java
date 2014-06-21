package com.standalone.examples.javamemory;

import java.io.Serializable;

public class BillPughSingleton implements Serializable{

	private static final long serialVersionId = 1L;

	private BillPughSingleton() {
		
	}
	
	private static class LazyLoader {
		public static final BillPughSingleton singleton = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return LazyLoader.singleton;
	}
	
	public Object readResovlve() {
		return getInstance();
	}
}
