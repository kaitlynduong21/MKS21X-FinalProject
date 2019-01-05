import java.util.Random;
public class Sudoku{
  private String[][] puzzle;

  private String[][] answer;

  private String[][] myBoard;

  private String difficulty;

  private int seed;

  private Random rand;

  public Sudoku(String[][] nums){
    answer = nums;
    puzzle = new String[nums.length][nums[0].length];
    Random randgen = new Random();
    for (int x = 0; x < nums.length; x ++ ) {
      for (int y = 0; y <nums[0].length; y ++) {
        int rand = randgen.nextInt() % 4;
        if (rand == 1) {
          puzzle[x][y] = answer[x][y];
        } else {
          puzzle[x][y] = " ";
        }
      }
    }
    puzzle = myBoard;
  }
  public String toString(){
    String newstr = "";
    for(int i = 1; i <= myBoard.length; i ++){
      for(int a = 1; a <= myBoard[0].length + 3; a ++){
        if(a % 4 == 0){
          newstr += "|" + myBoard[i][a].isFilledIn() + " ";
        }
        else{
        newstr+= "|" + myBoard[i][a].isFilledIn();
        }
      }
      if(i % 3 == 0){
        newstr += "\n";
      }
      newstr+= "\n";
    }
    return newstr;
  }

}
