package assig3_1;

public class Gamer extends Thread {
    private int goodFlipsCounter;
    GamePlay gamePlay;

    Gamer(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public int getScore() {
        return goodFlipsCounter;
    }

    public void run() {
        play();
    }

    public synchronized void play() {
        while (!Thread.interrupted() && gamePlay.getNumOfRounds() <= 10) {//x<10 אני חושב שצריך
            goodFlipsCounter += gamePlay.flipCoin();
            System.out.println(Thread.currentThread().getName() + " Number of time that coin " +
                    "landed on tree of this thread " + goodFlipsCounter);
            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }
        System.out.println("stop thread: " + Thread.currentThread().getName());
        //if interrupted or NumOfRounds>10 end Thread.
        Thread.interrupted();
    }
}
