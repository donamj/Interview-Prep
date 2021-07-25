# Java Thread Basics

## Setting up Threads
There are two ways to set up threads
1.  Runnable Interface <br />
    ```
        public static void main(String args[])
        {
            Thread t = new Thread(new Runnable()
            {
                public void run()
                {
                    System.out.println("Thread created!");
                }
            });
            t.start();
        }
    ```

    A much cleaner way is to create a separate class implementing the Runnable interface and then pass the object to Thread constructor.
    ```
    class MyRunnable implements Runnable { 
        public void run() {
            System.out.println("Say Hello");
        }
    }

    public static void main( String args[] ) {
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }
    ```

2. Subclassing Thread class
    ```
    class MyThread extends Thread { 
        @Override
        public void run() {
            System.out.println("I ran after extending Thread class");
        }
    }

    public static void main( String args[] ) {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
    }
    ```


The con of the second approach is that one is forced to extend the Thread class which limits code's flexibility. Passing in an object of a class implementing the Runnable interface may be a better choice in most cases.

## ConcurrentHashMap
Compared to its synchronized cousins HashTable and ConcurrentHashMap, HashMap is lightweight and faster, but can only be used in single-threaded scenarios. CocurrentHashMap is a thread-safe class and multiple threads can operate on it in parallel without incurring any of the issues that a HashMap may suffer from in a concurrent environment.

Notable properties of the ConcurrentHashMap class are listed below:

* null can’t be inserted either as a key or a value.
* The ConcurrentHashMap shards its data into segments and the segments are locked individually when being written to. Each segment can be written independently of other segments allowing multiple threads to operate on the map object.
* The reads happen without locking for the majority of cases, thus making them synchronization-free and improving performance. However, note that there are certain minority scenarios when reads have to go through synchronization.
* In general, using keys that evaluate to the same hashCode will slow down the performance of any hash map.

<br/>

## Mutex vs Semaphore
* Mutex is a locking mechanism whereas Semaphore is a signaling mechanism
* Mutex is just an object while Semaphore is an integer
* Mutex has no subtype whereas Semaphore has two types, which are counting semaphore and binary semaphore.
* Semaphore supports wait and signal operations modification, whereas Mutex is only modified by the process that may request or release a resource.
* Semaphore value is modified using wait () and signal () operations, on the other hand, Mutex operations are locked or unlocked.

<b> Use of Semaphore: </b> <br/>
In the case of a single buffer, we can separate the 4 KB buffer into four 1 KB buffers. Semaphore can be associated with these four buffers. This allows users and producers to work on different buffers at the same time.

<b> Use of Mutex: </b> <br/>
A mutex provides mutual exclusion, which can be either producer or consumer that can have the key (mutex) and proceed with their work. As long as producer fills buffer, the user needs to wait, and vice versa. In Mutex lock, all the time, only a single thread can work with the entire buffer.