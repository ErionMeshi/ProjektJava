import java.util.Scanner;

public class Display {
    private final Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String inputi(String message) {
        System.out.print(message);
        return scanner.hasNextLine() ? scanner.nextLine() : null;
    }

    public void showBoard(Board board) {
        System.out.println(board.toString());
    }
}
