import java.util.ArrayList;

public class PersonnelDAO implements DAO<Personnel>{
	
	ArrayList<Personnel> PersonnelList;


	public ArrayList<Personnel> getAll() {
		return this.PersonnelList;
	}

	public Personnel getPersonel(int p) {
		return PersonnelList.get(p);
	}

	public void add(Personnel t) {
		PersonnelList.add(t);
		
	}

	public void delete(Personnel t) {
		PersonnelList.remove(t);
		
	}

	public void update(Personnel p) {
		PersonnelList.set(PersonnelList.indexOf(p), p);
	}
	
	
	


}