package com.standalone.examples.javamemory;

public class StrongReferenceObject {
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

        System.out.println("For the Creation of a strong references object");

        // This is example of a strong reference object.
        // If all the refernce of the below object is not available then the
        // object will get garbage collected.

        // @SuppressWarnings("unused")
        ReferenceClass strongReference = new ReferenceClass();

        // Attempt to claim a suggested reference.
        StrongReferenceObject.GrabgecollectionCall();

        System.out
                .println("Strong object refernce value before removing the refernces-"
                        + strongReference);
        // The object may now be collected.
        strongReference = null;

        StrongReferenceObject.GrabgecollectionCall();

        System.out
                .println("Strong object refernce value after removing the refernces-"
                        + strongReference);

        System.out.println("*****Execution Completed*****");

    }

    public static class ReferenceClass {
        protected void finalize() {
            System.out
                    .println("Calling the finalize method of ReferenceClass(a static inner class), Strong reference is now removed");
        }

    }
}
