

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SudokuGame{

	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}
	public static void main(String[] args) {
		String difficulty = "";
		if(args.length < 1){
			System.out.println("Enter in a difficulty level: easy, medium, hard.\n If you want add a choice of puzzle (number from 0- 5).\n You can add a seed as well (number from 0-10000).");
			System.exit(1);
		}

		int x = 1;
		int y = 7;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

		Sudoku newBoard = new Sudoku("easy");
		if(args[0].equals("easy")) {
			 newBoard = new Sudoku("easy");
		} else {
			if(args[0].equals("medium")){
				 newBoard = new Sudoku("medium");
			} else {
					 newBoard = new Sudoku("hard");
			}
		}

		if (args.length == 2) {
			if(args[0].equals("easy")) {
				 newBoard = new Sudoku("easy", Integer.parseInt(args[1]));
			} else {
				if(args[0].equals("medium")){
					 newBoard = new Sudoku("medium", Integer.parseInt(args[1]));
				} else {
						 newBoard = new Sudoku("hard", Integer.parseInt(args[1]));
		}
	}
}

		if (args.length == 3) {
			if(args[0].equals("easy")) {
				 newBoard = new Sudoku("easy", Integer.parseInt(args[1]), Integer.parseInt(args[2]));
			} else {
				if(args[0].equals("medium")){
					 newBoard = new Sudoku("medium", Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				} else {
						 newBoard = new Sudoku("hard", Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		}
	}
}

		terminal.applySGR(Terminal.SGR.ENTER_BOLD); //have the board printed to be bolded
		putString(1, 5, terminal, newBoard.toString()); //printing the board into the terminal

		while(running){

			terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);

			double k = 0.5 * x - 0.5; //setting x and y coordinates
			if (k > 3) {
				k--;
			}
			if (k >= 6) {
				k--;
			}
			int xcor = (int)k;
			int ycor = y - 7;
			if (ycor > 3) {
				ycor--;
			}
			if (ycor >= 6) {
				ycor--;
			}

			if(xcor >=0 && xcor < 9 && ycor >= 0 && ycor < 9 && newBoard.getOriginal(xcor, ycor) == '_') {
				putString(25, 7, terminal, "                                                            ");
			} else {
				if (y == 10 || y == 14 || y >= 18 || y < 7 || x == 7 || x == 15 || x >= 23 || x < 0) {
					putString(25, 7, terminal, "                                                          ");
				} else {
					putString(25, 7, terminal, "This is part of the original puzzle. You cannot change it.");
				}
			}



			String str = "";
				str += "Current position is "; //tells the user where the cursor is located
				str += xcor;
				str += ", ";
				str += ycor;
				str += ".";
				putString(25 , 8, terminal, str);

			Key key = terminal.readInput();


			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) { //exiting the board

					terminal.exitPrivateMode();
					running = false;
				}

				if (key.getKind() == Key.Kind.ArrowLeft) { //cursor moving to the left
					//erminal.moveCursor(x,y);
					if (xcor != 0) {
					//terminal.applyForegroundColor(Terminal.Color.BLUE);
					terminal.moveCursor(x,y);
					x-= 2;
					if (x == 7) {
						x-= 2;
					}
					if (x == 15) {
						x-= 2;
					}
					putString(25, 9, terminal, "                                             ");
				} else {
					putString(25, 9, terminal, "You cannot move past this point on the board.");
				}
				}

				if (key.getKind() == Key.Kind.ArrowRight) { //cursor moving to the right
					if (xcor != 8) {
					//terminal.applyForegroundColor(Terminal.Color.BLUE);
					terminal.moveCursor(x,y);
					x+= 2;
					if (x == 7) {
						x+= 2;
					}
					if (x == 15) {
						x+= 2;
					}
					putString(25, 9, terminal, "                                             ");
				} else {
					putString(25, 9, terminal, "You cannot move past this point on the board.");
				}
				}

				if (key.getKind() == Key.Kind.ArrowUp) { //cursor moving up
					if (ycor != 0) {
					terminal.moveCursor(x,y);
					//terminal.applyForegroundColor(Terminal.Color.BLUE);
					y--;
					if (y == 10) {
						y --;
					}
					if (y == 14) {
						y --;
					}
					putString(25, 9, terminal, "                                             ");
				} else {
					putString(25, 9, terminal, "You cannot move past this point on the board.");
				}
				}

				if (key.getKind() == Key.Kind.ArrowDown) { //cursor moving down
					if (ycor != 8) {
					//terminal.applyForegroundColor(Terminal.Color.BLUE);
					terminal.moveCursor(x,y);
					y++;

					if (y == 10) {
						y ++;
					}
					if (y == 14) {
						y ++;
					}
					putString(25, 9, terminal, "                                             ");
				} else {
					putString(25, 9, terminal, "You cannot move past this point on the board.");
				}
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') { //moving to the next position to the right and up one
					terminal.moveCursor(x,y);
					y++;
					x+= 2;
				}

				if (xcor >= 0 && ycor >= 0 && xcor < 9 && ycor < 9 && y != 10 && y != 14 && y < 18 && y >= 7 && x != 7 && x != 15 && x <= 21) {
					if(newBoard.getOriginal(xcor, ycor) == '_') {
						putString(25, 7, terminal, "                                                               ");
						if (key.getCharacter() == '1' || //reads the number the user inputs
						key.getCharacter() == '2' ||
						key.getCharacter() == '3' ||
						key.getCharacter() == '4' ||
						key.getCharacter() == '5' ||
						key.getCharacter() == '6' ||
						key.getCharacter() == '7' ||
						key.getCharacter() == '8' ||
						key.getCharacter() == '9' ) {

							terminal.moveCursor(x,y);
							terminal.putCharacter(key.getCharacter()); //add the number into the position of the cursor
							newBoard.setPuzzle(xcor, ycor, key.getCharacter()); //add the number added to the puzzle array
						}
					}
				}

				if(newBoard.getOriginal(xcor, ycor) == '_') {
				if (key.getKind() == Key.Kind.Backspace) {
					terminal.moveCursor(x, y);
					terminal.applySGR(Terminal.SGR.ENTER_BOLD);
					terminal.putCharacter('_'); //replace the last inputted number with an empty space
					terminal.applySGR(Terminal.SGR.EXIT_BOLD);
					if (y == 10 || y == 14 || y >= 18 || y < 7 || x == 7 || x == 15 || x >= 23) {
						terminal.putCharacter(' ');
					}
					newBoard.setPuzzle(xcor, ycor, '_'); //replace the char value with the '_' in the puzzle array
				}
			}

				if (key.getCharacter() == 'r') {
					putString(25, 10, terminal, "Are you sure you want to reset the board? Select shift + 2 if yes.     ");
				}

				if (key.getCharacter() == '@') {
					terminal.clearScreen();
					newBoard.reset();
					terminal.applySGR(Terminal.SGR.ENTER_BOLD);
					putString(1, 5, terminal, newBoard.toString());
					terminal.applySGR(Terminal.SGR.EXIT_BOLD);
					putString(25, 10, terminal, "Board refreshed                                                        ");
				}

				if (key.getCharacter() == 's') { //user can save the board
					newBoard.save();
					putString(25, 10, terminal, "Saved Successful!                                                      ");
				}

				if (key.getCharacter() == 'r') { //user can replace current board with the board last saved
					putString(25, 10, terminal, "Do you want to retrieve your last saved board? Select shift + 4 if yes.");
				}

				if (key.getCharacter() == '$') {
					//terminal.clearScreen();
					putString(1, 20, terminal, newBoard.myBoard());
				}

				if (key.getCharacter() == 'h') { //add a hint in the puzzle
					newBoard.hint();
					for (int xnum = 0; xnum < 9; xnum ++) {
						for (int ynum = 0; ynum < 9; ynum ++) {
							if (newBoard.getOriginal(xnum, ynum) != '_' && (newBoard.getPuzzle(xnum, ynum) != newBoard.getOriginal(xnum, ynum))) {
								int yy = ynum + 7;
								double kk = (xnum + 0.5) / 0.5; //setting x and y coordinates
								if (xnum >= 3) {
									kk+=2;
								}
								if (xnum >= 6) {
									kk+=2;
								}
								int xx = (int)kk;

								if (ynum >= 3) {
									yy++;
								}
								if (ynum >= 6) {
									yy++;
								}
								terminal.moveCursor(xx, yy);
								terminal.applySGR(Terminal.SGR.ENTER_BOLD);
								terminal.putCharacter(newBoard.getOriginal(xnum, ynum));
								newBoard.setPuzzle(xnum,ynum, newBoard.getOriginal(xnum,ynum));
								terminal.applySGR(Terminal.SGR.EXIT_BOLD);
								terminal.moveCursor(x,y);
							}
						}
					}
				}

				if (key.getCharacter() == 'c') {
					if (newBoard.check()){
						putString (1, 5, terminal, "CONGRATULATIONS! YOU ARE FINISHED!");
					} else {
						putString (1, 5, terminal, "Incorrect:( Try again.             ");
					}
				}

				if (key.getCharacter() == 'n') { //moving to the next position to the right and up one
					putString(25, 10, terminal, "Do you want to get a new board? If yes, select 'E', 'M', or 'H'");
				}

				if (key.getCharacter() == 'E') { //moving to the next position to the right and up one
					newBoard = new Sudoku ("easy", newBoard.getPuzzleChoice());
					terminal.applySGR(Terminal.SGR.ENTER_BOLD);
					putString(1, 5, terminal, newBoard.toString());
					terminal.applySGR(Terminal.SGR.EXIT_BOLD);
				}

				if (key.getCharacter() == 'M') { //moving to the next position to the right and up one
					newBoard = new Sudoku ("medium", newBoard.getPuzzleChoice());
					terminal.applySGR(Terminal.SGR.ENTER_BOLD);
					putString(1, 5, terminal, newBoard.toString());
					terminal.applySGR(Terminal.SGR.EXIT_BOLD);
				}

				if (key.getCharacter() == 'H') { //moving to the next position to the right and up one
					newBoard = new Sudoku ("hard", newBoard.getPuzzleChoice());
					terminal.applySGR(Terminal.SGR.ENTER_BOLD);
					putString(1, 5, terminal, newBoard.toString());
					terminal.applySGR(Terminal.SGR.EXIT_BOLD);
				}

				if (key.getCharacter() == 'q') {
					putString(25, 10, terminal, "Are you sure you want the answer? If yes, select 'Q'");
				}

				if (key.getCharacter() == 'Q') {
					putString(1, 20, terminal, newBoard.getKey());
				}




				putString(1,4,terminal,"["+key.getCharacter() +"]");
				putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
			}

			terminal.applyForegroundColor(Terminal.Color.DEFAULT);

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1,2,terminal,"Milliseconds since start of program: "+millis); //times the user how long it takes to execute the sudoku board
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond);

			}
			putString(25, 11, terminal, "Save: s ");
			putString(25, 12, terminal, "Reset: r");
			putString(25, 13, terminal, "Hint: h ");
			putString(25, 14, terminal, "Check: c");
			putString(25, 15, terminal, "Get Saved Board: r");
			putString(25, 16, terminal, "Get New Board: n");
			putString(25, 17, terminal, "Want answer?: q");
			putString(25, 18, terminal, "Give up?: esc");
		}
	}
}
