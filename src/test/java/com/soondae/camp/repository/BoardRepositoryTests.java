package com.soondae.camp.repository;

import com.soondae.camp.board.entity.Board;
import com.soondae.camp.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1, 100).forEach(value -> {
            Board board = Board.builder()
                    .btitle("맥북프로 팝니다.")
                    .bcontent("공짜로 드립니다.")
                    .bprice("공짜라니까")
                    .bcategory("팝니다")
                    .bstate(false)
                    .bmodDate(LocalDateTime.now())
                    .bregDate(LocalDateTime.now())
                    .build();
            boardRepository.save(board);
        });
    }

    @Test
    public void testUpdate(){
        Optional<Board> board = boardRepository.findById(10L);

        log.info(board);

        board.ifPresent(board1 -> {
            board1.changeValue("맥북 공짜 아닙니다.","2500000","맥북","팝니다.");
            boardRepository.save(board1);
        });

    }

    @Test
    public void testDelete(){
        boardRepository.deleteById(55L);
    }



}
