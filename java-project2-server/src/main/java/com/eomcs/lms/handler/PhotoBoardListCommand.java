package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardListCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardListCommand(PhotoBoardDao photoPhotoBoardDao) {
    this.photoBoardDao = photoPhotoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    List<PhotoBoard> photoPhotos = photoBoardDao.findAll();

    for (PhotoBoard photoPhoto : photoPhotos) {
      response.println(
          String.format("%3d, %-20s, %s, %d, %d", 
              photoPhoto.getNo(),
              photoPhoto.getTitle(), 
              photoPhoto.getCreatedDate(), 
              photoPhoto.getViewCount(), 
              photoPhoto.getLessonNo()));
    }
  }

}
