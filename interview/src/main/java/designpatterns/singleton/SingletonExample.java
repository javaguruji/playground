package designpatterns.singleton;

/**
 * @author badrikant.soni
 *
 * Singleton design pattern allows to create one and only one object of particular class in Application.
 *
 * Advantage :  it helps to save memory by creating only one object across the application.
 *
 * How to create singleton pattern -
 * 1. By declaring private constructor  - stop direct object creation
 * 2. By declaring a static method  - allow other class to create single object
 * 3. By declaring a static member of same class type  - return the same type of that class
 *
 * Lazy Initialization
 *
 * This is preferred way to use singleton pattern.
 * In this case, we create an instance only when its required is called lazy instantiation or initialization.
 *
 * Example : PropertyReader, Logger, DataSource Class
 *
 * 1. PropertyReader class which reads data from properties file and can be used in multiple times in different class in application.
 * But we create a single object of PropertyReader Class which is shared across multiple classes in application which saves memory.
 *
 * 2. Logger class which is used to log different type of information such as Error, Debug and general Info. A good example of singleton pattern.
 *
 * 3. DataSource class in JDBC world is responsible for maintaining a connection pool and giving connection from connection pool.
 */
class SingletonExample {

    private static SingletonExample instance = null;

    private SingletonExample() {
    }

    static SingletonExample getInstance() {

        if (null == instance) {
            instance = new SingletonExample();
            System.out.println(instance.toString());
        }
        return instance;
    }
}
