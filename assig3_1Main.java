package assig3_1;

public class assig3_1Main {
    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        Gamer gamer1 = new Gamer(gamePlay);
        Gamer gamer2 = new Gamer(gamePlay);

        gamer1.start();
        gamer2.start();
        try {
            gamer1.join();
            gamer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        gamer1.interrupt();
        if (gamer1.getScore() > gamer2.getScore())
            System.out.println(gamer1.getName());
        else if (gamer1.getScore() >= gamer2.getScore())
            System.out.println("tie");
        else System.out.println(gamer2.getName());
    }
}
