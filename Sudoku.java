import java.io.*;
import java.util.*;
public class Sudoku{
  private char[][] puzzle;

  private char[][] original;

  private char[][] answer;

  private char[][] savedBoard;

  private String difficulty;

  private int seed;

  private Random randgen;

  public Sudoku(int[][] nums, String level){
    answer = new char[nums.length][nums[0].length];
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        answer[x][y] = (char)(nums[x][y] + 48); //copying over char values to answer
      }
    }
    puzzle = new char[nums.length][nums[0].length];
    savedBoard = new char[nums.length][nums[0].length];
    original = new char[nums.length][nums[0].length];
    Random randSeed = new Random ();
    int rand = 0;
    seed = Math.abs((randSeed.nextInt() % 10000));
    randgen = new Random(seed);
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        if(level.equals("easy")){
          difficulty = level;
          rand = randgen.nextInt() % 2; //finding random positions to place the numbers on the board
        }
        if(level.equals("medium")){
          difficulty = level;
          rand = randgen.nextInt() % 3;
        }
        if(level.equals("hard")){
          difficulty = level;
          rand = randgen.nextInt() % 4;
        }
        if (rand == 1) {
          puzzle[x][y] = (char)(nums[x][y] + 48); //displaying char values on board at some positions
        } else {
          puzzle[x][y] = (char)95; //displaying '_' at unfilled positions
        }
      }
    }
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        savedBoard[x][y] = puzzle[x][y];
        original[x][y] = puzzle[x][y];
      }
    }
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
    int rand = 0;
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        if(difficulty == "easy"){
          rand = randgen.nextInt() % 2; //finding random positions to place the numbers on the board
        }
        if(difficulty == "medium"){
          rand = randgen.nextInt() % 3;
        }
        if(difficulty == "hard"){
          rand = randgen.nextInt() % 4;
        }
        if (rand == 1) {
          puzzle[x][y] = (char)(nums[x][y] + 48);
        } else {
          puzzle[x][y] = (char)95;
        }
      }
    }
    savedBoard = new char[nums.length][nums[0].length];
    original = new char[nums.length][nums[0].length];
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        savedBoard[x][y] = puzzle[x][y];
        original[x][y] = puzzle[x][y];
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

  public String originalBoard(){ //displays the last saved board
    String newstr = "\nOriginal board: \n";
    for (int x = 0; x < original.length; x ++ ) {
      for (int y = 0; y < original[0].length; y ++) {
        if(y % 3 == 2){
          newstr += "|" + original[x][y] + "| ";
        }
        else{
        newstr+= "|" + original[x][y];
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

  public char getOriginal(int x, int y){
    return original[y][x];
  }

  public char[][] getOriginalPuzzle(){
    return original;
  }

  public void reset() {
    for (int x = 0; x < original.length; x ++ ) {
      for (int y = 0; y < original[0].length; y ++) {
        puzzle[x][y] = original[x][y];
      }
    }
  }

  public char getPuzzle(int x, int y){
    return puzzle[y][x];
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

  public void hint(){
    Random randNum = new Random();
    int xnum = Math.abs(randNum.nextInt() % 9); // random x and y positions
    int ynum = Math.abs(randNum.nextInt() % 9);
    int tries = 1000;
    while (tries > 0){ //if the position is occupied by a number, try again to find an empty position
      if (original[xnum][ynum] == '_') {
        original[xnum][ynum] = answer[xnum][ynum];
        tries = 0;
      }
      xnum = Math.abs(randNum.nextInt() % 9);
      ynum = Math.abs(randNum.nextInt() % 9);
      tries--;
    }
  }

  public boolean check() {
    for (int x = 0; x < puzzle.length; x++) {
      for (int y = 0; y < puzzle[0].length; y ++) {
        if (puzzle[x][y] != answer[x][y]) {
          return false;
        }
      }
    }
    return true;
  }

}
