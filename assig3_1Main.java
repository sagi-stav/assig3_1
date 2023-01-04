package assig3_1;

public class assig3_1Main {
    public static void main(String[] args) {
//        Random r = new Random();
//        for (int i = 0; i < 10; i++)
//            System.out.println(r.nextInt(2));
        GamePlay gamePlay = new GamePlay();
        Gamer gamer1 = new Gamer(gamePlay);
        Gamer gamer2 = new Gamer(gamePlay);
        Judge judge = new Judge(gamePlay);

        gamer1.start();
        gamer2.start();
        judge.start();
        try {
            gamer1.join();
            gamer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (gamer1.getScore() > gamer2.getScore())
            System.out.println(gamer1.getName() + " This thread is the winner");
        else if (gamer1.getScore() >= gamer2.getScore())
            System.out.println("tie");
        else System.out.println(gamer2.getName() + " This thread is the winner");

            gamer1.interrupt();

    }
}
