package com.eomcs.mybatis;

import java.sql.Connection;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class SqlSessionFactoryProxy implements SqlSessionFactory{

  SqlSessionFactory original;

  ThreadLocal<SqlSession> sqlSessionLocal = new ThreadLocal<>();

  public SqlSessionFactoryProxy(SqlSessionFactory original) {
    this.original = original;
  }
  
  public void prepareForTransaction() {
    SqlSession sqlSession = this.openSession(false);
    SqlSessionProxy sqlSessionProxy = new SqlSessionProxy(sqlSession, true);
    sqlSessionLocal.set(sqlSessionProxy);
  }
  
  public void releaseForTransaction() {
    try {
    SqlSessionProxy sqlSessionProxy = (SqlSessionProxy) sqlSessionLocal.get();
    sqlSessionLocal.remove();
    sqlSessionProxy.setUseTransaction(false);
    sqlSessionProxy.close();
    } catch(Exception e) {
      
    }
  }

  public SqlSession openSession() {
    SqlSession sqlSession = sqlSessionLocal.get();
    if (sqlSession != null)
      return sqlSession;
    else
      return original.openSession(true);
  }

  public SqlSession openSession(boolean autoCommit) {
    return original.openSession(autoCommit);
  }

  public SqlSession openSession(Connection connection) {
    return original.openSession(connection);
  }

  public SqlSession openSession(TransactionIsolationLevel level) {
    return original.openSession(level);
  }

  public SqlSession openSession(ExecutorType execType) {
    return original.openSession(execType);
  }

  public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
    return original.openSession(execType, autoCommit);
  }

  public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
    return original.openSession(execType, level);
  }

  public SqlSession openSession(ExecutorType execType, Connection connection) {
    return original.openSession(execType, connection);
  }

  public Configuration getConfiguration() {
    return original.getConfiguration();
  }

}
