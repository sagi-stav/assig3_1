package assig3_1;

public class Gamer extends Thread {
    private int goodFlipsCounter;
    GamePlay gamePlay;
    Judge judge;

    Gamer(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
        judge = new Judge(gamePlay);
    }

    public int getScore() {
        return goodFlipsCounter;
    }

    public void run (){
            play();
    }
    public synchronized void play() {
        while (!Thread.interrupted() && gamePlay.getNumOfRounds() <= 10) {//x<10 אני חושב שצריך
            goodFlipsCounter += gamePlay.flipCoin();
            judge.changeCoin();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        //if interrupted or NumOfRounds>10 end Thread.
    }
}
