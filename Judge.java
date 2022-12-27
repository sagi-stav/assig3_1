package assig3_1;

public class Judge {
    GamePlay gamePlay;

    Judge(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    public synchronized void changeCoin() {
        while (!Thread.interrupted()) {
            gamePlay.makeCoinAvail(false);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            notifyAll();
            gamePlay.makeCoinAvail(true);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
