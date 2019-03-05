package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.util.ConnectionFactory;

public class PhotoFileDaoImpl implements PhotoFileDao {

  @Override
  public List<PhotoFile> findByPhotoBoardNo(int photoBoardNo) {
    Connection con = ConnectionFactory.create();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "select photo_file_id,photo_id,file_path"
            + " from lms_photo_file"
            + " where Photo_id = ?"
            + " order by photo_file_id asc");) {

      stmt.setInt(1, photoBoardNo);

      try (ResultSet rs = stmt.executeQuery()) {

        ArrayList<PhotoFile> list = new ArrayList<>();

        while (rs.next()) {
          PhotoFile photofile = new PhotoFile();
          photofile.setNo(rs.getInt("photo_file_id"));
          photofile.setPhotoBoardNo(rs.getInt("photo_id"));
          photofile.setFilePath(rs.getString("file_path"));
          list.add(photofile);
        }
        return list;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  
  @Override
  public void insert(PhotoFile photoFile) {
    Connection con = ConnectionFactory.create();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_photo_file(file_path,photo_id) values(?,?)")) {

      stmt.setString(1, photoFile.getFilePath());
      stmt.setInt(2, photoFile.getPhotoBoardNo());
      stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int deleteByPhotoBoardNo(int photoBoardNo) {
    Connection con = ConnectionFactory.create();
    
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_photo_file where photo_id = ?")) {

      stmt.setInt(1, photoBoardNo);

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
   
}
