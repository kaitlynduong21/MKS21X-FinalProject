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

  private int[][] nums;

  private int puzzleChoice;

  public Sudoku(String level){
    Random randSeed = new Random ();
    seed = Math.abs((randSeed.nextInt() % 10000));
    randgen = new Random(seed); // generates a random seed
    nums = new int[9][9];
    try{
    File file = new File("Puzzles.txt"); //looks into text file of puzzles to choose one
    Scanner in = new Scanner(file);
    puzzleChoice = Math.abs(randgen.nextInt() % 5); //randomly chooses one of the 5 puzzles printed
    for (int k = 0; k < puzzleChoice * 10 + 1; k++) { //scans the integers from specific lines in the file
      in.nextLine();
    }
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        nums[x][y] = in.nextInt(); //copying over char values to answer
    }
  }
  } catch (FileNotFoundException e) {
  System.out.println("File not found"); // if there is no text file, print an error
  System.exit(1);
}
    difficulty = level;
    answer = new char[9][9];
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        answer[x][y] = (char)(nums[x][y] + 48); //copying over char values to answer
      }
    }
    puzzle = new char[9][9];
    savedBoard = new char[9][9];
    original = new char[9][9];
    int count = 0;
    if(difficulty == "easy"){
      count = 30; //easy only fills in 30 spots in the board
    }
    if(difficulty == "medium"){
      count = 25; //med fills in 25
    }
    if(difficulty == "hard"){
      count = 20; //hard fills in 20
    }
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        puzzle[x][y] = (char)95; //fills in '_' character in the positions on the board
      }
    }
    while (count > 0) {
      int xcor;
      int ycor;
        xcor = Math.abs(randgen.nextInt() % 9);
        ycor = Math.abs(randgen.nextInt() % 9);
        if (puzzle[xcor][ycor] == '_') {
          puzzle[xcor][ycor] = (char)(nums[xcor][ycor] + 48); //finds random positions in the board to fill in the numbers from the answer key
          count--;
        }
      }

    savedBoard = new char[9][9];
    original = new char[9][9];
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        savedBoard[x][y] = puzzle[x][y]; //current saved board
        original[x][y] = puzzle[x][y]; //copies over to original array just in case user wants to reset the board
      }
    }
  }

  public Sudoku(String level, int choice){
    Random randSeed = new Random ();
    seed = Math.abs((randSeed.nextInt() % 10000));
    randgen = new Random(seed);
    nums = new int[9][9];
    try{
    File file = new File("Puzzles.txt");
    Scanner in = new Scanner(file);
    for (int k = 0; k < choice * 10 + 1; k++) { //instead of randomly choosing a puzzle, user can input the specific board to use
      in.nextLine();
    }
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        nums[x][y] = in.nextInt();
    }
  }
  } catch (FileNotFoundException e) {
  System.out.println("File not found");
  System.exit(1);
}
    difficulty = level;
    answer = new char[9][9];
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        answer[x][y] = (char)(nums[x][y] + 48);
      }
    }
    puzzle = new char[9][9];
    int count = 0;
    if(difficulty == "easy"){
      count = 30;
    }
    if(difficulty == "medium"){
      count = 25;
    }
    if(difficulty == "hard"){
      count = 20;
    }
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        puzzle[x][y] = (char)95;
      }
}
    while (count > 0) {
      int xcor;
      int ycor;
        xcor = Math.abs(randgen.nextInt() % 9);
        ycor = Math.abs(randgen.nextInt() % 9);
        if (puzzle[xcor][ycor] == '_') {
          puzzle[xcor][ycor] = (char)(nums[xcor][ycor] + 48);
          count--;
        }
      }
    savedBoard = new char[9][9];
    original = new char[9][9];
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        savedBoard[x][y] = puzzle[x][y];
        original[x][y] = puzzle[x][y];
      }
    }
  }

  public Sudoku(String level, int choice, int seed1){
    randgen = new Random(seed1);
    seed = seed1; //instead of using a randomly generated seed, user can input a seed
    nums = new int[9][9];
    puzzleChoice = choice;
    try{
    File file = new File("Puzzles.txt");
    Scanner in = new Scanner(file);
    for (int k = 0; k < choice * 10 + 1; k++) {
      in.nextLine();
    }
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        nums[x][y] = in.nextInt();
    }
  }
  } catch (FileNotFoundException e) {
  System.out.println("File not found");
  System.exit(1);
}
    difficulty = level;
    answer = new char[9][9];
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        answer[x][y] = (char)(nums[x][y] + 48);
      }
    }
    puzzle = new char[9][9];
    int count = 0;
    if(difficulty == "easy"){
      count = 30;
    }
    if(difficulty == "medium"){
      count = 25;
    }
    if(difficulty == "hard"){
      count = 20;
    }
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        puzzle[x][y] = (char)95;
      }
    }
    while (count > 0) {
      int xcor;
      int ycor;
        xcor = Math.abs(randgen.nextInt() % 9);
        ycor = Math.abs(randgen.nextInt() % 9);
        if (puzzle[xcor][ycor] == '_') {
          puzzle[xcor][ycor] = (char)(nums[xcor][ycor] + 48);
          count--;
        }
      }
    savedBoard = new char[9][9];
    original = new char[9][9];
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        savedBoard[x][y] = puzzle[x][y];
        original[x][y] = puzzle[x][y];
      }
    }
  }

  public int getPuzzleChoice() {
    return puzzleChoice; //return the puzzle choice
  }

  public String toString(){ //prints the board currently working on
    String newstr = "\nPuzzle: \n";
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
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
    return newstr += "Seed: " + seed + "\nPuzzle: " + puzzleChoice + "\nDifficulty: " + difficulty;
  }

  public String myBoard(){ //displays the last saved board
    String newstr = "\nLast saved board: \n";
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
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

  public String originalBoard(){ //displays the board the user originally had
    String newstr = "\nOriginal board: \n";
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
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
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
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

  public int getSeed(){ //returns the seed
    return seed;
  }

  public char getOriginal(int x, int y){ //if user wants to restart their progress, this returns the original board
    return original[y][x];
  }

  public char[][] getOriginalPuzzle(){//if user wants to restart their progress, this returns the original board
    return original;
  }

  public void reset() { //replacing the numbers entered into the puzzle with values from original board
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
        puzzle[x][y] = original[x][y];
      }
    }
  }

  public char getPuzzle(int x, int y){ //return the puzzle
    return puzzle[y][x];
  }

  public char getAnswer(int x, int y){ //return the answer key
    return answer[y][x];
  }

  public String getDifficulty(){//return the difficulty level
    return difficulty;
  }

  public void setPuzzle(int y, int x, char num) { //changing the values in the sudoku board at a specific position
    puzzle[x][y] = num;
  }

  public void save() {
    for (int x = 0; x < 9; x ++ ) {
      for (int y = 0; y < 9; y ++) {
          savedBoard[x][y] = puzzle[x][y]; //copies over values from the puzzle to the savedBoard array
        }
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

  public boolean check() { //allows the user to check if their sudoku board is the same with the answer key by comparing every value
    boolean a = true;
    for (int x = 0; x < 9; x++) {
      for (int y = 0; y < 9; y ++) {
        if (puzzle[x][y] != answer[x][y]) {
          if (difficulty.equals("easy")) {
            puzzle[x][y] = '_';
            a = false;
          } else {
            a = false;
          }
        }
      }
    }
    return a;
  }
}
