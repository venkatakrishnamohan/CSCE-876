import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/*Implemetes the board positions as a class*/
class Board{
	int[][] b = new int[3][3];
	int pathcost;
	public Board() {
		
	}
	public Board(int[][] a) {
		b=a;
	}
	/*function which gets the blank positioin of a board*/
	public int getBlankPosition() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(b[i][j] == 0)
					return 3*i+j;
			}
		}
		return -1;
	}
	/*function which gets the position on the board for a particular number*/
	public int getPosition(int num) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(b[i][j] == num)
					return 3*i+j;
			}
		}
		return -1;
	}
}
/*Main class that implemets the search strategy*/
public class Eightpuzzle {
	static Board goalstate;
	public static void main(String[] args) {
	
	/*generate a goal state*/
	 goalstate = new Board(new int[][] {{1,2,3},{4,5,6},{7,8,0}});
	 Integer[] arr = new Integer[9];
	 for(int i=0;i<arr.length;i++) {
		 arr[i]=i;
	 }
	 /*creating random input states*/
	 for(int k =0;k<100;k++)
	 {
	 Collections.shuffle(Arrays.asList(arr));
	 int[][] input1 = new int[3][3];
	 for(int i=0;i<3;i++) {
		 for(int j=0;j<3;j++) {
			 input1[i][j] = arr[3*i+j];
		 }
	 }
	 }
	 System.out.println("This is a worst case scenario so it might take 2-3 minutes for displaying the output");
	 System.out.println("Current input state is: {{8,7,4},{3,2,0},{6,5,1}}");
	 System.out.println("The goal state is: {1 2 3, 4 5 6, 7 8 0}");
	 Board currentstate = new Board(new int[][] {{8,7,4},{3,2,0},{6,5,1}});
	 currentstate.pathcost =0;
	 Board newstate;
	 ArrayList<Board> fringe = new ArrayList<Board>();
	 /*check if the current input state is solvable or not*/
	 long starttime = System.currentTimeMillis();
	 if(chechSolvable(currentstate)) {
		 /*if the current state is solvable iterate until the goal state is reached*/
	 while(bfsHeuristic(currentstate) != 0) {
		 for(Board b:generateSuccessors(currentstate)) {
			 fringe.add(b);
		 }
	 newstate = getbestnodebfs(fringe);
	 currentstate = copy(newstate);
	 }
	 }
	 else {
		 System.out.println("Not solvable");
	 }
	 long endtime = System.currentTimeMillis();
	 System.out.println("The path cost using bfs heuristic is:");
	 System.out.println(currentstate.pathcost);
	 System.out.println("Execution time in milli seconds is:"+ (endtime - starttime));
	 Board currentstate1 = new Board(new int[][] {{8,7,4},{3,2,0},{6,5,1}});
	 currentstate1.pathcost =0;
	 Board newstate1;
	 ArrayList<Board> fringe1 = new ArrayList<Board>();
	 /*check if the current input state is solvable or not*/
	 long starttime1 = System.currentTimeMillis();
	 if(chechSolvable(currentstate1)) {
		 /*if the current state is solvable iterate until the goal state is reached*/
	 while(bfsHeuristic(currentstate1) != 0) {
		 for(Board b:generateSuccessors(currentstate1)) {
			 fringe1.add(b);
		 }
	 newstate1 = getbestnode(fringe1);
	 currentstate1 = copy(newstate1);
	 }
	 }
	 else {
		 System.out.println("Not solvable");
	 }
	 long endtime1 = System.currentTimeMillis();
	 System.out.println("The path cost using manhattan heuristic is:");
	 System.out.println(currentstate1.pathcost);
	 System.out.println("The execution time in milli seconds is:"+ (endtime1 - starttime1));
	}
	/*creates a copy of a board*/
	public static Board copy(Board b) {
		Board bre = new Board();
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++) {
				bre.b[i][j] = b.b[i][j];
			}
		}
		bre.pathcost = b.pathcost;
		return bre;
	}
	/*function that calculates the bfs heuristic of a board*/
	public static int bfsHeuristic(Board board) {
        int result = 0;
        for(int x = 0; x < 3; x ++) 		// scan for misplace of tiles.
            for (int y = 0; y < 3; y++) {
                if(board.b[x][y] != goalstate.b[x][y])
                result ++;					// whenever it found a misplace, increase result by 1.
            }
        return result;
    }
	/*function that calculates the manhattan heuristic of a board*/
	public static int ManhattanHeuristic(Board board) { 
        int result = 0;
        for (int sx = 0; sx < 3; sx++) {
            for (int sy = 0; sy < 3; sy ++) {
                int tileValue = board.getPosition(goalstate.b[sx][sy]);
                if(tileValue == (3*sx + sy)) {
                    continue;
                }
                int sy_offby = tileValue % 3;
                int sx_offby = tileValue / 3;
                result += Math.abs(sy_offby - sy) + Math.abs(sx_offby - sx);
            }
        }
        return result;
    }
	/*function that checks whether a right move is leagal or not*/
	public static boolean moveright(Board b) {
		int index = b.getBlankPosition();
		int y = index%3;
		int x = index/3;
		if(y+1<=2) {
			int temp = b.b[x][y+1];
			b.b[x][y+1]=b.b[x][y];
			b.b[x][y]=temp;
			return true;
		}
		else
			return false;
	}
	/*function that checks whether a left move is leagal or not*/
	public static boolean moveleft(Board b) {
		int index = b.getBlankPosition();
		int y = index%3;
		int x = index/3;
		if(y-1>=0) {
			int temp = b.b[x][y-1];
			b.b[x][y-1]=b.b[x][y];
			b.b[x][y]=temp;
			return true;
		}
		else
			return false;
	}
	/*function that checks whether a upward move is leagal or not*/
	public static boolean moveup(Board b) {
		int index = b.getBlankPosition();
		int y = index%3;
		int x = index/3;
		if(x-1>=0) {
			int temp = b.b[x-1][y];
			b.b[x-1][y]=b.b[x][y];
			b.b[x][y]=temp;
			return true;
		}
		else
			return false;
	}
	/*function that checks whether a downward move is leagal or not*/
	public static boolean movedown(Board b) {
		int index = b.getBlankPosition();
		int y = index%3;
		int x = index/3;
		if(x+1<=2) {
			int temp = b.b[x+1][y];
			b.b[x+1][y]=b.b[x][y];
			b.b[x][y]=temp;
			return true;
		}
		else
			return false;
	}
	public static boolean equalstates(Board board1,Board board2) {
		int result = 0;
		for(int x = 0; x < 3; x ++) 	{	
            for (int y = 0; y < 3; y++) {
                if(board1.b[x][y] == board2.b[x][y])
                result ++;					
            }
	}
	if(result == 9)
		return true;
	else
		return false;

	}
	/*function that checks whether the input state is solvable or not*/
	public static boolean chechSolvable(Board b) {
		int inversions = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<b.b.length;i++) {
			for(int j=0;j<b.b[i].length;j++) {
				list.add(b.b[i][j]);
			}
		}
		int[] vector = new int[list.size()];
		for(int i=0;i<vector.length;i++) {
			vector[i] = list.get(i);
		}
		for(int i=0;i<vector.length;i++) {
			for(int j=i+1;j<vector.length;j++) {
				if(vector[j]<vector[i] && vector[j]!=0)
					inversions++;
			}
		}
		if(inversions%2 == 1){
			return false;
		}
		else {
			return true;
		}
	}
	/*function that generates the legal successors of a board*/
	public static ArrayList<Board> generateSuccessors(Board board) {
		ArrayList<Board> nextnodes = new ArrayList<>();
		Board br = copy(board);
		Board bl = copy(board);
		Board bu = copy(board);
		Board bd = copy(board);
		if(moveright(br)) {
			br.pathcost+=1;
			nextnodes.add(br);
		}
		if(moveleft(bl)) {
			bl.pathcost+=1;
			nextnodes.add(bl);
		}
		if(moveup(bu)) {
			bu.pathcost+=1;
			nextnodes.add(bu);
		}
		if(movedown(bd)) {
			bd.pathcost+=1;
			nextnodes.add(bd);
		}
		return nextnodes;
	}
	/*function that evaluates the nodes in the fringe and returns the best node to be considered using manhattan heuristic*/
	public static Board getbestnode(ArrayList<Board> fringe) {
		int minpath = fringe.get(0).pathcost + ManhattanHeuristic(fringe.get(0));
		Board bcopy = copy(fringe.get(0));
		for(Board b:fringe) {
			if(b.pathcost + ManhattanHeuristic(b) <= minpath) {
				minpath = b.pathcost + ManhattanHeuristic(b);
				bcopy = copy(b);
			}
		}
		Iterator<Board> iter = fringe.iterator();
		while(iter.hasNext()) {
			Board n = iter.next();
			if(equalstates(n,bcopy))
				iter.remove();
		}
		return bcopy;
	}
	/*function that evaluates the nodes in the fringe and returns the best node to be considered using bfs heuristic*/
	public static Board getbestnodebfs(ArrayList<Board> fringe) {
		int minpath = fringe.get(0).pathcost + bfsHeuristic(fringe.get(0));
		Board bcopy = copy(fringe.get(0));
		for(Board b:fringe) {
			if(b.pathcost + bfsHeuristic(b) <= minpath) {
				minpath = b.pathcost + bfsHeuristic(b);
				bcopy = copy(b);
			}
		}
		Iterator<Board> iter = fringe.iterator();
		while(iter.hasNext()) {
			Board n = iter.next();
			if(equalstates(n,bcopy))
				iter.remove();
		}
		return bcopy;
	}
}