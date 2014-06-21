package com.standalone.examples.javamemory;

import java.lang.ref.WeakReference;

public class WeakReferenceObject {

	 public static void GrabgecollectionCall() {
	        try {
	            System.out.println("Call for the garbage collection");
	            System.gc();
	            System.out.println("Thread is Sleeping now for 3S");
	            Thread.sleep(3000); // for 3 seconds.
	        } catch (InterruptedException ie) {
	            ie.getMessage();
	        }
	    }

	    public static void main(String args[]) {

	        System.out.println("For the Creation of a weak reference object");

	        // This is now a weak reference.
	        // The object will be collected only if no strong references are
	        // available.
	        ReferenceClass becameWeakReferenceObject = new ReferenceClass();
	        WeakReference<ReferenceClass> weakReference = new WeakReference<ReferenceClass>(
	                becameWeakReferenceObject);

	        // Trying to remove the to reference and claim memory from suggested
	        // reference.
	        WeakReferenceObject.GrabgecollectionCall();

	        System.out.println("Removing reference by assigning the StrongReference with Null");

	        // Checking the memory reference of weakReference object,before
	        // making
	        // the becameSoftReferenceObject = null

	        System.out
	                .println("Checking the softReference object reference value before GC call-"
	                        + weakReference.get());

	        // The object will be garbage collected when the
	        // becameWeakReferenceObject is not having any reference .
	        becameWeakReferenceObject = null;

	        WeakReferenceObject.GrabgecollectionCall();

	        /*
	         * Checking the memory reference of weakReference object,after making
	         * the becameWeakReferenceObject = null, as GC is called when when
	         * object is not having any reference.
	         */

	        System.out
	                .println("Checking the WeakReference object reference value after GC call-"
	                        + weakReference.get());

	        System.out.println("*****Execution Completed*****");

	    }

	    public static class ReferenceClass {
	        protected void finalize() {
	            System.out
	                    .println("Calling the finalize method of ReferenceClass(a static inner class), Weak reference is now removed");
	        }
	    }
}
