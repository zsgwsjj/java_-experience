//package com.zsgwsjj.jiang.comm.service.impl;
//
//import com.zsgwsjj.jiang.comm.dao.ITwitterDao;
//import com.zsgwsjj.jiang.comm.service.ITwitterService;
//import com.zsgwsjj.jiang.model.Twitter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author : jiang
// * @time : 2018/1/31 19:23
// */
//@Service("twitterService")
//public class TwitterService implements ITwitterService {
//
//    @Autowired
//    private  ITwitterDao twitterDao;
//
//    @Override
//    public void reportNewTwitter(Twitter twitter) {
//        twitterDao.insertNewTwitter(twitter);
//    }
//
//    @Override
//    public List<Twitter> getTwitters(long startTime, long endTime, int uid) {
//        return twitterDao.queryTwitters(uid, startTime, endTime);
//    }
//}
