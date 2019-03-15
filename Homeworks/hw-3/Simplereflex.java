
public class Simplereflex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pm=0;
		/*Count the number of actions performed*/
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('A' + "		"+"Dirty"+" 	"+ "Dirty");
		pm = runagent('A',"Dirty","Dirty");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('B' + "		"+"Dirty"+" 	"+ "Dirty");
		pm= runagent('B', "Dirty","Dirty");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('A' + "		"+"Clean"+" 	"+ "Dirty");
		pm = runagent('A',"Clean","Dirty");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('A' + "		"+"Dirty"+" 	"+ "Clean");
		pm = runagent('A',"Dirty","Clean");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('B' + "		"+"Clean"+" 	"+ "Dirty");
		pm = runagent('B',"Clean","Dirty");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('B' + "		"+"Dirty"+" 	"+ "Clean");
		pm = runagent('B',"Dirty","Clean");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('A' + "		"+"Clean"+" 	"+ "Clean");
		pm = runagent('A',"Clean","Clean");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Location"+" "+"Status in A"+" "+"Status in B");
		System.out.println('B' + "		"+"Clean"+" 	"+ "Clean");
		pm = runagent('B',"Clean","Clean");
		System.out.println("Performance measure is: -"+pm);
		System.out.println("------------------------------------------------------------------------------");

	}
	/*generating a simple reflex agent which takes the location and status as inputs and returns the action
	 * to be performed
	 */
	public static String reflexagent(char location, String status) {
		/* If status is dirty return suck action*/
		if(status == "Dirty") {
			return "Suck";
		}
		/*If location is A then move right*/
		else if(location == 'A') {
			return "Right";
		}
		/*If location is B then move left*/
		else {
			return "left";
		}
	}
	/*This function takes the entire state description and displays the sequence of actions performed to reach the 
	 * goal state*/
	public static int runagent(char location,String statusinA,String statusinB) {
		String[] actions = new String[3];
		int i=0;
		/*Iterate until the goal state is reached*/
		while(statusinA != "Clean" || statusinB != "Clean") {
			/*If location is A then pass the status of A as parameter*/
			if(location == 'A') {
			actions[i] = reflexagent(location, statusinA);
			/*Update the state after an action is performed*/
			if(actions[i] == "Right") {
				location = 'B';
			}
			else {
				statusinA = "Clean";
			}
			}
			/*If location is B then pass the status of B as parameter*/
			else if(location == 'B'){
				actions[i] = reflexagent(location,statusinB);
				/*Update the state after an action is performed*/
				if(actions[i] == "left") {
					location = 'A';
				}
				else {
					statusinB = "Clean";
				}
			}
			/*If location is neither A nor B*/
			else {
				System.out.println("Wrong input of status");
				break;
			}
			/*Displays the action performed*/
			System.out.println(actions[i]);
			/*Count the number of actions performed*/
			i++;
			/*Displays the updated state*/
			System.out.println(location + " "+ statusinA+" "+ statusinB);
		}
		return i;
	}

}
