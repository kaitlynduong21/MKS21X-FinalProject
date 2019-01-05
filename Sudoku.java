import java.util.Random;
public class Sudoku{
  private Square[][] puzzle;

  private Square[][] answer;

  private Square[][] myBoard;

  private String difficulty;

  private int seed;

  private Random rand;

  public Sudoku(Square[][] numbers){
    myBoard = new Square [numbers.length][numbers[0].length];
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
