package ma.sqli.tests.cloudinfrastructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Machine {
	
	private String nom;
	private String operating_system;
	private Etat etat;
	private double disk_size;
	private double memory;
	
	
	public Machine(String nom) {
		this.nom = nom;
	}
	public Machine(String nom, String operating_system, String disk_size, String memory) {
		this.nom = nom;
		this.operating_system =operating_system;
		this.etat=Etat.inactive; 
		this.disk_size = recuperer_double(disk_size);
		this.memory = recuperer_double(memory);
		
	}
	public static double recuperer_double(String s) 
	{
		Matcher m = Pattern.compile("([0-9]+)gb").matcher(s);
		m.matches();
		return Double.parseDouble(m.group(1));
	} 
	public void start() throws MachineStateException{
		if(etat.equals(Etat.running)) throw new MachineStateException();
		else etat=Etat.running;
	};
	
	public void stop() {
		etat=Etat.stopped;
	}
	
	public double usedMemory() {return etat.equals(Etat.running)?memory:0;}
	
	public String toString() {
		return  nom + ":" + etat ;
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
		Machine other = (Machine) obj;
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

	public String getOperating_system() {
		return operating_system;
	}

	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public double getDisk_size() {
		return disk_size;
	}

	public void setDisk_size(double disk_size) {
		this.disk_size = disk_size;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	};
	
	

}
