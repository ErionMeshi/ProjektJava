public class Pozicioni {
    private int row;
    private int col;
    
    public Pozicioni(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Pozicioni translate(int dRow, int dCol) {
        return new Pozicioni(row + dRow, col + dCol);
    }

}
