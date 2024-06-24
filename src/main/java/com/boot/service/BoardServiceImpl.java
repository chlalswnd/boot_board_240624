package com.boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.BoardDAO;
import com.boot.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("BoardService") //인터페이스 
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<BoardDTO> list() {
		log.info("@# BoardServiceImpl list");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> list = dao.list();
		
		return list;
	}

	@Override
	public void write(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl write");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.write(param);
	}

	@Override
	public BoardDTO contentView(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl content_view");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		BoardDTO dto = dao.contentView(param);
		
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl modify");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) {
		log.info("@# BoardServiceImpl delete");
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.delete(param);
	}

}
