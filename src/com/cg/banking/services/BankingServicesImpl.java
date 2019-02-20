package com.cg.banking.services;
import java.util.List;
import javax.security.auth.login.AccountNotFoundException;
import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAOImpl;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements  BankingServices{
	AccountDAOImpl service = new AccountDAOImpl();
	Transaction transaction = new Transaction();
	Account account;
	@Override
	public Account openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		Account account = new Account(accountType,initBalance);
		account = service.save(account);
		return account; 
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		return service.findAll();
	}


	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		account=service.findOne(accountNo);
		if(account==null)
			throw new AccountNotFoundException();
		return account;
	}
	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account=service.findOne(accountNo);
		float finalAmount = account.getAccountBalance()+amount;
		account.setAccountBalance(finalAmount);
		//account.transactions.add(transaction);
		return finalAmount;
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account = service.findOne(accountNo);
		if(pinNumber==account.getPinNumber())
		{account=service.findOne(accountNo);
		float finalAmount = account.getAccountBalance()-amount;
		account.setAccountBalance(finalAmount);
		return finalAmount;}
		else
			throw new InvalidPinNumberException();
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		depositAmount(accountNoTo, transferAmount);
		return true;
	}





	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		// TODO Auto-generated method stub
		return null;
	}

}