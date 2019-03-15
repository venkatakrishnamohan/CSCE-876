package first;

import java.util.ArrayList;
import java.util.Arrays;
/*Homework 2*/
/*Missionary Cannibals Problem*/
/* main class implement second problem*/
public class Missionaries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Declare the initial and goal states*/
		int state[]={3,3,0,0,0};
		int goal[]={0,0,3,3,1};
		/*call the get path function to obtain a path to the goal state*/
		getpath(state, goal);
	}
	/*check whether the state is safe or not*/
	public static boolean safe(int[] a){
		/*No of missionaries on either bank must be less than no of cannibals then it is an 
		 * unsafe state other than the case of no.of missionaries are 0*/
		if((a[0] < a[1] || a[2] < a[3]) && !(a[0]<1 || a[2]<1))
			return false;
		else
			return true;
	}
	/*check whether the state is already present in list of visited states*/
	public static boolean contains(ArrayList<int []> al,int[] cs) {
		int c=0;
		for(int i=0;i<al.size();i++){
			if(Arrays.equals(al.get(i),cs)){
				c=1;
				break;
			}
		}
		if(c==1){
			return true;
		}
		else{
			return false;
		}
	}
	/*check the state when missionary takes self is safe or not*/
	public static boolean missionary_take_self(ArrayList<int []> visitedstates,int[] cs){
		int ms[]=copy(cs);
		int zeroes[]={0,0,0,0,0};
		if(ms[4] == 0 && (ms[0]>=1 && ms[0]<=3)){
			ms[4]=1;
			ms[0]-=1;
			ms[2]+=1;
		}
		else if(ms[4]==1 && ms[2]>=1 && ms[2]<=3){
			ms[4]=0;
			ms[2]-=1;
			ms[0]+=1;
		}
		/*Undesirable state*/
		else{
			ms[0]=0;
			ms[1]=0;
			ms[2]=0;
			ms[3]=0;
			ms[4]=0;
		}
		/*check whether the state is safe and check it isn't present in the list of already
		 * visited states, if safe copy contents of modified state in to the passed argument current state*/
		if(safe(ms) && !contains(visitedstates,ms) && !Arrays.equals(ms,zeroes)){
			for(int x=0;x<cs.length;x++){
				cs[x]=ms[x];
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*check the state when cannibal takes self is safe or not*/
	public static boolean cannibal_take_self(ArrayList<int []> visitedstates,int[] cs){
		int ms[]=copy(cs);
		int zeroes[]={0,0,0,0,0};
		if(ms[4] == 0 && (ms[1]>=1 && ms[1]<=3)){
			ms[4]=1;
			ms[1]-=1;
			ms[3]+=1;
		}
		else if(ms[4]==1 && ms[3]>=1 && ms[3]<=3){
			ms[4]=0;
			ms[3]-=1;
			ms[1]+=1;
		}
		/*Undesirable state*/
		else{
			ms[0]=0;
			ms[1]=0;
			ms[2]=0;
			ms[3]=0;
			ms[4]=0;
		}
		/*check whether the state is safe and check it isn't present in the list of already
		 * visited states, if safe copy contents of modified state in to the passed argument current state*/
		if(safe(ms) && !contains(visitedstates,ms) && !Arrays.equals(ms,zeroes)){
			for(int x=0;x<cs.length;x++){
				cs[x]=ms[x];
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*check the state missionary takes cannibal is safe or not*/
	public static boolean missionary_take_cannibal(ArrayList<int []> visitedstates,int[] cs){
		int ms[]=copy(cs);
		int zeroes[]={0,0,0,0,0};
		if(ms[4] == 0 && (ms[0]>=1 && ms[0]<=3 && ms[1]>=1 && ms[1]<=3)){
			ms[4]=1;
			ms[0]-=1;
			ms[1]-=1;
			ms[2]+=1;
			ms[3]+=1;
		}
		else if(ms[4]==1 && (ms[2]>=1 && ms[2]<=3 && ms[3]>=1 && ms[3]<=3)){
			ms[4]=0;
			ms[2]-=1;
			ms[3]-=1;
			ms[0]+=1;
			ms[1]+=1;
		}
		/*Undesirable state*/
		else{
			ms[0]=0;
			ms[1]=0;
			ms[2]=0;
			ms[3]=0;
			ms[4]=0;
		}
		/*check whether the state is safe and check it isn't present in the list of already
		 * visited states, if safe copy contents of modified state in to the passed argument current state*/
		if(safe(ms) && !contains(visitedstates,ms) && !Arrays.equals(ms,zeroes)){
			for(int x=0;x<cs.length;x++){
				cs[x]=ms[x];
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*check the state when missionary takes missionary is safe or not*/
	public static boolean missionary_take_missionary(ArrayList<int []> visitedstates,int[] cs){
		int ms[]=copy(cs);
		int zeroes[]={0,0,0,0,0};
		if(ms[4] == 0 && ms[0]>=2 && ms[0]<=3){
			ms[4]=1;
			ms[0]-=2;
			ms[2]+=2;
		}
		else if(ms[4]==1 && ms[2]>=2 && ms[2]<=3){
			ms[4]=0;
			ms[2]-=2;
			ms[0]+=2;
		}
		/*Undesirable state*/
		else{
			ms[0]=0;
			ms[1]=0;
			ms[2]=0;
			ms[3]=0;
			ms[4]=0;
			}
		/*check whether the state is safe and check it isn't present in the list of already
		 * visited states, if safe copy contents of modified state in to the passed argument current state*/
		if(safe(ms) && !contains(visitedstates,ms) && !Arrays.equals(ms,zeroes)){
			for(int x=0;x<cs.length;x++){
				cs[x]=ms[x];
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*check the state when cannibal takes cannibal is safe or not*/
	public static boolean cannibal_take_cannibal(ArrayList<int []> visitedstates,int[] cs){
		int ms[]=copy(cs);
		int zeroes[]={0,0,0,0,0};
		if(ms[4] == 0 && ms[1]>=2 && ms[1]<=3){
			ms[4]=1;
			ms[1]-=2;
			ms[3]+=2;
		}
		else if(ms[4]==1 && ms[3]>=2 && ms[3]<=3){
			ms[4]=0;
			ms[3]-=2;
			ms[1]+=2;
		}
		/*Undesirable state*/
		else{
			ms[0]=0;
			ms[1]=0;
			ms[2]=0;
			ms[3]=0;
			ms[4]=0;
		}
		/*check whether the state is safe and check it isn't present in the list of already
		 * visited states, if safe copy contents of modified state in to the passed argument current state*/
		if(safe(ms) && !contains(visitedstates,ms) && !Arrays.equals(ms,zeroes)){
			for(int x=0;x<cs.length;x++){
				cs[x]=ms[x];
			}
			return true;
		}
		else{
			return false;
		}
	}
	/*Make a copy of the current state object so that changes can be performed on the 
	 * copied state instead of current state*/
	public static int[] copy(int[] a){
		int d[]= new int[5];
		 for(int x=0;x<a.length;x++){
			 d[x]=a[x];
	}
		 return d;
	}/*this function displays the path followed to obtain a solution if one exists*/
	public static void getpath(int[] cs,int[] g){
		ArrayList<int []> visitedstates = new ArrayList<int []>();
		int gs[]={0,0,0,0,0};
		for(int x=0;x<gs.length;x++){
			gs[x]=cs[x];
		}
		visitedstates.add(cs);
		/*iterate through the possible states in search space and determine which states are safe
		 * and required to obtain a solution*/
		while(!(Arrays.equals(gs,g))){
			if(missionary_take_cannibal(visitedstates,gs)){
				int as[]={0,0,0,0,0};
				for(int x=0;x<as.length;x++){
				as[x]=gs[x];
				}
				System.out.println("Missionary Take Cannibal");
				visitedstates.add(as);
				as=null;
			}
			else if(missionary_take_missionary(visitedstates,gs) ){
				int as[]={0,0,0,0,0};
				for(int x=0;x<as.length;x++){
				as[x]=gs[x];
				}
				System.out.println("Missionary Take Missionary");
				visitedstates.add(as);
				as=null;
			}
			else if(cannibal_take_cannibal(visitedstates,gs)){
				int as[]={0,0,0,0,0};
				for(int x=0;x<as.length;x++){
				as[x]=gs[x];
				}
				System.out.println("Cannibal Take Cannibal");
				visitedstates.add(as);
				as=null;
			}
			else if(missionary_take_self(visitedstates,gs)){
				int as[]={0,0,0,0,0};
				for(int x=0;x<as.length;x++){
				as[x]=gs[x];
				}
				System.out.println("Missionary Take Self");
				visitedstates.add(as);
				as=null;
			}
			else if(cannibal_take_self(visitedstates,gs) ){
				int as[]={0,0,0,0,0};
				for(int x=0;x<as.length;x++){
				as[x]=gs[x];
				}
				System.out.println("Cannibal Take Self");
				visitedstates.add(as);
				as=null;
			}
			else{
				System.out.println("No solution exists");
				break;
			}
		}
		/*Display all the states in array list which are visited states*/
		display(visitedstates);
	}
	/*Function which displays the arraylist consisting of visited states*/
	public static void display(ArrayList<int []> visitedstates) {
		for(int i=0; i<visitedstates.size();i++){
			 int j[]=visitedstates.get(i);
			 System.out.print("[");
			 for(int k=0;k<j.length;k++){
				 System.out.print(j[k]+",");
			 }
			 System.out.print("]");
			 System.out.println("");
		 }
	}
}
