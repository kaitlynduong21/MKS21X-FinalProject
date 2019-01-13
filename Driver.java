public class Driver{
  public static void main(String[]args){
    int[][] easy = new int[][]{
      {2, 9, 6, 3, 1, 8, 5, 7, 4},
      {5, 8, 4, 9, 7, 2, 6, 1 ,3},
      {7, 1, 3, 6, 4, 5, 2, 8, 9},
      {6, 2, 5, 8, 9, 7, 3, 4, 1},
      {9, 3, 1, 4, 2, 6, 8, 5, 7},
      {4, 7, 8, 5, 3, 1, 9, 2, 6},
      {1, 6, 7, 2, 5, 3, 4, 9, 8},
      {8, 5, 9, 7, 6, 4, 1, 3, 2},
      {3, 4, 2, 1, 8, 9, 7, 6, 5},
    };
    Sudoku newBoard = new Sudoku(easy, Integer.parseInt(args[0]));
    System.out.println(newBoard);
    System.out.println(newBoard.myBoard());
    System.out.println(newBoard.getPuzzle(0,1));
    System.out.println(newBoard.originalBoard());
    newBoard.hint();
    //System.out.println(newBoard.hint());
    System.out.println(newBoard);
    //System.out.println(newBoard.getKey());
    /*newBoard.setPuzzle(1, 6, '9');
    newBoard.setPuzzle(3, 6, '7');
    System.out.println(newBoard);
    newBoard.save();
    System.out.println(newBoard.myBoard());
    System.out.println(newBoard.getKey());
    newBoard.save();
    newBoard.hint();
    System.out.println(newBoard);*/
  }
}
