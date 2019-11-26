package friends;

import java.util.ArrayList;

import structures.Queue;
import structures.Stack;

public class Friends {

	/**
	 * Finds the shortest chain of people from p1 to p2.
	 * Chain is returned as a sequence of names starting with p1,
	 * and ending with p2. Each pair (n1,n2) of consecutive names in
	 * the returned chain is an edge in the graph.
	 * 
	 * @param g Graph for which shortest chain is to be found.
	 * @param p1 Person with whom the chain originates
	 * @param p2 Person at whom the chain terminates
	 * @return The shortest chain from p1 to p2. Null if there is no
	 *         path from p1 to p2
	 */
	public static ArrayList<String> shortestChain(Graph g, String p1, String p2) {
		
	//search members to identify p1 and p2 nodes
		ArrayList<String> answer = new ArrayList<String>();
		answer.add(p1);
		
		Person person1= null;
		int p1fNum = 0;
		int p2fNum = 0;
		
		for(int i = 0; i < g.members.length; i++) {
			if(g.members[i].name.equals(p1)) {
				person1 = g.members[i];
			}
			break;
		}
		if(person1 == null) {
			return null;
		}
		
		p1fNum = g.map.get(p1);
		p2fNum = g.map.get(p2);
		
		boolean[] visited = new boolean[g.members.length];
		Queue<Friend> q = new Queue<Friend>();
		
		q.enqueue(new Friend(p1fNum, person1.first));
		visited[p1fNum] = true;
		answer.add(p1);
		while (!q.isEmpty()) {
			Friend current = q.dequeue();
			while (current.next != null) {
				current = current.next;
				if(!visited[current.fnum]) {
					q.enqueue(current);
					visited[current.fnum] = true;
				}
			}
			
			
		}
		
		
		
		
		
		
		
		
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE COMPILER HAPPY
		// CHANGE AS REQUIRED FOR YOUR IMPLEMENTATION
		return null;
	}
	
	/**
	 * Finds all cliques of students in a given school.
	 * 
	 * Returns an array list of array lists - each constituent array list contains
	 * the names of all students in a clique.
	 * 
	 * @param g Graph for which cliques are to be found.
	 * @param school Name of school
	 * @return Array list of clique array lists. Null if there is no student in the
	 *         given school
	 */
	public static ArrayList<ArrayList<String>> cliques(Graph g, String school) {
		
		ArrayList<ArrayList<String>> answer = new ArrayList<ArrayList<String>>();
		boolean[] visited = new boolean[g.members.length];
		
		
		for (int i = 0; i< g.members.length; i++) {
			ArrayList<String> list = new ArrayList<String>();
			if(visited[i]==false) {
				DFScliques(list, g, new Friend(i,g.members[i].first), school, visited);
			}
			System.out.println(i);

			if(list.size() !=0) {
				answer.add(list);
			}
		}
		
		/** COMPLETE THIS METHOD **/
		
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE COMPILER HAPPY
		// CHANGE AS REQUIRED FOR YOUR IMPLEMENTATION
		return answer;
		
	}
	
	/**
	 * Finds and returns all connectors in the graph.
	 * 
	 * @param g Graph for which connectors needs to be found.
	 * @return Names of all connectors. Null if there are no connectors.
	 */
	public static ArrayList<String> connectors(Graph g) {
		
		/** COMPLETE THIS METHOD **/
		
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE COMPILER HAPPY
		// CHANGE AS REQUIRED FOR YOUR IMPLEMENTATION
		return null;
		
	}
	
	/*private static ArrayList<Integer> findShortest(Friend curr, int target, boolean[] visited, ArrayList<Integer> list){
		Friend ptr = curr;
		
		if(curr.fnum == target) {
			return list;
		}
		
		while(ptr!=null) {
			if(visited[ptr.fnum]== false) {
				list.add(ptr.fnum);
			}
		}
	}
	*/
	
	
	private static ArrayList<String> DFScliques(ArrayList<String> list, Graph g, Friend curr, String school, boolean[] visited){
			if (g.members[curr.fnum].school != null && g.members[curr.fnum].school.equals(school)){
				list.add(g.members[curr.fnum].name);
				visited[curr.fnum] = true;
			} else {
				visited[curr.fnum] = true;
				return null;
			}
		
		

		Friend ptr = curr.next;
		if(ptr == null && g.members[curr.fnum].first != null) {
			ptr = g.members[curr.fnum].first;
			while(ptr != null && visited[ptr.fnum]) {
				ptr = ptr.next;
			}
		}
		
		while(ptr != null) {
			if(visited[ptr.fnum] == false) {
				DFScliques(list, g, ptr,school, visited);
				//visited[ptr.fnum] = true;
			}
			ptr = ptr.next;
		}
		return list;
	}
}

