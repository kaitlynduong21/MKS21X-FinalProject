import java.util.*;

public class Square  {

  private int num;

  private int xcor;

  private int ycor;

  private boolean showNumber;

  public Square(int number, int x, int y) {
     num = number;
     xcor = x;
     ycor = y;
     Random randgen = new Random();
     int rand = randgen.nextInt() % 2;
     if (rand == 0) {
       showNumber = false;
     } else {
       showNumber = true;
     }
  }

  public String isFilledIn() {
    if (showNumber == true) {
      return "" + num;
    } else {
      return "";
    }
  }
}
