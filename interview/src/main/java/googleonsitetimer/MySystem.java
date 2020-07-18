package googleonsitetimer;

public interface MySystem {

    void setTimer(long durationMillis, Runnable callback);
    long getCurrentTimeMillis();
    void addTimer(long durationMillis, Runnable callback);
}
