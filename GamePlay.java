package assig3_1;

import java.util.Random;

public class GamePlay {
    private boolean coin_available_;
    private int rounds_counter_;
    private Random random = new Random();
    GamePlay() {
        coin_available_ = true;
        rounds_counter_ = 0;
    }

    public int getNumOfRounds() {
        return rounds_counter_;
    }

    public synchronized void makeCoinAvail(boolean val) {
        if (val != coin_available_) {
            coin_available_ = val;
            notifyAll();
        }
    }
    public synchronized int flipCoin(){
        while (!coin_available_){
            try {
                System.out.println(Thread.currentThread().getName()+" is waiting for coin");
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName()+" is flipping coin");
        coin_available_=false;
        rounds_counter_++;
        int r = random.nextInt(1);
        System.out.println("the random number is: "+r);
        notifyAll();
        return r;
    }
}
