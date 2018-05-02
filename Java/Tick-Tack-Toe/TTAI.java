import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Iterator;
class TTAI {
  class AIMove {
    String move;
    int score;
  }
  Board board;
  Board.Player[][] theBoard;
  Board.Player ai, player;
  String nextMove = "";
  List<String> movesPossible;
  NavigableMap<String, Integer> tree = new TreeMap<String, Integer>();

 public TTAI(Board board) {
   this.board = board;
   this.theBoard = board.getBoard();
   this.ai = board.getPlayerAI();
   this.player = board.getHuman();
   this.movesPossible = board.getAvailableMoves();
   fillTree();
 }
 private void fillTree() {
   tree.clear();
   this.movesPossible = board.getAvailableMoves();
   for(int i = 0; i < movesPossible.size(); i ++)
     tree.put(movesPossible.get(i), null);
 }
 public String toString() {
   return nextMove;
 }

 public void getNextMove() {
   fillTree();
   this.theBoard = board.getBoard();
   int max = Integer.MIN_VALUE;
   int score = miniMax(theBoard, 0);
   System.out.println(tree);
   for(Entry<String, Integer> entry : tree.entrySet())
     if(entry.getValue() != null && entry.getValue() > max) {
       max = entry.getValue();
       nextMove = entry.getKey();
     }
 }

  private int score(int depth, Board.Player[][] b) {
    if (Board.checkWinner(this.ai, b))
      return 10 - depth;
    if (Board.checkWinner(this.player, b))
      return depth - 10;
    return 0;
  }
  private String print(Board.Player[][] n) {
    String str = "";
    for(Board.Player[] p : n) {
      for(Board.Player s : p) {
        str += (s);
      }
      str += ("\n");
    }
  }
  private int miniMax(Board.Player[][] b, int depth) {
    if (board.checkWinner(ai, b))
      return score(depth, b);
    if (board.checkWinner(player, b))
      return score(depth, b);
    if (!board.checkWinner(player, b) && !board.checkWinner(player, b))
      return 0;
    Iterator itter = movesPossible.listIterator();
    depth++;
    while (itter.hasNext()) {
      String s = itter.next().toString();
      AIMove jim = new AIMove();
      jim.move = s;
      b[Board.play(s)[0]][Board.play(s)[1]] = board.getMoveList()[depth + board.movesMade];
      System.out.println(b);
      movesPossible.remove(s);
      tree.replace(s, miniMax(b, depth));
    }
    return 0;
  }

}
