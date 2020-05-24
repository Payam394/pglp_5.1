import java.io.Serializable;
import java.util.ArrayList;

public class Groupe implements Department, Serializable, DAO<Department>{
	
	public String gpName;
	//public LinkedList <Department> sousHierarchie= new LinkedList<Department>();
	public ArrayList<Department> sousHierarchie= new ArrayList<Department>();
	int tb=0;
	

	public Groupe(String name) {
		super();
		this.gpName = name;
	}
	
	public ArrayList<Department> getAll() {
		return sousHierarchie;
	}
	

	public Department getPersonel(int p) {
		return sousHierarchie.get(p);
	}


	public void add(Department t) {
		addTo(t);
	}


	public void delete(Department t) {
		removeFrom (t);
	}


	public void update(Department t) {
		sousHierarchie.set(sousHierarchie.indexOf(t), t);
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
