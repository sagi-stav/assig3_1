package assig3_1;

public class Judge extends Thread {
    GamePlay gamePlay;

    Judge(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }
    public void run() {
        changeCoin();
    }
    public synchronized void changeCoin() {
        System.out.println(Thread.currentThread().getName() + " in judge.changeCoin ");
        while (!Thread.interrupted()) {
            gamePlay.makeCoinAvail(false);
            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            notifyAll();
            gamePlay.makeCoinAvail(true);
            notifyAll();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " exit judge.changeCoin ");

    }

    private synchronized void changeCoinToTrue() {

    }
}
