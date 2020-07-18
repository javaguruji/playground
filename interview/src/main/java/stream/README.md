#What is Stream in Java 8?

A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

The features of Java stream are –

1. A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
2. Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
3. Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined. 
Terminal operations mark the end of the stream and return the result.


#CompletableFuture vs Parallel Stream
link : http://fahdshariff.blogspot.com/search/label/completablefuture

ForkJoinPool#commonPool() is a static thread-pool, which is lazily initialized when is actually needed.

CommonPool==> it has two concepts in JDK . 1) CompletableFuture 2) Parallel Stream.
there is small difference between in two is, CompletableFuture allows custom thread pool instead of using the CommonPool.
but Parallel Stream always uses the CommonPool.

Usage of completableFutures and Parallel Stream :
*CompletableFutures provide more control over the size of the thread pool and should be used if your tasks involve I/O.
However, if you're doing CPU-intensive operations, there's no point in having more threads than processors, so go for a parallel stream