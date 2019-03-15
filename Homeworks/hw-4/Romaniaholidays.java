import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*implements city structure*/
class City{
	String name;
	/*consists of neighboring cities and the distances between them*/
	Map<City,Integer> neighbordist = new HashMap<City,Integer>();
	int h;
	/*this field is used in graph search*/
	int visited =0;
	public City(String n,int hu) {
		name=n;
		h=hu;
	}
}
/*Implements Node structure*/
class Node{
	Node parentnode;
	City c;
	/*This field consists of the child nodes of a particular node*/
	ArrayList<Node> alc = new ArrayList<>();
	int pathvalue;
} 
/*Main class which calls the search functions*/
public class Romaniaholidays {
	/*Global variables*/
	static City[] allCitiesList;
	static Map<String,City> allCitiesHtable = new HashMap<String,City>();
	static int nnv;
	public static void main(String[] args) {
		/*All city structures are instantiated*/
		City Arad= new City("Arad",366);
		City Bucharest = new City("Bucharest",0);
		City Craiova = new City("Craiova",160);
		City Dobreta = new City("Dobreta",242);
		City Eforie = new City("Eforie",161);
		City Fagarus = new City("Fagarus",176);
		City Giurgiu = new City("Giurgiu",77);
		City Hirsova = new City("Hirsova",151);
		City Iasi = new City("Iasi",226);
		City Lugoj = new City("Lugoj",244);
		City Mehadia = new City("Mehadia",241);
		City Neamt = new City("Neamt",234);
		City Oradea = new City("Oradea",380);
		City Pitesti = new City("Pitesti",100);
		City Rimnicu_Vilcea=new City("Rimnicu Vilcea",193);
		City Sibiu = new City("Sibiu",253);
		City Timisoara = new City("Timisoara",329);
		City Urziceni = new City("Urziceni",80);
		City Vaslui = new City("Vaslui",199);
		City Zerind = new City("Zerind",374); 
		Arad.neighbordist.put(Zerind, 75);
		Arad.neighbordist.put(Timisoara, 118);
		Arad.neighbordist.put(Sibiu, 140);
		Bucharest.neighbordist.put(Giurgiu, 90);
		Bucharest.neighbordist.put(Pitesti, 101);
		Bucharest.neighbordist.put(Fagarus, 211);
		Bucharest.neighbordist.put(Urziceni, 85);
		Craiova.neighbordist.put(Dobreta, 120);
		Craiova.neighbordist.put(Rimnicu_Vilcea, 146);
		Craiova.neighbordist.put(Pitesti, 138);
		Dobreta.neighbordist.put(Mehadia, 75);
		Dobreta.neighbordist.put(Craiova, 120);
		Eforie.neighbordist.put(Hirsova, 86);
		Fagarus.neighbordist.put(Sibiu, 99);
		Fagarus.neighbordist.put(Bucharest, 211);
		Giurgiu.neighbordist.put(Bucharest, 90);
		Hirsova.neighbordist.put(Eforie, 86);
		Hirsova.neighbordist.put(Urziceni, 98);
		Iasi.neighbordist.put(Neamt, 87);
		Iasi.neighbordist.put(Vaslui, 92);
		Lugoj.neighbordist.put(Timisoara, 111);
		Lugoj.neighbordist.put(Mehadia, 70);
		Mehadia.neighbordist.put(Lugoj, 70);
		Mehadia.neighbordist.put(Dobreta, 75);
		Neamt.neighbordist.put(Iasi, 87);
		Oradea.neighbordist.put(Zerind, 71);
		Oradea.neighbordist.put(Sibiu, 151);
		Pitesti.neighbordist.put(Craiova, 138);
		Pitesti.neighbordist.put(Rimnicu_Vilcea, 97);
		Pitesti.neighbordist.put(Bucharest, 101);
		Rimnicu_Vilcea.neighbordist.put(Sibiu, 80);
		Rimnicu_Vilcea.neighbordist.put(Pitesti, 97);
		Rimnicu_Vilcea.neighbordist.put(Craiova, 146);
		Sibiu.neighbordist.put(Fagarus, 99);
		Sibiu.neighbordist.put(Rimnicu_Vilcea, 80);
		Sibiu.neighbordist.put(Arad, 140);
		Sibiu.neighbordist.put(Oradea, 151);
		Timisoara.neighbordist.put(Arad, 118);
		Timisoara.neighbordist.put(Lugoj, 111);
		Urziceni.neighbordist.put(Bucharest, 85);
		Urziceni.neighbordist.put(Hirsova, 98);
		Urziceni.neighbordist.put(Vaslui, 142);
		Vaslui.neighbordist.put(Iasi, 92);
		Vaslui.neighbordist.put(Urziceni, 142);
		Zerind.neighbordist.put(Arad, 75);
		Zerind.neighbordist.put(Oradea, 71);
		/*System.out.println(Vaslui.name);
		System.out.println(Vaslui.h);
		Set<City> keys = Vaslui.neighbordist.keySet();
		for(City c:keys) {
			System.out.println(c.name);
			System.out.println(Vaslui.neighbordist.get(c));
		}*/
		/*All cities are being put into a list*/
		 allCitiesList = new City[]{Arad,Bucharest,Craiova,Dobreta,Eforie,Fagarus,Giurgiu,Hirsova,
				Iasi,Lugoj,Mehadia,Neamt,Oradea,Pitesti,Rimnicu_Vilcea,Sibiu,Timisoara,Urziceni,
				Vaslui,Zerind};
		 /*All cities are put in to a global hash map with names as keys and corresponding city objects as values*/
		 for(City c:allCitiesList) {
			 allCitiesHtable.put(c.name, c);
		 }
		 System.out.println("The CPU time is represented in nano seconds.");
		 System.out.println("City name"+"       "+"# nodes visited"+"				"+"Path followed"+"  		   "+"path cost"+"     "+"CPU time");
		 System.out.println("Using A* tree search:");
		 /*Search using A* from all cities to bucharest */
		 for(City c:allCitiesList) {
			 search(c.name,"Bucharest","A*");
		 }
		 System.out.println("-----------------------------------------------------------------------------------");
		 /*GraphSearch using A* from all cities to bucharest */
		 System.out.println("Using A* graph search:");
		 for(City c:allCitiesList) {
			 searchGraph(c.name, "Bucharest", "A*");
		 }
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.println("Using Uniform cost tree search:");
		 /*Search using Uniform cost from all cities to bucharest */
		 for(City c:allCitiesList) {
			 search(c.name, "Bucharest", "UCS");
		 }
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.println("Using Uniform cost graph search:");
		 /*GraphSearch using uniform cost from all cities to bucharest */
		 for(City c:allCitiesList) {
			 searchGraph(c.name, "Bucharest", "UCS");
		 }
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.println("Using Greedy tree search:");
		 /*Search using Greedy from all cities to bucharest */
		 for(City c:allCitiesList) {
			 search(c.name, "Bucharest", "Greedy");
		 }
		 System.out.println("-----------------------------------------------------------------------------------");
		 System.out.println("Using Greedy graph search:");
		 /*GraphSearch using Greedy from all cities to bucharest */
		 for(City c:allCitiesList) {
			 searchGraph(c.name, "Bucharest", "Greedy");
		 }
	}
	/*function which obtains all cities names from a list*/
	public static String[] allCitiesFromList() {
		String[] st = new String[allCitiesList.length];
		for(int i=0;i<allCitiesList.length;i++) {
			st[i] = allCitiesList[i].name;
		}
		return st;
	}
	/*function which returns all city objects from a global allcities hash table*/
	public static ArrayList<City> allCitiesFromHtable(){
		ArrayList<City> structcities = new ArrayList<>();
		Map<String, City> hm = allCitiesHtable;
		Set<String> s = hm.keySet();
		for(String st:s) {
			structcities.add(hm.get(st));
		}
		return structcities;
	}
	/*Function which returns a corresponding city object for the provided city name */
	public static City getCityFromList(String name) {
		int i=0;
		for(i=0;i<allCitiesList.length;i++) {
			if(allCitiesList[i].name == name)
				return allCitiesList[i];
		}
		return null;
	}
	/*Function that returns corresponding city object for the provided city name*/
	public static City getCityFromHtable(String name) {
		return allCitiesHtable.get(name);
	}
	/*function that returns a set of objects which are neighbors to the provided city name using allcities list*/
	public static Set<City> neighborsUsingList(String name) {
		City c = getCityFromList(name);
		Set<City> s = c.neighbordist.keySet();
		return s;
	}
	/*function that returns a set of objects which are neighbors to the provided city using allcities hash table*/
	public static Set<City> neighborsUsingHtable(String name){
		City c = getCityFromHtable(name);
		Set<City> s = c.neighbordist.keySet();
		return s;
	}
	/*function that returns an association list of neighbors along with their distances from a city with in a particular distance limit*/
	public static Map<City,Integer> neighborsWithinD(String mycity, int distance){
		Map<City,Integer> neighcities = new HashMap<>();
		City c = getCityFromHtable(mycity);
		Set<City> s = c.neighbordist.keySet();
		for(City ci: s) {
			if(c.neighbordist.get(ci) <= distance )
				neighcities.put(ci, c.neighbordist.get(ci));
		}
		return neighcities;
	}
	/*function that returns the distance between two cities if both if them are neighbors to each other*/
	public static int neighborsP(String city1,String city2) {
		Set<City> s = neighborsUsingHtable(city1);
		for(City ci: s) {
			if(ci.name == city2) {
				return getCityFromHtable(city1).neighbordist.get(ci);
			}
		}
		return 0;
	}
	/*function that expands a node*/
	public static ArrayList<Node> expandnode(Node n){
		ArrayList<Node> nextnodes = new ArrayList<>();
		Set<City> s = neighborsUsingList(n.c.name);
		int i =0;
		for(City c:s) {
			/*check if the node is already visited in graph search*/
			if(c.visited == 0) {
			/*Increment the number of nodes generated*/	
			nnv++;
			Node nt = new Node();
			nt.parentnode=n;
			nt.c = c;
			nt.pathvalue = n.pathvalue + neighborsP(n.c.name, nt.c.name);
			nextnodes.add(i, nt);
			i++;
			}
		}
		return nextnodes;
	}
	/*Function that returns the heuristic value based on the search technique*/
	public static int evaluatenode(Node n,String searchStrategy) {
		if(searchStrategy == "Greedy")
			return n.c.h;
		else if(searchStrategy == "UCS")
			return n.pathvalue;
		else
			return n.c.h + n.pathvalue;
	}
	/*Function that returns the best node in the fringe based on search strategy */
	public static Node searchstrategy(ArrayList<Node> nextnodes, String searchStrategy) {
		Node nret = nextnodes.get(0);
		int dist = evaluatenode(nextnodes.get(0),searchStrategy);
		for(Node n: nextnodes) {
			 if(evaluatenode(n, searchStrategy) < dist) {
				dist = evaluatenode(n, searchStrategy);
				nret = n;
			}
		}
		return nret;
	}
	/*function which performs the tree search from a given cityname */
	public static void search(String cityname,String goalname,String strategy) {
		long startTime = System.nanoTime();
		for(City c:allCitiesList) {
			c.visited=0;
		}
		City rootcity = getCityFromList(cityname);
		Node currentnode = new Node();
		currentnode.c = rootcity;
		currentnode.pathvalue=0;
		nnv = 1;
		currentnode.parentnode = null;
		ArrayList<Node> fringe = new ArrayList<>();
		/*continue until the goal node is reached*/
		while(currentnode.c.name != goalname) {
			//nnv++;
			ArrayList<Node> nextnodes = expandnode(currentnode);
			/*Add the successors to the fringe*/
			for(Node n: nextnodes) {
				fringe.add(n);
			}
			/*remove the expanded node from the fringe*/
			Node parent = nextnodes.get(0).parentnode;
			Iterator<Node> iter = fringe.iterator();
			while(iter.hasNext()) {
				Node n = iter.next();
				if(n.c.name == parent.c.name)
					iter.remove();
			}
			/*get the next node to expand*/
			currentnode = searchstrategy(fringe, strategy);
		}
		long endTime = System.nanoTime();
		Node goalnode = currentnode;
		System.out.format("%10s",cityname);
		System.out.print("		"+nnv+"	");
		ArrayList<Node> path = new ArrayList<>();
		/*get the path followed from the city to the goal node*/
		while(currentnode.pathvalue != 0 ) {
			path.add(currentnode);
			currentnode = currentnode.parentnode;
		}
		String s="";
		for(int i = path.size()-1;i>=0;i--) {
			s+= path.get(i).c.name+",";
		}
		System.out.format("%50s",s);
		System.out.format("%10d",goalnode.pathvalue);
		System.out.println("  "+(endTime-startTime));
		
	}
	/*Function which performs the graph search from a given citynode*/
	public static void searchGraph(String cityname,String goalname,String strategy) {
		long startTime = System.nanoTime();
		/*At the start make sure that no city is visited*/
		for(City c:allCitiesList) {
			c.visited=0;
		}
		City rootcity = getCityFromList(cityname);
		Node currentnode = new Node();
		currentnode.c = rootcity;
		currentnode.pathvalue=0;
		nnv = 1;
		currentnode.parentnode = null;
		ArrayList<Node> fringe = new ArrayList<>();
		/*Iterate until the goal node is reached*/
		while(currentnode.c.h !=0) {
			//nnv++;
			/*Set the current node as visited*/
			currentnode.c.visited =1;
			ArrayList<Node> nextnodes = expandnode(currentnode);
			/*Add the generated nodes in to the finge*/
			for(Node n: nextnodes) {
				fringe.add(n);
			}
			if(nextnodes.size() == 0) {
				Iterator<Node> iter = fringe.iterator();
				while(iter.hasNext()) {
					Node n = iter.next();
					if(n.c.name == currentnode.c.name)
						iter.remove();
				}
			}
			else {
			Node parent = nextnodes.get(0).parentnode;
			Iterator<Node> iter = fringe.iterator();
			/*remove the expanded node from fringe*/
			while(iter.hasNext()) {
				Node n = iter.next();
				if(n.c.name == parent.c.name)
					iter.remove();
			}
			}
			/*get the next node to expand*/
			currentnode = searchstrategy(fringe, strategy);
		}
		long endTime = System.nanoTime();
		Node goalnode = currentnode;
		System.out.format("%10s",cityname);
		System.out.print("		"+nnv+"	");
		ArrayList<Node> path = new ArrayList<>();
		while(currentnode.pathvalue != 0 ) {
			path.add(currentnode);
			currentnode = currentnode.parentnode;
		}
		String s ="";
		/*obtain the path followed in reaching the goal*/
		for(int i = path.size()-1;i>=0;i--) {
			s+= path.get(i).c.name+",";
		}
		System.out.format("%50s",s);
		System.out.format("%10d",goalnode.pathvalue);
		System.out.println("	"+ (endTime-startTime));
		
	}
}
