#Learn more about how to deal with thread-pools in Java.

#How Much Memory A Java Thread Takes -
https://dzone.com/articles/how-much-memory-does-a-java-thread-take

A memory, which is taken by all Java threads, is a significant part of the total memory consumption of your application. 
There are a few techniques on how to limit the number of created threads, depending on whether your application is CPU-bound or IO-bound. 
If your application is rather IO-bound, you will very likely need to create a thread pool with a significant number of threads which can 
be bound to some IO operations (in blocked/waiting state, reading from DB, sending HTTP request).

However, if your app rather spends time on some computing task, you can, for instance, use HTTP server (e.g. Netty) with a lower number of threads and save a lot of memory. 
Let's look at an example of how much memory we need to sacrifice to create a new thread.

#ForkJoinPool#commonPool Introduction
Link : https://dzone.com/articles/be-aware-of-forkjoinpoolcommonpool#:~:text=ForkJoinPool%23commonPool()%20is%20a,initialized%20when%20is%20actually%20needed.&text=The%20trick%20is%20that%20it,commonPool%20to%20execute%20your%20work.

Let's start with a very brief introduction and then go straight to some examples. 

ForkJoinPool#commonPool() is a static thread-pool, which is lazily initialized when is actually needed. 
Two major concepts use the commonPool inside JDK: CompletableFuture and  Parallel Streams. 
There is one small difference between those two features: with  CompletableFuture, 
you are able to specify your own thread-pool and don't use the threads from the commonPool, you cannot in case of  Parallel Streams.

In the case of a computational task, we create a task that absolutely avoids any blocking such as I/O operation (database invocation, synchronization, thread sleep, etc...). 
The trick is that it does not matter on which thread your task is running, you keep your CPU busy and don't wait for any resources. Then, feel free to use commonPool to execute your work.

However, if you intend to use commonPool for blocking tasks, then you need to consider some consequences. If you have more than three available CPUs, then your commonPool is automatically sized to two threads and you can very easily block execution of any other part of your system that uses the commonPool at the same time by keeping the threads in a blocked state. As a rule of thumb, we can create our own thread-pool for blocking tasks and keep the rest of the system separated and predictable.



