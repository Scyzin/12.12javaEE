package test;

import service.AccountService;
import service.impl.AccountServiceImpl;


public class TestTransfer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AccountService as = new AccountServiceImpl();
		as.transfer("aaa", "bbb", +200);
	}

}
