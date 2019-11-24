package ma.sqli.tests.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private String nom;
	private List<String> documents;
	
	public Store() {	}
	
	public Store(String nom) {
		this.nom = nom;
		documents=new ArrayList<String>();
	}
	
	public void emptyStore(String s) {
		documents.clear();
	}

	
	
	public String toString() {
		
		StringBuilder s=new StringBuilder();
		s.append(nom);
		s.append(":");
		
		if(documents.isEmpty()) s.append(Etat.empty);
		else
		{
			for (String string : documents) { s.append(string);s.append(", ");}
			s.deleteCharAt(s.length()-1);
			s.deleteCharAt(s.length()-1);
		}
		
		return   s.toString();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<String> getDocuments() {
		return documents;
	}

	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	
	
}
