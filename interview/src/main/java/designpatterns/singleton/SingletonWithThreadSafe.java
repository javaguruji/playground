package designpatterns.singleton;

/**
 * @author badrikant.soni
 *
 * HandleMultithread -
 *
 * To Improve the singleton pattern in multithreaded environment, we use the synchronized block with class lock and volatile variable.
 *
 * Example : PropertyReader, Logger, DataSource Class
 *
 * 1. PropertyReader class which reads data from properties file and can be used in multiple times in different class in application.
 * But we create a single object of PropertyReader Class which is shared across multiple classes in application which saves memory.
 *
 * 2. Logger class which is used to log different type of information such as Error, Debug and general Info. A good example of singleton pattern.
 *
 * 3. DataSource class in JDBC world is responsible for maintaining a connection pool and giving connection from connection pool.
 * */
public class SingletonWithThreadSafe {

    private static volatile SingletonWithThreadSafe instance;

    private SingletonWithThreadSafe() {
        // stop direct object creation using private constructor
    }

    public static SingletonWithThreadSafe getInstance() {

        if(null == instance){
            synchronized (SingletonWithThreadSafe.class) { // // since acquiring the class is expensive operation for evey calls, hence check if instance is created already
                if (null == instance) {  // create object if its not already created
                    instance = new SingletonWithThreadSafe();
                }
            }
        }
        return instance;
    }
}
