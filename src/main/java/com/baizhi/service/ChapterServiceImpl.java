package com.baizhi.service;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ChapterServiceImpl implements ChapterService {
  @Autowired
  private ChapterDao chapterDao;

    @Override
    public void insertChapter(Chapter chapter) {
      SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
      String format = sdf.format(new Date());
      int abc=Integer.parseInt(format);
      chapter.setId(abc);
      chapterDao.insert(chapter);

    }
}
