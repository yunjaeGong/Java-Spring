package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

public class WordRegisterServiceMyAutowired {
	/*@Autowired(required = false) // Bean 존재하지 않으면 DI 하지 않음
	@Qualifier("usedDao")*/
	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;

	public WordRegisterServiceMyAutowired() {

	}

	// @Autowired
	public WordRegisterServiceMyAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already been registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}