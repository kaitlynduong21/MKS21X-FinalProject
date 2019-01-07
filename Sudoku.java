import java.io.*;
import java.util.*;
public class Sudoku{
  public char[][] puzzle;

  private char[][] answer;

  private char[][] savedBoard;

  private String difficulty;

  private int seed;

  private Random randgen;

  public Sudoku(int[][] nums){
    answer = new char[nums.length][nums[0].length];
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        answer[x][y] = (char)(nums[x][y] + 48);
      }
    }
    puzzle = new char[nums.length][nums[0].length];
    Random randSeed = new Random ();
    seed = Math.abs((randSeed.nextInt() % 10000));
    randgen = new Random(seed);
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        int rand = randgen.nextInt() % 2;
        if (rand == 1) {
          puzzle[x][y] = (char)(nums[x][y] + 48);
        } else {
          puzzle[x][y] = (char)95;
        }
      }
    }
    savedBoard = puzzle;
  }

  public Sudoku(int[][] nums, int seed1){
    answer = new char[nums.length][nums[0].length];
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        answer[x][y] = (char)(nums[x][y] + 48);
      }
    }
    puzzle = new char[nums.length][nums[0].length];
    randgen = new Random(seed1);
    seed = seed1;
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        int rand = randgen.nextInt() % 2;
        if (rand == 1) {
          puzzle[x][y] = (char)(nums[x][y] + 48);
        } else {
          puzzle[x][y] = (char)95;
        }
      }
    }
    savedBoard = new char[nums.length][nums[0].length];
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        savedBoard[x][y] = puzzle[x][y];
      }
    }
  }

  public String toString(){
    String newstr = "\nPuzzle: \n";
    for (int x = 0; x < puzzle.length; x ++ ) {
      for (int y = 0; y < puzzle[0].length; y ++) {
        if(y % 3 == 2){
          newstr += "|" + puzzle[x][y] + "| ";
        }
        else{
        newstr+= "|" + puzzle[x][y];
        }
      }
      if(x % 3 == 2){
        newstr += "\n";
      }
      newstr+= "\n";
    }
    return newstr += "Seed: " + seed;
  }

  public String myBoard(){
    String newstr = "\nLast saved board: \n";
    for (int x = 0; x < savedBoard.length; x ++ ) {
      for (int y = 0; y < savedBoard[0].length; y ++) {
        if(y % 3 == 2){
          newstr += "|" + savedBoard[x][y] + "| ";
        }
        else{
        newstr+= "|" + savedBoard[x][y];
        }
      }
      if(x % 3 == 2){
        newstr += "\n";
      }
      newstr+= "\n";
    }
    return newstr;
  }

  public String getKey(){
    String newstr = "\nKey: \n";
    for (int x = 0; x < answer.length; x ++ ) {
      for (int y = 0; y < answer[0].length; y ++) {
        if(y % 3 == 2){
          newstr += "|" + answer[x][y] + "| ";
        }
        else{
        newstr+= "|" + answer[x][y];
        }
      }
      if(x % 3 == 2){
        newstr += "\n";
      }
      newstr+= "\n";
    }
    return newstr;
  }

  public void save() {
    for (int x = 0; x < puzzle.length; x ++ ) {
      for (int y = 0; y < puzzle[0].length; y ++) {
        savedBoard[x][y] = puzzle[x][y];
      }
    }
    try{
    File file = new File("savedBoard.txt");
    if(!file.exists()){
      file.createNewFile();
    }

    FileWriter writer = new FileWriter(file);
    BufferedWriter board = new BufferedWriter(writer);
    for(int x = 0; x < savedBoard.length; x++){
      for(int y = 0; y < savedBoard[0].length; y++){
        board.write(savedBoard[x][y]);
      }
      board.write("\n");
    }
    board.close();
    System.out.println("Saved Successful!");
  } catch (IOException exception){
    exception.printStackTrace();
  }
  }

}
