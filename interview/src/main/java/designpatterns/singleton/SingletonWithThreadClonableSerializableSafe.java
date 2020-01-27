package designpatterns.singleton;

import java.io.Serializable;

/**
 * @author badrikant.soni
 */
public class SingletonWithThreadClonableSerializableSafe implements Cloneable, Serializable {

    private static volatile SingletonWithThreadClonableSerializableSafe instance;

    private SingletonWithThreadClonableSerializableSafe() {

    }

    public static SingletonWithThreadClonableSerializableSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonWithThreadClonableSerializableSafe.class) {
                if (instance == null) {
                    instance = new SingletonWithThreadClonableSerializableSafe();
                }
            }
        }
        return instance;
    }

    // Should override this method and throw an exception if some other class try to clone the object.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException();
    }

    // Should implement this method for fixing the serialization problem
    protected Object readResolve() {
        return instance;
    }
}
