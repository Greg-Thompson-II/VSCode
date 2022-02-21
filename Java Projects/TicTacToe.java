import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TicTacToe{
    
    static ArrayList<Integer> playerPostions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPostions = new ArrayList<Integer>();
    public static void main(String args[]){
        char [][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

        printBoard(gameBoard);
        boolean running = true;
        while(running){

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter location to Symbol (1-9): ");
            int playerLocation = scan.nextInt();
            while(playerPostions.contains(playerLocation) || cpuPostions.contains(playerPostions)){
                System.out.println("Positon taken...Enter a valid location");
                playerLocation = scan.nextInt();
            }

            placeSymbol(gameBoard, playerLocation, "player");
        
            Random r = new Random();
            int cpuLocation = r.nextInt(9)+1;
            while(playerPostions.contains(cpuLocation) || cpuPostions.contains(cpuLocation)){
                //System.out.println("Positon taken...Enter a valid location");
                cpuLocation = r.nextInt(9)+1;
            }
            placeSymbol(gameBoard, cpuLocation, "CPU");

            printBoard(gameBoard);
            String result = checkWinner();
            System.out.print(result);
            //running = false;
        }
    }

    public static void printBoard(char [][] gameBoard){
        for( char[] row: gameBoard) {
            for(char x : row) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void placeSymbol(char [][] gameBoard, int location, String user){

        char symbol = ' ';

        if (user.equals("player")){
            symbol = 'X';
            playerPostions.add(location);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            cpuPostions.add(location);
        }
        
        switch(location) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner(){
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List firstCol = Arrays.asList(1, 4, 7);
        List secondCol = Arrays.asList(2,5,8);
        List thirdCol = Arrays.asList(3,6,9);
        List fwdDiag = Arrays.asList(1,5,9);
        List bwdDiag = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(firstCol);
        winning.add(secondCol);
        winning.add(thirdCol);
        winning.add(fwdDiag);
        winning.add(bwdDiag);

        for(List l : winning){
            if(playerPostions.containsAll(l)){
                return "You Won";
            }
            else if(cpuPostions.containsAll(l)){
                return "You lost :(";
            } else if (playerPostions.size() + cpuPostions.size() == 9){
                return "CAT";
            }
        }
        return "";

    }
}