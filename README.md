# TicTacToe

A summer project by me. Expose yourself to bad coding at your own risk! Or, alternatively, just get it so that you can play 8 by 8 tic tac toe where you need to get 15 in a row to win. Easy peasy right?

I'll be trying to get this thing into a GUI. It's still in the works. Sorry.

Note for self: Considering refactoring a bit of the code as follows:
  -restructure Squareboard so that the makeMove is no longer a part of that class. Put makemove in GamePanel and adapt accordingly.

  -Create a new button class for each tic tac toe Square?
    -Alternatively, refactor the entire square class so that it extends JButton. This should be fine because once you move to GUI you are no longer going to be playing it on cmd.
    -In that case, restructure the entire Square and Squareboard classes to be integrated with GUI
      - Squares should be JButtons
      - Add the buttons to a 2D array as I've already done in order to check win.
      - At the same time add the JButtons to GUI. But they are also stored in the 2D array.