public class Driver{
  public static void main(String[]args){
    Square [][] easyPuzzle = new Square[9][9];
    Sudoku newBoard = new Sudoku(easyPuzzle);
    System.out.println(newBoard);
  }
}
