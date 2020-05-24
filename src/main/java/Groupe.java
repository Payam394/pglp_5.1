import java.util.ArrayList;
import java.util.LinkedList;

public class Groupe implements Department{
	
	public String gpName;
	public LinkedList <Department> sousHierarchie= new LinkedList<Department>();
	//public ArrayList<Department> sousHierarchie= new ArrayList<Department>();
	int tb=0;
	

	public Groupe(String name) {
		super();
		this.gpName = name;
	}
	
	
	public int getSize() {
		return sousHierarchie.size();
	}

	
	public int addTo (Department d) {
		try {
		sousHierarchie.add(d);
		return 1;
		}
		catch (Exception e){
			return 0;
		}
	}
	
	public int removeFrom (Department d) {
		try {
			sousHierarchie.remove(d);
			return 1;
			}
			catch (Exception e){
				return 0;
			}
	}
	
	public Department getIndex(int i) {
		return sousHierarchie.get(i);
	}
	
	void tabbing(int t) {
		for (int i=0; i!=t; i++)
			System.out.print("\t");
	}
	
	public void print() {
		
		System.out.println("Groupe name : " + gpName);
		System.out.println("{");
		
		tb++;
		
		for (Department i : this.sousHierarchie) {
			tabbing(tb);
			i.print();
			
		}
		tb--;
		System.out.println("} fin "+gpName+"\n");
	}

}
