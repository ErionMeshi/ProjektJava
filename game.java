public class game {
    

    public static void main(String[] args) {
       
        Board b = new Board();

        Player p1 = new Player();

        b.setPlayer(1, 1, p1);
        System.out.println(b.toString());
    }
}
