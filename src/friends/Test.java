package friends;

import structures.Queue;
import structures.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
	
	public static void main (String[] args) throws FileNotFoundException{
		File graph = new File("C:\\Users\\KingRobert\\eclipse-workspace\\Friends\\src\\friends\\graph.txt");
		Scanner sc = new Scanner(graph);
		Graph g = new Graph(sc);
		sc.close();
		
		System.out.println(g.members[9].first.fnum);
		
		System.out.println("Which method do you want to test? 1 for shortestChain, 2 for cliques, 3 for connectors");
		Scanner read = new Scanner(System.in);
		int choice = read.nextInt();
		read.close();

		
		if(choice == 1) {
			System.out.println("Between which 2 people? Enter both names");
			Scanner ppl = new Scanner(System.in);
			String p1 = ppl.nextLine();
			String p2 = ppl.nextLine();
			ppl.close();
			ArrayList<String> result = Friends.shortestChain(g, p1,p2);
			
			for(int i = 0; i<result.size(); i++) {
				System.out.println(result.get(0));
			}
			System.out.println("\n end of list");
		} else if (choice == 2) {
			
			ArrayList<ArrayList<String>> result = Friends.cliques(g, "penn state");
			

			for (int i = 0; i<result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
		
		
	}

}
