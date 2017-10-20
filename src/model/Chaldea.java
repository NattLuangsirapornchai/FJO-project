package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Chaldea {
	public static String Names[] = {"Arturia","Emiya","Heracles","Attila","Gilgamesh","Frankenstein","Somchai","Nattee","Vishnu"};
	public static String Types[] = {"Saber","Archer","Berserker","Saber","Archer","Berserker","Saber","Archer","Berserker"};
	public static int maxHP[] = {2000,1100,700,2200,1500,1200,5000,3000,4500};
	public static int attack[] = {1000,900,700,1700,1200,1500,2000,1500,1700};
	public static int defense[] = {1000,800,1900,700,1200,1500,2000,1500,2300};
	public static int initialSize = 9;
	private List<Servant> inventory = new ArrayList<>();
	
	public Chaldea(){
		// TODO Fill Code
		initailize();
		
	}
	
	public void initailize(){
		for (int i = 0;i < initialSize ; i++)
		{	
			if (Types[i].equals("Saber")) {
				Saber sv =  new Saber(Names[i],Types[i],maxHP[i],attack[i],defense[i]); this.addServant(sv);
			} else if (Types[i].equals("Archer")) {
				Archer sv =  new Archer(Names[i],Types[i],maxHP[i],attack[i],defense[i]); this.addServant(sv);
			} else if (Types[i].equals("Berserker")){
				Berserker sv =  new Berserker(Names[i],Types[i],maxHP[i],attack[i],defense[i]); this.addServant(sv);
			} else  continue ;
		}
		
		this.sortServant();
	}
	
	public void addServant(Servant person){
		//TODO Fill Code
		inventory.add(person);
		
	}
	
	public void sortServant(){
		// TODO Fill Code
		Collections.sort(inventory);
	}
	
	public void listServant(){
		//TODO Fill Code
		for(int i=0 ; i<inventory.size() ; i++) {
			Servant each = inventory.get(i) ;
			System.out.println(each);
		}
	}
	
	public int searchForServant(String Name){
		// TODO Fill Code
		for(int i=0 ; i<inventory.size(); ++i) {
			Servant sv = inventory.get(i) ;
			if(sv.getName().equals(Name)) {
				return i;
			}
		}
		return -1;
	}

	public List<Servant> getServant() {
		return inventory;
	}
}
