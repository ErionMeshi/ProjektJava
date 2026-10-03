public class game {
    private final Display display = new Display();
    private Board board;
    public static void main(String[] args) {
       new game().start();}


        public void start() {
            if(!initBoard())
                return;
            display.showBoard(board);      
            lexoPengesen();               
            display.showBoard(board);      
            playLoop();                    
            display.showMessage("Loja perfundoi.");
       
    }

    private boolean initBoard() {
        while (true) {
            String line = display.inputi("Inicilizo tabelen: ");
            if (line == null)
                 return false;
            String[] parts = line.split("\\s*,\\s*");

            try {
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Duhen 4 numra, p.sh. 4, 4, 1, 1");
                }
                int rows = Integer.parseInt(parts[0]);
                int cols = Integer.parseInt(parts[1]);
                int pr = Integer.parseInt(parts[2]);
                int pc = Integer.parseInt(parts[3]);
 
                Board b = new Board(rows, cols);
                b.setPlayer(new Pozicioni(pr, pc), new Player());
                board = b;
 
                display.showMessage("Tabela " + rows + "X" + cols
                        + " u ndertua dhe lojtari u vendos ne poziten " + pr + "x" + pc);
                return true;
            } catch (NumberFormatException e) {
                display.showMessage("Hyrje e pavlefshme: perdorni vetem numra.");
            } catch (IllegalArgumentException e) {
                display.showMessage("Gabim: " + e.getMessage());
            }
        }
    }
         private void lexoPengesen() {
         
            String line = display.inputi("Vendos pengese: ");
            if (line == null || line.isEmpty()) return;
            String[] parts = line.split("\\s*,\\s*");
            try {
                if (parts.length != 2) throw new NumberFormatException();
                Pozicioni p = new Pozicioni(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
 
                if (!board.isInside(p)) {
                    display.showMessage("Pengesa eshte jashte tabeles.");
                } else if (!board.placeBox(p, new Pengesat())) {
                    display.showMessage("Nuk lejohet pengese mbi kutine e lojtarit.");
                }
            } catch (NumberFormatException e) {
                display.showMessage("Hyrje e pavlefshme. Formati: rresht,kolone (p.sh. 2,2)");
            }
        
    }
 
    private void playLoop() {
        while (true) {
            String input = display.inputi("Komanda (W/A/S/D, Q per dalje): ");
            if (input == null) return;
            switch (input.toUpperCase()) {
                case "W": move(-1, 0); break;
                case "S": move(1, 0);  break;
                case "A": move(0, -1); break;
                case "D": move(0, 1);  break;
                case "Q": return;
                default:  display.showMessage("Komande e panjohur.");
            }
        }
    }
 
    private void move(int dRow, int dCol) {
        String message = board.movePlayer(dRow, dCol);
        if (message != null) {
            display.showMessage(message);
        }
        display.showBoard(board);
    }
}
