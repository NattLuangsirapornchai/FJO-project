package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

import model.Servant;
import model.Archer;
import model.Saber;
import model.Berserker;
import model.Chaldea;

public class Event {
	public static Scanner in;
	public static Chaldea inventory;
	public static Berserker fujimaru = new Berserker("Gudako", "Berserker", 10000, 2000, 100);
	public static List<Servant> team;

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		inventory = new Chaldea();
		team = new ArrayList<>();
		
		System.out.println("Yokoso Fate Java Order!!!");
		System.out.println("The Java world will be destroyed by Gudako. Let's save this world!");
		System.out.println("Choose 3 servants to do the mission :");
		System.out.println("----------------------------------------------------");
		inventory.listServant();
		System.out.println("----------------------------------------------------");
		int i=1 ;
		Set<Integer> dup = new HashSet<>() ;
		while (i!=4) {
			System.out.print("Servant #"+i+" : ");
			String name = in.nextLine();
			int index = inventory.searchForServant(name);
			if (index<0) {
				System.out.println("Wrong name, please try again");
			} else if (dup.contains(index)){
				System.out.println("The servant is double, please try again");
			} else {
				dup.add(index) ;
				Servant sv = inventory.getServant().get(index);
				if(sv instanceof Archer) sv = (Archer) sv ;
				else if(sv instanceof Saber) sv = (Saber) sv ;
				else if(sv instanceof Berserker) sv = (Berserker) sv ;
				team.add(sv);
				i++ ;
			}
		}
		System.out.println("---------------Successful---------------------------");
		getTeam();
		System.out.println("Remember your Servant ID, Let's fight!!!");
		System.out.println("");
		System.out.println("Gudako | HP : "+fujimaru.getHp());
		int r = 1 ;
		while(!team.isEmpty() && !fujimaru.isDefeated()) {
			System.out.println("*****Round"+r+"*****");
			System.out.println("#First impact : ");
			System.out.print("Enter Servent ID to fight : ");
			
				int a1 = in.nextInt();
				in.nextLine();
				System.out.print("Enter the attack pattern (Buster->B , Art->A , Quick->Q) : ");
				char f1 = (in.nextLine().toUpperCase()).charAt(0);
				if(a1>team.size()) throw new Exception() ;
			
				System.out.println("#Second impact : ");
				System.out.print("Enter Servent ID to fight : ");
				int a2 = in.nextInt();
				in.nextLine();
				System.out.print("Enter the attack pattern (Buster->B , Art->A , Quick->Q) : ");
				char f2 = (in.nextLine().toUpperCase()).charAt(0);
				if(a2>team.size()) throw new Exception() ;
			
				System.out.println("#Third impact : ");
				System.out.print("Enter Servent ID to fight : ");
				int a3 = in.nextInt();
				in.nextLine();
				System.out.print("Enter the attack pattern (Buster->B , Art->A , Quick->Q) : ");
				char f3 = (in.nextLine().toUpperCase()).charAt(0);
				if(a3>team.size()) throw new Exception() ;
				
				
			try {
				(team.get(a1)).action(fujimaru, f1);
				(team.get(a2)).action(fujimaru, f2);
				(team.get(a3)).action(fujimaru, f3);
			}
			catch (Exception e){
				System.out.println("###This attack is wrong index, please try again");
				continue;
			}
			if(fujimaru.isDefeated()) break ;
			
			System.out.println("Gudako attack!!!");
			Random rand = new Random() ;
			int unlucky = rand.nextInt(team.size()) ;
			fujimaru.action(team.get(unlucky),'B');
			if(team.get(unlucky).isDefeated()) {
				System.out.println(team.get(unlucky).getName()+" is lost.");
				team.remove(unlucky);
			}
			getTeam();
			System.out.println("Gudako | HP : "+fujimaru.getHp());
			r++;
		}
		
		if(fujimaru.isDefeated()) {
			System.out.println("*****Congratulation, You can save the world from Gudako*****");
		} else {
			System.out.println("*****You are lost, Gudako can conquer the world*****");
		}
		System.exit(0);
		

	}

	public static void getTeam() {
		for (int i = 0; i < team.size(); i++) {
			System.out.println("ID : " + i + " " + team.get(i));
		}
	}
}
