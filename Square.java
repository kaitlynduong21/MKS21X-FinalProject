public class Square  {

  private int num;

  private int xcor;

  private int ycor;

  private boolean showNumber;

  public Square(int number, int x, int y) {
     num = number;
     xcor = x;
     ycor = y;

  }

  public int isFilledIn() {
    if (showNumber == true) {
      return num;
    } else {
      return -1;
    }
  }
}
