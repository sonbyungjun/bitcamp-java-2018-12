package com.eomcs.mybatis;

import org.apache.ibatis.session.SqlSession;

public class TransactionManager {
  SqlSessionFactoryProxy sqlSessionFactoryProxy;
  
  public TransactionManager(SqlSessionFactoryProxy sqlSessionFactoryProxy) {
    this.sqlSessionFactoryProxy = sqlSessionFactoryProxy;
  }
  
  public void beginTransaction() {
    sqlSessionFactoryProxy.prepareForTransaction();
  }
  
  public void commit() {
    SqlSession sqlSession = sqlSessionFactoryProxy.openSession();
    sqlSession.commit();
    sqlSessionFactoryProxy.releaseForTransaction();
  }
  
  public void rollback() {
    SqlSession sqlSession = sqlSessionFactoryProxy.openSession();
    sqlSession.rollback();
    sqlSessionFactoryProxy.releaseForTransaction();
  }
}
