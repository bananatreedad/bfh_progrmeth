package ch.bananenbaum.bbfinanz.model;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

	private ArrayList<Account> accountList = new ArrayList<>();;
	
	public Model() {
		accountList.add(new Account("Privatkonto"));
		accountList.add(new Account("Sparkonto"));
		accountList.add(new Account("Ferienkonto"));
	}
	
	public ArrayList<Account> getAccountList() {
		return this.accountList;
	}
	
	public void deleteAccount(Account account) {
		this.accountList.remove(account);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void addAccount(String name) {
		accountList.add(new Account(name));
		
		this.setChanged();
		this.notifyObservers();
	}
}
