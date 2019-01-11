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
        answer[x][y] = (char)(nums[x][y] + 48); //copying over char values to answer
      }
    }
    puzzle = new char[nums.length][nums[0].length];
    Random randSeed = new Random ();
    seed = Math.abs((randSeed.nextInt() % 10000));
    randgen = new Random(seed);
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        int rand = randgen.nextInt() % 2; //finding random positions to place the numbers on the board
        if (rand == 1) {
          puzzle[x][y] = (char)(nums[x][y] + 48); //displaying char values on board at some positions
        } else {
          puzzle[x][y] = (char)95; //displaying '_' at unfilled positions
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

  public String toString(){ //prints the board currently working on
    String newstr = "\nPuzzle: \n";
    for (int x = 0; x < puzzle.length; x ++ ) {
      for (int y = 0; y < puzzle[0].length; y ++) {
        if(y % 3 == 2){
          newstr += "|" + puzzle[x][y] + "| "; //positioning the numbers in a sudoku board to make 9 3x3 boards
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

  public String myBoard(){ //displays the last saved board
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

  public String getKey(){ //displays the answer key
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

  public int getSeed(){
    return seed;
  }

  public void setPuzzle(int y, int x, char num) { //changing the values in the sudoku board at a specific position
    puzzle[x][y] = num;
  }

  public void save() {
    for (int x = 0; x < puzzle.length; x ++ ) {
      for (int y = 0; y < puzzle[0].length; y ++) {
          savedBoard[x][y] = puzzle[x][y]; //copies over values from the puzzle to the savedBoard array
        }
      }
    try{
    File file = new File("savedBoard.txt");
    if(!file.exists()){
      file.createNewFile(); //creates the text file savedBoard if not existent already
    }

    FileWriter writer = new FileWriter(file);
    BufferedWriter board = new BufferedWriter(writer);
    for(int x = 0; x < savedBoard.length; x++){
      for(int y = 0; y < savedBoard[0].length; y++){
        board.write(savedBoard[x][y]); //enters values of the savedBoard into the text file
      }
      board.write("\n");
    }
    board.close();
    //System.out.println("Saved Successful!");
  } catch (IOException exception){
    exception.printStackTrace();
  }
  }

  public char hint(){
    Random randNum = new Random();
    int xnum = Math.abs(randNum.nextInt() % 9); // random x and y positions
    int ynum = Math.abs(randNum.nextInt() % 9);
    int tries = 1000;
    while (puzzle[xnum][ynum] != (char)95 && tries > 0){ //if the position is occupied by a number, try again to find an empty position
      xnum = Math.abs(randNum.nextInt() % 10);
      ynum = Math.abs(randNum.nextInt() % 10);
      tries--;
    }
    puzzle[xnum][ynum] = answer[xnum][ynum]; //add the random value from the key to the puzzle
    return puzzle[xnum][ynum];
  }

}
