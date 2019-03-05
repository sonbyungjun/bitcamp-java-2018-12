package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.util.ConnectionFactory;

public class PhotoBoardDaoImpl implements PhotoBoardDao {
  
  @Override
  public List<PhotoBoard> findAll() {
    Connection con = ConnectionFactory.create();
    try (PreparedStatement stmt = con.prepareStatement(
        "select photo_id,titl,cdt,vw_cnt,lesson_id from lms_photo"
            + " order by photo_id desc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<PhotoBoard> list = new ArrayList<>();

      while (rs.next()) {
        PhotoBoard photoboard = new PhotoBoard();
        photoboard.setNo(rs.getInt("photo_id"));
        photoboard.setTitle(rs.getString("titl"));
        photoboard.setCreatedDate(rs.getDate("cdt"));
        photoboard.setViewCount(rs.getInt("vw_cnt"));
        photoboard.setLessonNo(rs.getInt("lesson_id"));
        list.add(photoboard);
      }
      return list;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
  
  @Override
  public void insert(PhotoBoard photoBoard) {
    
    Connection con = ConnectionFactory.create();
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo(titl, lesson_id) values(?,?)",
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getLessonNo());
      stmt.executeUpdate();
      
      try (ResultSet rs = stmt.getGeneratedKeys()) {
        rs.next();
        photoBoard.setNo(rs.getInt(1));
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public PhotoBoard findByNo(int no) {
    Connection con = ConnectionFactory.create();
    try {
      try (PreparedStatement stmt = con.prepareStatement(
          "update lms_photo set vw_cnt = vw_cnt + 1 where photo_id = ?")) {
        stmt.setInt(1, no);
        stmt.executeUpdate();
      }

      try (PreparedStatement stmt = con.prepareStatement(
          "select photo_id,titl,cdt,vw_cnt,lesson_id from lms_photo where photo_id = ?")) {

        stmt.setInt(1, no);
        try (ResultSet rs = stmt.executeQuery()) { 
          if (!rs.next())
            return null;

          PhotoBoard photoboard = new PhotoBoard();
          photoboard.setNo(rs.getInt("photo_id"));
          photoboard.setTitle(rs.getString("titl"));
          photoboard.setCreatedDate(rs.getDate("cdt"));
          photoboard.setViewCount(rs.getInt("vw_cnt"));
          photoboard.setLessonNo(rs.getInt("lesson_id"));
          return photoboard;
        }
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public int update(PhotoBoard photoboard) {
    Connection con = ConnectionFactory.create();
    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_photo set titl = ? where photo_id = ?")) {

      stmt.setString(1, photoboard.getTitle());
      stmt.setInt(2, photoboard.getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    Connection con = ConnectionFactory.create();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo where photo_id = ?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
  
}
