package com.eomcs.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DaoFactory {

  SqlSessionFactory sqlSessionFactory;

  public DaoFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @SuppressWarnings("unchecked")
  public <T> T create(Class<T> type) {
    return (T) Proxy.newProxyInstance(
        type.getClassLoader(), 
        new Class[] {type}, 
        invocationHandler);
  }

  InvocationHandler invocationHandler = 
      (Object proxy, Method method, Object[] args) -> {

        String sqlId = String.format("%s.%s"
            , proxy.getClass().getInterfaces()[0].getName(),
            method.getName());

        Class<?> returnType = method.getReturnType();

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

          System.out.println(sqlId + "의 SQL을 실행한다.");

          if (returnType == List.class) {
            if(args == null)
              return sqlSession.selectList(sqlId);
            else
              return sqlSession.selectList(sqlId, args[0]);

          } else if (returnType == int.class) {
            if (args == null)
              return sqlSession.update(sqlId);
            else
              return sqlSession.update(sqlId, args[0]);

          } else {
            if (args == null)
              return sqlSession.selectOne(sqlId);
            else
              return sqlSession.selectOne(sqlId, args[0]);
          }
        } //try
      };
}

