package first;
/*Implementing a data type Timepoint */
class Timepoint{
int tp;
public Timepoint(int x) {
	// TODO Auto-generated constructor stub
	tp=x;
}
int getdata(){
	return tp;
}
}
/*Implementing a datatype Inteval*/
class Interval {
	Timepoint bt;
	Timepoint et;
	Interval(int a, int b){
		 bt = new Timepoint(a);
		 et = new Timepoint(b);
	}
}
/*Actual main function of the first problem*/
public class Allen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i = new Interval(5,10);
		Interval i2 = new Interval(7,13);
		/*method calls to test the predicates*/
		meet(i,i2);
		before(i,i2);
		after(i,i2);
		during(i,i2);
		overlap(i,i2);
		equals(i,i2);
		finishes(i,i2);
		contains(i,i2);
		}
	public static Timepoint Start(Interval i){
		return i.bt;
	}
	public static Timepoint End(Interval i){
		return i.et;
	}
	/*The function which checks the predicate meet*/
	public static void meet(Interval i,Interval i2){
		System.out.println("Meet(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(End(i).getdata() == Start(i2).getdata()){
			System.out.println("The predicate meet(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate meet(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate before*/
	public static void before(Interval i,Interval i2){
		System.out.println("before(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(End(i).getdata() < Start(i2).getdata()){
			System.out.println("The predicate before(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate before(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate after*/
	public static void after(Interval i,Interval i2){
		System.out.println("after(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(End(i2).getdata() < Start(i).getdata()){
			System.out.println("The predicate after(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate after(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate during*/
	public static void during(Interval i,Interval i2){
		System.out.println("during(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(Start(i2).getdata() <= Start(i).getdata() && End(i).getdata() <= End(i2).getdata()){
			System.out.println("The predicate during(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate during(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate overlap*/
	public static void overlap(Interval i,Interval i2){
		System.out.println("overlap(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if((Start(i).getdata() <= Start(i2).getdata() && End(i).getdata() >= Start(i2).getdata()) || (Start(i).getdata() <= End(i2).getdata() && End(i2).getdata() <= End(i).getdata())){
			System.out.println("The predicate overlap(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate overlap(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate equals*/
	public static void equals(Interval i,Interval i2){
		System.out.println("equals(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(End(i).getdata() == End(i2).getdata() && Start(i).getdata() == Start(i2).getdata()){
			System.out.println("The predicate equals(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate equals(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate finishes*/
	public static void finishes(Interval i,Interval i2){
		System.out.println("finishes(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(End(i).getdata() == End(i2).getdata()){
			System.out.println("The predicate finishes(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate finishes(i,j) doesn't hold");
			System.out.println();
		}
	}
	/*function which checks the predicate contains*/
	public static void contains(Interval i,Interval i2){
		System.out.println("contains(i,j)");
		System.out.println("["+Start(i).getdata()+","+End(i).getdata()+"] and ["+Start(i2).getdata()+","+End(i2).getdata()+"]");
		if(Start(i).getdata() < Start(i2).getdata() && End(i).getdata() > End(i2).getdata()){
			System.out.println("The predicate contains(i,j) holds");
			System.out.println();
		}
		else{
			System.out.println("The predicate contains(i,j) doesn't hold");
			System.out.println();
		}
	}
}
