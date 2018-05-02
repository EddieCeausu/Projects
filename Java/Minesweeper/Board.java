
class Board {

  public Enum State = { Hidden, Empty, Bomb, Flag, One, Two, Three, Four, Five, Six, Seven, Eight };
  int length, height, bombs;
  State[][] board = new State[length][height];
  State[][] displayBoard = new State[length][height];

  public Board(int length, int height, int bombs) {
    this.length = length;
    this.height = height;
    this.bombs = bombs;
    // loading user viewed board
    for(int i = 0; i < displayBoard.length; i ++)
      for(int j = 0; j < displayBoard[i].length; j ++)
        displayBoard[i][j] = State.Hidden;
  }
  void load() {

  }
  public String toString() {
    String str = "";
    for(State s[] : displayBoard) {
      for(State ss : s) {
        //
      }
    }
  }

}
