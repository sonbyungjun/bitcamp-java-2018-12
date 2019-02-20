package com.eomcs.lms.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {


  public List<Board> findAll() {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from board order by no desc");
          ResultSet rs = stmt.executeQuery()) {

        ArrayList<Board> list = new ArrayList<>();

        while (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("no"));
          board.setContents(rs.getString("contents"));
          board.setCreatedDate(rs.getDate("created_date"));
          board.setViewCount(rs.getInt("view_count"));
          list.add(board);
        }

        return list;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public void insert(Board board) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "insert into board(contents) values(?)")) {

        stmt.setString(1, board.getContents());

        int count = stmt.executeUpdate();

        if (!(count == 1))
          throw new RuntimeException();

      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public Board findByNo(int no) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "select * from board where no = ?")) {

        stmt.setString(1, String.valueOf(no));

        try (ResultSet rs = stmt.executeQuery()) { 

          if (!rs.next())
            return null;

          Board board = new Board();
          board.setNo(rs.getInt("no"));
          board.setContents(rs.getString("contents"));
          board.setCreatedDate(rs.getDate("created_date"));
          board.setViewCount(rs.getInt("view_count"));

          return board;
        }
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public int update(Board board) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "update board set contents = ?, created_date = ? where no = ?")) {

        stmt.setString(1, board.getContents());
        stmt.setDate(2, board.getCreatedDate());
        stmt.setInt(3, board.getNo());

        int count = stmt.executeUpdate();

        if (!(count == 1)) 
          return 0;
        
        return 1;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public int delete(int no) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111")) {

      try (PreparedStatement stmt = con.prepareStatement(
          "delete from board where no = ?")) {

        stmt.setInt(1, no);

        int count = stmt.executeUpdate();

        if (count == 0) 
          return 0;
        
        return 1;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
