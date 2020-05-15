package biz.board.impl;

import biz.board.BoardDTO;
import biz.board.BoardService;
import biz.common.Log4jAdvice;
import biz.common.LogAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;
    // OOP 언어에서의 횡단 관심 분리가 어려운 이유!
    // private LogAdvice log;
    // private Log4jAdvice log;
    // 결합도 증가가 불가피함.



    public BoardServiceImpl() {
        // log = new LogAdvice();
        // log = new Log4jAdvice();
    }

    @Override
    public void insertBoard(BoardDTO dto) {
        // log.printLog(); // 횡단 관심에 해당하는 로그 기능 -> 결합도 높아짐!
        // log.printLogging();
        boardDAO.insertBoard(dto);
    }

    @Override
    public void updateBoard(BoardDTO dto) {
        // log.printLog();
        // log.printLogging();
        boardDAO.updateBoard(dto);
    }

    @Override
    public void deleteBoard(BoardDTO dto) {
        // log.printLog();
        // log.printLogging();
        boardDAO.deleteBoard(dto);
    }

    @Override
    public BoardDTO getBoard(BoardDTO dto) {
        // log.printLog();
        // log.printLogging();
        return boardDAO.getBoard(dto);
    }

    @Override
    public List<BoardDTO> getBoardList(BoardDTO dto) {
        //log.printLog();
        // log.printLogging();
        return boardDAO.getBoardList(dto);
    }
}
