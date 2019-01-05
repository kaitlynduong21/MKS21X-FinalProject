import java.util.Random;
public class Sudoku{
  private int[][] puzzle;

  private int[][] answer;

  private int[][] myBoard;

  private String difficulty;

  private int seed;

  //private Random randgen;

  public Sudoku(int[][] nums){
    answer = nums;
    puzzle = new int[nums.length][nums[0].length];
    Random randgen = new Random();
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y < nums[0].length; y ++) {
        //int rand = randgen.nextInt() % 4;
        //if (rand == 1) {
          puzzle[x][y] = nums[x][y];
        /*} else {
          puzzle[x][y] = -1;
        }*/
      }
    }
    puzzle = myBoard;
  }

  public String getKey(){
    String newstr = "";
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

  public String getPuzzle(){
    String newstr = "";
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
    return newstr;
  }

}
