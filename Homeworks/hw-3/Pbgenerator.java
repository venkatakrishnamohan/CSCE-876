import java.util.Random;
/*Create a class to store point values*/
class Point{
float x;
float y;
public Point(float a,float b) {
	// TODO Auto-generated constructor stub
	x=a;
	y=b;
}
}
/*Main method which generates the problem instance*/
public class Pbgenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Generate 5 random points in a unit square*/
		Point[] points=  pbgen(5);
		System.out.println("The generated points of cities in a unit square are:");
		/*Display the generated points*/
		for(int k=0;k<points.length;k++){
			float a = points[k].x;
			float b = points[k].y;
			System.out.println("("+a+","+b+")");
		}
		System.out.println("Distances among Cities are:");
		/*Generate some random distances among the cities*/
		int [][] distances = distances();
		/*Display the generated distances*/
		for(int i=0;i<points.length;i++) {
			for(int j=0;j<points.length;j++) {
				System.out.print(distances[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	/*Function which generates the random points*/
	public static Point[] pbgen(int num){
		Random rn = new Random();
		Point[] points = new Point[num];
		float a;
		float b;
		for(int i=0; i<num;){
			/*Generate two random numbers between 0 and 1*/
			a =rn.nextFloat();
			b= rn.nextFloat();
			Point p = new Point(a, b);
			int c=0;
			int j=0;
			/*Check that the newly generated point is not already in the list of cities*/
			while(points[j]!=null){
				if(points[j].x != p.x && points[j].y != p.y){
					c++;
				}
				j++;
			}
			if(c == i){
				points[j] = p;
				i++;
			}
		}
		/*return the generated points in an array containing point objects*/
		return points;
	}
	/*Function for generating random distances among cities*/
	public static int[][] distances() {
		int [][] distances = new int[5][5];
		Random rn = new Random();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				/*distance from a city to itself is 0 */
				if(i==j) {
					distances[i][j]=0;
				}
				/*Distance from a city i to j is equal to distance from j to i*/
				else if(distances[j][i] != 0) {
					distances[i][j] = distances[j][i];
				}
				/*Generate random distances between 1 and 10*/
				else {
				distances[i][j] = rn.nextInt(10)+1;
				}
			}
		}
		/*return the generated distances as a 2D array*/
		return distances;
	}

}
