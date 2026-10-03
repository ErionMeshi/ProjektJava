public class Board {

    
    private Box[][] boxes;
    private Pozicioni currentPosition;

    public Board(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Madhesia e tabeles duhet te jete pozitive.");
        }

        boxes = new Box[rows][cols];

        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = new Box();
            }
        }
    }

      public boolean isInside(Pozicioni position) {
        return position.getRow() >= 0 && position.getRow() < boxes.length
            && position.getCol() >= 0 && position.getCol() < boxes[0].length;
    }


    public void setPlayer(Pozicioni position, Player player) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("Pozicioni eshte jashte kufijve te tabeles.");
        }

        Box box = getBox(position);
        box.setPlayer(player);
        currentPosition = position;
    }

    public Box getBox(Pozicioni position) {
        return boxes[position.getRow()][position.getCol()];
    }

     public boolean placeBox(Pozicioni position, Box box) {
        if (!isInside(position))
             return false;
        if (!box.canBePlacedOver(getBox(position)))
             return false;
        boxes[position.getRow()][position.getCol()] = box;
        return true;
    }

    public String movePlayer(int dRow, int dCol) {
        Pozicioni next = currentPosition.translate(dRow, dCol);
 
        if (!isInside(next)) {
            return "Nuk mund te dalesh jashte tabeles.";
        }
 
        Box target = getBox(next);
        if (!target.canEnter()) {
            return target.getBlockedMessage();
        }
 
        Box current = getBox(currentPosition);
        Player player = current.getPlayer();
        current.clear();
        target.setPlayer(player);
        currentPosition = next;
 
        return target.onEnter(player);
    }



@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    String line = "-".repeat(boxes[0].length * 6);
    for (int i = 0; i < boxes.length; i++) {
        for (int j = 0; j < boxes[i].length; j++) {
            sb.append("|").append(boxes[i][j]).append("| ");
        }
        sb.append("\n");
        sb.append(line);
        sb.append("\n");
    }
    return sb.toString();
    }
}



