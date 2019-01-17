import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[]args){
    /*try{
    File file = new File("Puzzles.txt");
    Scanner in = new Scanner(file);
    int i = 0;//randgen.nextInt() % 2;
    for (int k = 0; k < i * 9; k++) {
      in.nextInt();
    }
    while (in.hasNext()){
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        nums[x][y] = in.nextInt(); //copying over char values to answer
        System.out.println(in.nextInt() + "\n");
      }
    } catch (FileNotFoundException e) {
    System.out.println("File not found");
    System.exit(1);
  }*/

    int[][] easy = new int[][]{
      {2, 9, 6, 3, 1, 8, 5, 7, 4},
      {5, 8, 4, 9, 7, 2, 6, 1 ,3},
      {7, 1, 3, 6, 4, 5, 2, 8, 9},
      {6, 2, 5, 8, 9, 7, 3, 4, 1},
      {9, 3, 1, 4, 2, 6, 8, 5, 7},
      {4, 7, 8, 5, 3, 1, 9, 2, 6},
      {1, 6, 7, 2, 5, 3, 4, 9, 8},
      {8, 5, 9, 7, 6, 4, 1, 3, 2},
      {3, 4, 2, 1, 8, 9, 7, 6, 5},
    };
    Sudoku newBoard = new Sudoku("hard");
    System.out.println(newBoard);
    /*System.out.println(newBoard.getPuzzle(0,1));
    System.out.println(newBoard.originalBoard());
    newBoard.setPuzzle(1, 6, '9');
    //System.out.println(newBoard.hint());
    System.out.println(newBoard);
    if (args[0].equals("easy")) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
    System.out.println(args[0]);*/
    System.out.println(newBoard.getKey());
    /*newBoard.setPuzzle(1, 6, '9');
    newBoard.setPuzzle(3, 6, '7');
    System.out.println(newBoard);
    newBoard.save();
    System.out.println(newBoard.myBoard());
    System.out.println(newBoard.getKey());
    newBoard.save();
    newBoard.hint();
    System.out.println(newBoard);*/
  }
}
