import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class AffichageParGroupe implements Container, Serializable{
	

	ArrayList<Department> Arr = new ArrayList<Department>();
	
	
	
	public AffichageParGroupe(ArrayList<Department> Arr) {
		this.Arr=Arr;
	}
	
	public Iterator getIterator() {
		return new grpIterator();
	}
	
	

	private class grpIterator implements Iterator{
		
		int index=0;
		
		public boolean hasNext() {
			if(index<Arr.size())
				return true;			
			return false;
		}

		
		public Department next() {
			if(this.hasNext()) {
				index++;
				return Arr.get(index-1);
			}	
			return null;
		}
		
		public void affichageParProfond() {
			
			int verifier=0;
			
			while(verifier<Arr.size()) {
				if(Arr.get(verifier) instanceof Groupe) {
					Groupe test=(Groupe)Arr.get(verifier);
					System.out.println(test.gpName);
					
					for (int i = 0; i < Arr.size(); i++) {
						
					}
					
					
					int i=0;
					
					while(i<test.getSize()) {
						Arr.add(test.getIndex(i));
						i++;
					}
				}
				else {
					Arr.get(verifier).print();
				}
				verifier++;
			}
			
		}
		
	}
	
	

}
