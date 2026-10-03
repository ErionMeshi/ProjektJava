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

    public boolean canBePlacedOver(Box other) {
        return true;
    }

    public boolean canEnter() {
        return true;
    }

    public String getBlockedMessage() {
        return "Nuk mund te kalosh ketu.";
    }

      public String getSymbol() {
        return "   ";
    }

    public String onEnter(Player player) {
        return "Playeri ka hyre ne kutine.";
    }

   @Override
    public String toString() {
    return player == null ? getSymbol() : player.toString();}
    
    
}
