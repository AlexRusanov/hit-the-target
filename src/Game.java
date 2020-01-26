import java.util.Scanner;

public class Game {

    private boolean[][]field = new boolean[5][5];
    private Target target;

    public Game() {
        this.field = new boolean[5][5];
    }

    public void setTarget() {
        this.target = new Target();
    }

    public void printFiled() {
        int[] target = this.target.getCoordinates();
        boolean isBeingHit = this.target.getIsBeingHit();

        System.out.println(" 0 | 1 | 2 | 3 | 4 | 5 |");
        for (int i = 1; i < 6; i++) {
            System.out.print(" " + i + " |");
            for (int j = 0; j < 5; j++) {
                if (isBeingHit && (i == target[0] && j == target[1])){
                    System.out.print(" x |");
                } else {
                    if (field[i-1][j]) {
                        System.out.print(" * |");
                    } else {
                        System.out.print(" - |");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public void play() {
        while (true) {
            System.out.println("All set. Get ready to rumble!");
            setTarget();

            int[] coordinatesToHit = new int[2];
            int[] target = this.target.getCoordinates();

            while (!this.target.getIsBeingHit()) {
                System.out.println("Enter row number");
                coordinatesToHit[0] = enteredNumberValidation();

                System.out.println("Enter column number");
                coordinatesToHit[1] = enteredNumberValidation();

                if(coordinatesToHit[0] != target[0] || coordinatesToHit[1] != target[1]) {
                    field[coordinatesToHit[0]][coordinatesToHit[1]] = true;
                    printFiled();
                } else {
                    this.target.setBeingHit(true);
                    System.out.println("You have won!");
                    printFiled();
                }
            }
            System.out.print("\n");
            field = new boolean[5][5];
        }
    }

    public int enteredNumberValidation() {
        Scanner scanner = new Scanner(System.in);
        String result;

        while (!(result = scanner.next()).matches("[1-5]")) {
            System.out.println("It's not a number or not correct number. Please enter the correct number!");
        }

        return Integer.parseInt(result) - 1;
    }
}
