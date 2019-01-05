import java.util.Random;
public class Sudoku{
  private char[][] puzzle;

  private char[][] answer;

  private char[][] myBoard;

  private String difficulty;

  private int seed;

  private Random randgen;

  public Sudoku(int[][] nums){
    //answer = nums;
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
    myBoard = puzzle;
  }

  public String getPuzzle(){
    String newstr = "\n Puzzle: \n";
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

  public String getKey(){
    String newstr = "\n Key: \n";
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

}
