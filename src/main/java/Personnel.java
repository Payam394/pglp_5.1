import java.time.LocalDate;


public class Personnel implements Department{
	
	
	private String nom;
	private String prenom;
	private int ID;
	
	private String telephone;
	
	private LocalDate dateDeNaissance;
	
	public static class Builder {
		
		private String nom;
		private String prenom;
		private int ID;
		
		private String telephone;
		
		private LocalDate dateDeNaissance;
		
		public Builder (String nom, String prenom, int id) {
			this.nom=nom;
			this.prenom=prenom;
			this.ID = id;
		}
		
		public Builder withTelephone(String tel) {
			this.telephone=tel;
			return this;
		}
		
		public Builder withDateN(LocalDate date) {
			this.dateDeNaissance=date;
			return this;
		}
		
		
		public Personnel build () {
			Personnel p= new Personnel(this);
			
			return p;
		}
		
	}
	

	
	private Personnel(Builder personnels) {
		
		this.nom=personnels.nom;
		this.prenom=personnels.prenom;
		this.ID=personnels.ID;
		this.dateDeNaissance=personnels.dateDeNaissance;
		this.telephone=personnels.telephone;
	
	}
	
	public void print() {
		System.out.println("Personne { "+"Nom: " + nom + "\tPrenom: " + prenom + "\tId: " + ID + " }");
		
	}
	
	
}
