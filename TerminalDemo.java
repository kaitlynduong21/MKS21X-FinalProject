

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


public class TerminalDemo{

	public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}
	public static void main(String[] args) {


		int x = 1;
		int y = 7;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

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
		Sudoku newBoard = new Sudoku(easy);
		terminal.applySGR(Terminal.SGR.ENTER_BOLD);
		putString(1, 5, terminal, newBoard.toString());

		while(running){



			terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			// /terminal.applySGR(Terminal.SGR.ENTER_BLINK);
			//terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			//terminal.putCharacter('\u00a4');
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);

			double k = 0.5 * x - 0.5;
			int xcor = (int)k;
			int ycor = y - 7;

			String str = "";
			if (y == 10 || y == 14 || y >= 19 || y < 7 || x == 7 || x == 15 || x >= 23 || x < 0) {
				str += "This is not a position on the board. Move your cursor.";
				putString(0 , 20, terminal, str);
			} else {
				str += "Current position is ";
				str += xcor;
				str += ", ";
				str += ycor;
				str += ".                             ";
				putString(0 , 20, terminal, str);
			}

			Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}

				if (key.getKind() == Key.Kind.ArrowLeft) {
					terminal.moveCursor(x,y);
					x-= 2;
				}

				if (key.getKind() == Key.Kind.ArrowRight) {
					terminal.moveCursor(x,y);
					x+= 2;
				}

				if (key.getKind() == Key.Kind.ArrowUp) {
					terminal.moveCursor(x,y);
					y--;
				}

				if (key.getKind() == Key.Kind.ArrowDown) {
					terminal.moveCursor(x,y);
					y++;
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') {
					terminal.moveCursor(x,y);
					y++;
					x+= 2;
				}

				if (key.getCharacter() == '1' ||
						key.getCharacter() == '2' ||
						key.getCharacter() == '3' ||
						key.getCharacter() == '4' ||
						key.getCharacter() == '5' ||
						key.getCharacter() == '6' ||
						key.getCharacter() == '7' ||
						key.getCharacter() == '8' ||
						key.getCharacter() == '9' ) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(key.getCharacter());
					//terminal.applySGR(Terminal.SGR.ENTER_BLINK);
					newBoard.setPuzzle(xcor, ycor, key.getCharacter());
				}

				if (key.getKind() == Key.Kind.Backspace) {
					terminal.moveCursor(x, y);
					terminal.putCharacter(' ');
					newBoard.setPuzzle(xcor, ycor, '_');
				}

				if (key.getCharacter() == 'c') {
					putString(0, 21, terminal, "Are you sure you want to clear the board? Select option + c if yes.           ");
				}

				if (key.getCharacter() == 'ç') {
					terminal.clearScreen();
					Sudoku cleared = new Sudoku (easy, newBoard.getSeed());
					newBoard = cleared;
					terminal.applySGR(Terminal.SGR.ENTER_BOLD);
					putString(1, 5, terminal, cleared.toString());
					terminal.applySGR(Terminal.SGR.EXIT_BOLD);
					putString(0, 21, terminal, "Board refreshed                                                                 ");
				}

				/*if (String(0,20).equals("Are you sure you want to clear the board?")) {
					if (key.getCharacter() == 'y') {
					terminal.clearScreen();
					Sudoku cleared = new Sudoku (easy, newBoard.getSeed());
					//newBoard = cleared
					putString(1, 5, terminal, cleared.toString());
					putString(0, 20, terminal, "Board refreshed");
				} else {
					if (key.getCharacter() == 'n') {
						putString(0, 20, terminal, "Board not refreshed");
					}
				}*/

				if (key.getCharacter() == 's') {
					newBoard.save();
					putString(0, 21, terminal, "Saved Successful!                                                               ");
				}

				if (key.getCharacter() == 'r') {
					putString(0, 21, terminal, "Do you want to retrieve your last saved board? Select option + r if yes.");
				}

				if (key.getCharacter() == '®') {
					terminal.clearScreen();
					putString(1, 5, terminal, newBoard.myBoard());
				}

				if (key.getCharacter() == 'h') {
					newBoard.hint();
				}




				putString(1,4,terminal,"["+key.getCharacter() +"]");
				putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
			}

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1,2,terminal,"Milliseconds since start of program: "+millis);
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond);

			}


		}
	}
}
