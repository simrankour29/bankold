package com.cg.banking.daoservices;
import java.util.ArrayList;
import java.util.List;
import com.cg.banking.beans.Account;
import com.cg.banking.util.BankingDBUtil;

public  class AccountDAOImpl implements AccountDAO{

	@Override
	public Account save(Account account) {
		account.setAccountNo(BankingDBUtil.getACCOUNT_NUMBER());
		account.setAccountStatus(BankingDBUtil.getACCOUNT_STATUS());
		account.setPinNumber(BankingDBUtil.getPIN_NUMBER());
		BankingDBUtil.accountDetails.put(account.getAccountNo(),account);
		return account;
	}

	@Override
	public boolean update(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findOne(long accountNo) {
		Account account =BankingDBUtil.accountDetails.get(accountNo);
		return account;
	}

	@Override
	public List<Account> findAll() {
		ArrayList<Account> account=new ArrayList<>(BankingDBUtil.accountDetails.values());
		return account;
	}


}