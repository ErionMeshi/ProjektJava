public class Board {

    
    private Box[][] boxes;

    public Board() {
        boxes = new Box[4][4];

        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = new Box();
            }
        }
    }

    public void setPlayer(int row, int col, Player player) {
        boxes[row][col].setPlayer(player);
    }

    public Box getBox(int row, int col) {
        return boxes[row][col];
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
