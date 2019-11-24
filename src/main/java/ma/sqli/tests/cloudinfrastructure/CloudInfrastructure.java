package ma.sqli.tests.cloudinfrastructure;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public  class CloudInfrastructure {

	private Set<Store> stores;
	private Set<Machine> machines;
	private double globalDisk;
	private double globalMemory;
	
	 public CloudInfrastructure() 
		 {
			 stores=new LinkedHashSet<Store>();
			 machines=new LinkedHashSet<Machine>();
		 }

	 public Store findStore(Store s) {
		 List<Store> l= new LinkedList<Store>(stores);
		int i=l.indexOf(s);
		return  i==-1?null:l.get(i);
	 }
	 
	 public void createStore(String s) throws CreateStoreException
		 {
			 boolean b=stores.add(new Store(s));
			 if(!b)throw new CreateStoreException();
		 }
	
	 public void uploadDocument(String s,String... s1)
		{
			Store store=new Store(s);
			store=findStore(store);
			
			for (String string : s1) 
			{ 
				store.getDocuments().add(string);
				globalDisk+=0.100;
			}
			
		}
	 
	 public String listStores()
		{
			StringBuilder s=new StringBuilder();
			
			for (Store store : stores) {s.append(store.toString());s.append("||");}
			
			s.deleteCharAt(s.length()-1);
			s.deleteCharAt(s.length()-1);
			
			return s.toString();
		}
	 
	 public void deleteStore(String s)
		{
			Store store=new Store(s);
			store=findStore(store);
			
			double coef=store.getDocuments().size();
			globalDisk-=0.100*coef;
			
			stores.remove(store);
		}
	 public void emptyStore(String s)
		{
			Store store=new Store(s);
			store=findStore(store);
			
			double coef=store.getDocuments().size();
			globalDisk-=0.100*coef;
			
			store.getDocuments().clear();
		}
	 
	 public void createMachine(String s,String s1,String s2,String s3) {
		 
		 Machine m=new Machine(s, s1, s2, s3); 
		 
		 globalDisk+=m.getDisk_size();
		 
		 boolean b=machines.add(m);
	 }
	 public Machine findMachine(Machine c) {
		 List<Machine> l= new LinkedList<Machine>(machines);
		int i=l.indexOf(c);
		return i==-1?null:l.get(i);
	 }
	 
	 public void startMachine(String s) throws MachineStateException {
		 Machine m=new Machine(s);
		 m=findMachine(m);
		 
		 globalMemory+=m.getMemory();
		 
		 m.start();
	 }
	 public void stopMachine(String s) {
		 Machine m=new Machine(s);
		 m=findMachine(m);
		 
		 globalMemory-=m.getMemory();
		 
		 m.stop();
	 }
	 
	 public String listMachines()
		{
			StringBuilder s=new StringBuilder();
			
			for (Machine machine : machines) {s.append(machine.toString());s.append("||");}
			
			s.deleteCharAt(s.length()-1);
			s.deleteCharAt(s.length()-1);
			
			return s.toString();
		}
	 public double usedDisk(String s)
		{
		 Machine m=new Machine(s);
		 m=findMachine(m);
		 
		 Store store=new Store(s);
		 store=findStore(store);
		 
		 double usedDisk=0.0;
		 usedDisk+=	store==null?0:(store.getDocuments().size()*0.100);
		 usedDisk+=	m==null?0:(m.getDisk_size());
		 
		 return usedDisk;
		}
	 
	 public double usedMemory(String s)
		{
		 Machine m=new Machine(s);
		 m=findMachine(m);
		 
		 return m.usedMemory();
		}
	 
	 public double globalUsedDisk() {return globalDisk; }
	 
	 public double globalUsedMemory() {return globalMemory; }
		
	 
}
