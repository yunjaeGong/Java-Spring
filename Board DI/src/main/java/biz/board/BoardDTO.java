package biz.board;

import java.sql.Timestamp;

public class BoardDTO {
    // Data Transfer Object - 레이어와 레이어 사이에서 연관 데이터를 한꺼번에 주고 받음
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Timestamp regDate;
    private int cnt;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "board.BoardDTO [seq=" + seq + ", title=" + title + ", writer= " + writer
                + ", content= " + content + ", regDate= " + regDate + ", cnt=" + cnt +"]";
    }
}
