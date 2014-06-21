package com.standalone.examples.javamemory;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class PhantomReferenceExample {

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

	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    public static void main(String args[]) throws InterruptedException {
	        System.out.println("Creating phantom references");

	        // The reference itself will be appended to the dead queue for clean up.
	        ReferenceQueue referenceQueue = new ReferenceQueue();

	        // This map is just a sample we might use to locate resources we need to
	        // clean up.
	        Map<Reference, String> freeMemoryMap = new HashMap<Reference, String>();

	        // Below reference is now became a phantom reference.
	        // The object will be collected only if no strong references are
	        // available.
	        ReferenceClass phantomRefObject = new ReferenceClass();

	        PhantomReference<ReferenceClass> phantom = new PhantomReference(
	                phantomRefObject, referenceQueue);

	        freeMemoryMap.put(phantom, "PhantomReference object Value");

	        phantomRefObject = null;

	        // The object may now be garbage collected
	        PhantomReferenceExample.GrabgecollectionCall();

	        // Check for
	        Reference reference = referenceQueue.poll();
	        if (reference != null) {
	            System.out
	                    .println("Removing the key of PhantomReference from Map - "
	                            + freeMemoryMap.remove(reference));
	        }
	        System.out
	                .println("After removing the PhantomReference key from cleanUpMap -> "
	                        + freeMemoryMap.get(reference));
	        System.out.println("*****Execution Completed*****");
	    }

	    public static class ReferenceClass {
	        // If there is a finalize() method then PhantomReference's doesn't
	        // get appended to a ReferenceQueue
	    }

}
