package com.iteacher.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteacher.news.dao.PicMapper;
import com.iteacher.news.model.Pic;
@Service
public class PicServiceImpl implements PicService {

	@Autowired
	private PicMapper picMapper;
	
	@Override
	public void addpic(Pic pic) {
		//picMapper.insert(pic);
		picMapper.insertSelective(pic);
	}

	@Override
	public int findByPic(String finalName) {
		// TODO Auto-generated method stub
		return picMapper.selectByPic(finalName);
	}
	
}
