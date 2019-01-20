# MKS21X-FinalProject

Instructions on how to run the Sudoku code

First, change terminal size to full screen. Then run and compile the SudokuGame.java file.

Development Log

1/03: We have created the Square class, but are struggling with merging branches. We also started the Sudoku.java file.

1/04: Sabrina created the Sudoku class. She has completed the basis of our toString method, but we will try to improve it to resemble a sudoku board more. Kaitlyn worked on the Square class and has created a new field to make it easier to know whether or not a square shows its number.

1/05: We decided that it is better to use char[][] rather than use the Square class, so we have scraped the idea of Squares. Kaitlyn completed toStrings, getKey, and myBoard methods. She has also created a second constructor that will take in a seed, so that you can recreate the board you want. Sabrina included lanterna methods into the Sudoku.java and tried to incorporate it in the code.

1/06: Kaitlyn used the Sudoku board as the background in the TerminalDemo.java and was able to move the cursor to enter in numbers in the Sudoku grid. Sabrina added a save method to add the saved board into a text file.

1/07: We are working on the save method in the main function. Currently if you select the character 's', the original puzzle will be saved in a text file, however we are trying to figure out how we can save the changes made to the puzzle. We have been able to clear the board by selecting the character 'c', but we want to add a step after you select c asking if you are sure you want to restart because we don't want someone accidentally selecting c having all their progress deleted.

1/08: Kaitlyn worked on adding a clear, save, and retrieve saved board feature in the TerminalDemo file. The save method does not work completely yet because it is not saving to the correct locations so when you retrieve the saved board, the board is not what was saved. Sabrina is starting to work on the hint method.

1/09: We both realized the save method isn't working properly and we had a collaborative effort on trying to fix how the code reads the Sudoku board and prints it out in the terminal.

1/10: Kaitlyn fixed the problem with saving and retrieving the board. After testing the driver multiple times, we realized the problem was not in the save method, but actually in the TerminalDemo file. The xcor and ycor of the char did not take into account the spaces between the board, so we have fixed that.

1/11: We are working on incorporating the hint feature. We are struggling to add it without messing up the formatting of the board.

1/12: Kaitlyn added the check function and changed the feature of adding numbers so you cannot change numbers part of the original puzzle. Also, we added a "menu" of keys to select to access different features such as hint, check, and clear.

1/13: Kaitlyn fixed the hint feature in the TerminalDemo file, so it will work in the terminal. Sabrina tested the check and hint features altered the hint method in the Sudoku class. Sabrina also added a few more puzzles that will incorporate for different difficulty levels in the future.

1/14: We changed the key symbols to work on the school computers (we programmed on a Mac). We also added retrieved saved board on the menu.

1/15: We fixed backspace feature so it can't change the original numbers in the puzzle. Sabrina began working on incorporating different difficulty levels.

1/16: Sabrina added new puzzles into the "puzzles.txt" file. Kaitlyn added a refresh feature which will allow the user to generate a different seeded board. She also changed the Sudoku constructor so that different difficulties will show different amount of squares filled in– easy will show 30, medium will show 25, and hard will show 20.

1/17: Kaitlyn changed the constructors to take in either a difficulty, a difficulty and a puzzle choice, or a difficulty, puzzle choice, and a seed. The puzzles.txt file will contain various puzzles and the first constructor will randomly select one of those puzzles and using the scanner, extract the numbers of the file into a 2d int array. We added two more private fields, an 2d int array nums and an int which is the puzzle choice (corresponds with the puzzle number in the text file). We also altered the features in the main function to take these changes into consideration.

1/18: Sabrina added more puzzles and changed the constructor to account for the new number of puzzles. Kaitlyn changed the constructor to make them more concise.

1/19: Kaitlyn added a home screen that displays the rules and information about the difficulties. She also altered the check function to adjust it for different difficulties.
