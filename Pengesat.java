public class Pengesat extends Box {
    
   @Override 
    public boolean canBePlacedOver(Box other) {
        return other.isEmpty();
    }

    @Override 
    public boolean canEnter() {
        return false;
    }
    @Override
    public String getBlockedMessage() {
        return "Nuk mund te kalosh ketu.";
    }

    @Override
    public String onEnter(Player player) {
        return "Playeri ka hyre ne pengesen.";
    }

    @Override
    public String getSymbol() {
    return " # ";
    }

    
}
