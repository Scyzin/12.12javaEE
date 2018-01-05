package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.C3P0Util;
import util.ManagerThreadLocal;


import dao.AccountDao;
import domain.Account;

public class AccountDaoImpl implements AccountDao {


	public void updateAccount(String fromname, String toname, double money) throws Exception {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update account set money=money-? where name=?",money,fromname);
		qr.update("update account set money=money+? where name=?",money,toname);
	}

	public void updateAccout(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(),"update account set money=? where name=?",account.getMoney(),account.getName());
	
	}

	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		return qr.query(ManagerThreadLocal.getConnection(),"select * from account where name=?", new BeanHandler<Account>(Account.class),name);
	}

}
