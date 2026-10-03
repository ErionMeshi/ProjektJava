public class game {
    

    public static void main(String[] args) {
       
        Board b = new Board();

        Player p1 = new Player();
        Pozicioni pos1 = new Pozicioni(1, 1);
        b.setPlayer(pos1, p1);
        System.out.println(b.toString());
    }
}
