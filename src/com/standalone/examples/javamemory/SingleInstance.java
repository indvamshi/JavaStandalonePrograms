package com.standalone.examples.javamemory;

public class SingleInstance {

	// Early Initialization
/*
	private static volatile SingleInstance inst = new SingleInstance();
	
	private SingleInstance() {
		
	}
	
	public static SingleInstance getInstance() {
		return inst;
	}
*/
	
	// Lazy initialization
	// problem when two threads access the getinstance method two instances are created.
/*	private static volatile SingleInstance inst = null;
	
	private SingleInstance() {
		
	}
	
	public static SingleInstance getInstance() {
		if (inst == null){
			synchronized (SingleInstance.class) {
				inst = new SingleInstance();
			}
		}
		return inst;
	}
	*/
	
	// double check alogirthm which solves the above problem
	
	/*
	private static volatile SingleInstance inst = null;
	
	public static SingleInstance getInstance() {
		if (inst == null){
			synchronized (SingleInstance.class) {
				if (inst == null) {
					inst = new SingleInstance();
				}
			}
		}
		return inst;
	}
	*/
	
	// class loading sequence, static blocks are loaded before instance is created
	// if we create instance in static block , even if it is not required we are creating instance
	// the below example creates the instance when it is required.
	/*
	 private SingleInstance() {
	 }
	 private static class LazyLoader() {
	 	private static final SingleInstance inst = new SingleInstance();
	 }
	 public static getInstance() {
	 	return LazyLoader.inst;
	 }
	 */
	
	// singleton class can be created using Enum with minimal effore. As Enum are guranteed to return only 1 instance
	/*
	public enum EnumSingleton {
		INSTANCE;
	}
	*/
	
	// in distributed application, when singleton is serialized and deserialized there is chance of creating duplicate objects.
	// to resove this implement method Object readResolve() { return instance}
	
	// Best type of creating singleton instance class is 
	/*
	 public class DemoSingleton implements Serializable {
	private static final long serialVersionUID = 1L;

	private DemoSingleton() {
		// private constructor
	}

	private static class DemoSingletonHolder {
		public static final DemoSingleton INSTANCE = new DemoSingleton();
	}

	public static DemoSingleton getInstance() {
		return DemoSingletonHolder.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}
	
}
	 */
}
