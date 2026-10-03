public class Box {
    private Player player;
    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isEmpty() {
        return player == null;
    }

    public void clear(){
        player = null;
    }

    @Override
    public String toString() {
        return player.toString();
    }
    
}
