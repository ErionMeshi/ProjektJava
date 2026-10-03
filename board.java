public class Board {

    
    private Box[][] boxes;
    private Pozicioni currentPosition;

    public Board() {
        boxes = new Box[4][4];

        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = new Box();
            }
        }
    }

    public void setPlayer(Pozicioni position, Player player) {
        Box box = getBox(position);
        box.setPlayer(player);
        currentPosition = position;
    }

    public Box getBox(Pozicioni position) {
        return boxes[position.getRow()][position.getCol()];
    }




    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                sb.append(boxes[i][j].isEmpty() ? "|   | " : "|" + boxes[i][j].getPlayer().toString() + "| ");
            }
            sb.append("\n");
            sb.append("-----------------------");
            sb.append("\n");
        }
        return sb.toString();
    }


}
