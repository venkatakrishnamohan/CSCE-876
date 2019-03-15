import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class City{
	String name;
	Map<City,Integer> neighbordist = new HashMap<City,Integer>();
	int h;
	int visited =0;
	public City(String n,int hu) {
		name=n;
		h=hu;
	}
	/*public void dist(List<City> neighbors,int[] distances) {
		for(int i=0;i<neighbors.size();i++) {
			neighbordist.put(neighbors.get(i), distances[i]);
		}
	}*/
}
class Node{
	Node parentnode;
	City c;
	ArrayList<Node> alc = new ArrayList<>();
	int pathvalue;
}
public class Romaniaholidays {
	static City[] allCitiesList;
	static int nnv;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,City> allCitiesHash = new HashMap<String,City>();
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
		 allCitiesList = new City[]{Arad,Bucharest,Craiova,Dobreta,Eforie,Fagarus,Giurgiu,Hirsova,
				Iasi,Lugoj,Mehadia,Neamt,Oradea,Pitesti,Rimnicu_Vilcea,Sibiu,Timisoara,Urziceni,
				Vaslui,Zerind};
		 for(City c:allCitiesList) {
			 search(c.name,"Bucharest","A*");
		 }
		 System.out.println("-----------------------------------------------------------------------------------");
		 for(City c:allCitiesList) {
			 searchGraph(c.name, "Bucharest", "A*");
		 }
	}
	public static String[] allCitiesFromList() {
		String[] st = new String[allCitiesList.length];
		for(int i=0;i<allCitiesList.length;i++) {
			st[i] = allCitiesList[i].name;
		}
		return st;
	}
	public static City getCityFromList(String name) {
		int i=0;
		for(i=0;i<allCitiesList.length;i++) {
			if(allCitiesList[i].name == name)
				return allCitiesList[i];
		}
		return null;
	}
	public static Set<City> neighborsUsingList(String name) {
		City c = getCityFromList(name);
		Set<City> s = c.neighbordist.keySet();
		return s;
	}
	public static Map<City,Integer> neighborsWithinD(String mycity, int distance){
		Map<City,Integer> neighcities = new HashMap<>();
		City c = getCityFromList(mycity);
		Set<City> s = c.neighbordist.keySet();
		for(City ci: s) {
			if(c.neighbordist.get(ci) <= distance )
				neighcities.put(ci, c.neighbordist.get(ci));
		}
		return neighcities;
	}
	public static int neighborsP(String city1,String city2) {
		Set<City> s = neighborsUsingList(city1);
		for(City ci: s) {
			if(ci.name == city2) {
				return getCityFromList(city1).neighbordist.get(ci);
			}
		}
		return 0;
	}
	public static ArrayList<Node> expandnode(Node n){
		ArrayList<Node> nextnodes = new ArrayList<>();
		Set<City> s = neighborsUsingList(n.c.name);
		int i =0;
		for(City c:s) {
			if(c.visited == 0) {
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
	public static int evaluatenode(Node n,String searchStrategy) {
		if(searchStrategy == "Greedy")
			return n.c.h;
		else if(searchStrategy == "UCS")
			return n.pathvalue;
		else
			return n.c.h + n.pathvalue;
	}
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
		while(currentnode.c.name != goalname) {
			nnv++;
			ArrayList<Node> nextnodes = expandnode(currentnode);
			for(Node n: nextnodes) {
				fringe.add(n);
			}
			Node parent = nextnodes.get(0).parentnode;
			Iterator<Node> iter = fringe.iterator();
			while(iter.hasNext()) {
				Node n = iter.next();
				if(n.c.name == parent.c.name)
					iter.remove();
			}
			currentnode = searchstrategy(fringe, strategy);
		}
		Node goalnode = currentnode;
		System.out.print(cityname);
		System.out.print("		"+nnv+"	");
		while(currentnode.pathvalue != 0 ) {
		System.out.print(currentnode.c.name+" ");
		currentnode = currentnode.parentnode;
		}
		System.out.print("							" + goalnode.pathvalue);
		long endTime = System.nanoTime();
		System.out.println("	"+ (endTime-startTime));
		
	}
	public static void searchGraph(String cityname,String goalname,String strategy) {
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
		while(currentnode.c.h !=0) {
			nnv++;
			currentnode.c.visited =1;
			ArrayList<Node> nextnodes = expandnode(currentnode);
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
			while(iter.hasNext()) {
				Node n = iter.next();
				if(n.c.name == parent.c.name)
					iter.remove();
			}
			}
			currentnode = searchstrategy(fringe, strategy);
		}
		System.out.println("From "+ cityname +" to "+ goalname);
		System.out.println(nnv);
		System.out.println("Path cost is:" + currentnode.pathvalue);
		long endTime = System.nanoTime();
		System.out.println(endTime-startTime);
		/*while(currentnode.pathvalue != 0 ) {
			System.out.println(currentnode.c.name);
			currentnode = currentnode.parentnode;
		}*/
	}
}
