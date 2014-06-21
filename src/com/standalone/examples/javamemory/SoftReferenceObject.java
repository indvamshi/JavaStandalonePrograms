package com.standalone.examples.javamemory;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceObject {

	 public static void GrabgecollectionCall() {
	        try {
	            System.out.println("Call for the garbage collection");
	            System.gc();
	            System.out.println("Thread is Sleeping now for 3S");
	            Thread.sleep(3000);// for 3 seconds.
	        } catch (InterruptedException ie) {
	            ie.getMessage();
	        }
	    }

	    public static void main(String args[]) {

	        System.out.println("For the Creation of a soft reference object");

	        // This is now a soft reference.
	        // The object will be collected only if no strong references exist and
	        // the JVM really needs the memory.

	        ReferenceClass becameSoftReferenceObject = new ReferenceClass();

	        SoftReference<ReferenceClass> softReference = new SoftReference<ReferenceClass>(
	                becameSoftReferenceObject);

	        // Attempt to claim a suggested reference.
	        SoftReferenceObject.GrabgecollectionCall();

	        // Checking the memory reference of softReference object,before making
	        // the becameSoftReferenceObject = null
	        System.out
	                .println("Checking the softReference object reference value before GC call-"
	                        + softReference.get());

	        // As here we are not removing the reference of
	        // becameSoftReferenceObject, but due to Memory requirement
	        // GrabgecollectionCall is done.
	        becameSoftReferenceObject = null;
	        SoftReferenceObject.GrabgecollectionCall();

	        System.out
	                .println("Consuming heap space by creating the large ArrayList object");
	        try {
	            // This will create a large objects list in the heap
	            List<SoftReferenceObject> heapList = new ArrayList<SoftReferenceObject>(
	                    10000);
	            while (true) {
	                heapList.add(new SoftReferenceObject());
	            }
	        } catch (OutOfMemoryError e) {
	            // The soft object should have been collected before this
	            System.out.println("Out of memory error thrown by the program");
	        }

	        /*
	         * Checking the memory reference of softReference object,after making
	         * the becameSoftReferenceObject = null, as GC is called when
	         * OutOfMemoryError is occurred
	         */

	        System.out.println("Checking the softReference object reference value-"
	                + softReference.get());

	        System.out.println("*****Execution Completed*****");

	    }

	    public static class ReferenceClass {
	        protected void finalize() {
	            System.out
	                    .println("Calling the finalize method of ReferenceClass(a static inner class), Soft reference is now removed");
	        }
	    }

}
