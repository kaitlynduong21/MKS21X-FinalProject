import java.util.*;

public class Sudoku{
  private Square[][] puzzle;

  private Square[][] answer;

  private Square[][] myBoard;

  private String difficulty;

  private int seed;

  private Random rand;

  public Sudoku(Square[][] numbers){
    puzzle = new Square [numbers.length][numbers[0].length];
  }

  public String toString(){
    String newstr = "";
    for(int i = 1; i <= puzzle.length; i ++){
      for(int a = 1; a <= puzzle[0].length + 3; a ++){
        if(a % 4 == 0){
          newstr += "|" + puzzle[i][a].isFilledIn() + " ";
        }
        else{
        newstr+= "|" + puzzle[i][a].isFilledIn();
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
