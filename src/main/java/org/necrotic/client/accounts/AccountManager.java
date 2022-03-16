package org.necrotic.client.accounts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.necrotic.client.RSInterface;
import org.necrotic.client.Signlink;

/**
 * Manages loading/saving/adding/removing of saved accounts
 * @author Tedi / Gabbe
 */
public class AccountManager {

	private final String FILE_NAME = "accounts.dat";
	private Account[] accounts = new Account[5];
	private int totalAccounts;

	/**
	 * Constructor for the account manager.
	 * Loads all the saved accounts into the array list
	 */
	public AccountManager() {
		if(saveExists()) {
			load();
		}
	}

	/**
	 * Adds an account to the save list
	 * @param account The account to add
	 */
	public void addAccount(Account account, boolean save) {
		int box = getEmptyBox();
		if(box == -1) {
			return;
		}
		account.setBox(box);
		accounts[account.getBox()] = account;
		totalAccounts++;
		updateInterface();
		if(save) {
			save();
		}
	}

	/**
	 * Removes an account from the save list
	 * @param account The account to remove
	 **/
	public void removeAccount(Account account, boolean save) {
		accounts[account.getBox()] = null;
		totalAccounts--;
		updateInterface();
		if(save) {
			save();
		}
	}
	
	public void updateInterface() {
		ArrayList<Account> accountList = new ArrayList<Account>();
		for(Account acc : accounts) {
			if(acc == null)
				continue;
			accountList.add(acc);
		}
		RSInterface.getCustomInterfaces().buildPlayerMenu(accountList);	
	}

	private boolean saveExists() {
		File file = new File(Signlink.getSettingsDirectory() + "/accounts.dat");
		return file.exists();
	}

	private void load() {
		try {
			FileInputStream fin = new FileInputStream(Signlink.getSettingsDirectory() + "/" + FILE_NAME);
			ObjectInputStream oin = new ObjectInputStream(fin);
			totalAccounts = (int) oin.readObject();
			accounts = (Account[]) oin.readObject();
			fin.close();
			oin.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			FileOutputStream fout = new FileOutputStream(Signlink.getSettingsDirectory() + "/" + FILE_NAME);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(totalAccounts);
			oout.writeObject(accounts);
			oout.close();
			fout.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Account getAccount(String username) {
		for(Account acc : accounts) {
			if(acc == null)
				continue;
			if(acc.getUsername().equals(username)) {
				return acc;
			}
		}
		return null;
	}

	public int getEmptyBox() {
		int index = -1;
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i] == null) {
				index = i;
				break;
			}
		}
		return index;
	}

	public Account[] getAccounts() {
		return accounts;
	}
}
