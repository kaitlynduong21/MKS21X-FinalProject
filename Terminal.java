

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


public class Terminal{

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
		putString(1, 5, terminal, newBoard.toString());

		while(running){


			terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.WHITE);
			terminal.applyForegroundColor(Terminal.Color.BLACK);
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			terminal.applySGR(Terminal.SGR.ENTER_BLINK);
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			//terminal.putCharacter('\u00a4');
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);
			terminal.applySGR(Terminal.SGR.RESET_ALL);


			terminal.moveCursor(size.getColumns()-5,5);
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.YELLOW);
			terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter('\u262d');
			terminal.putCharacter(' ');
			terminal.moveCursor(size.getColumns()-5,6);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			terminal.applyForegroundColor(Terminal.Color.DEFAULT);

			Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}

				if (key.getKind() == Key.Kind.ArrowLeft) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter(key.getKeyChar());
					x-= 2;
				}

				if (key.getKind() == Key.Kind.ArrowRight) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter(' ');
					x+= 2;
				}

				if (key.getKind() == Key.Kind.ArrowUp) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter(' ');
					y--;
				}

				if (key.getKind() == Key.Kind.ArrowDown) {
					terminal.moveCursor(x,y);
					//terminal.putCharacter(' ');
					y++;
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') {
					terminal.moveCursor(x,y);
					//terminal.putCharacter(' ');
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
					//y++;
					//x++;
				}

				if (key.getKind() == Key.Kind.Backspace) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
				}

				/*if (key.getCharacter() == 'c'){
					terminal.clearScreen();
					Sudoku clearedBoard =  new Sudoku (easy, newBoard.getSeed());
				}*/


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
