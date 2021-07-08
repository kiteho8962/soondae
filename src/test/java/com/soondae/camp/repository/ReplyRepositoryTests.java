package com.soondae.camp.repository;

import com.soondae.camp.board.entity.Board;
import com.soondae.camp.reply.entity.Reply;
import com.soondae.camp.reply.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1, 500).forEach(value -> {
            long bno = (int) (Math.random()*100)+1;
            Board board = Board.builder()
                    .bno(bno)
                    .build();
            Reply reply = Reply.builder()
                    .board(board)
                    .rtext("공짜라도 안사")
                    .build();
            replyRepository.save(reply);
        });
    }

    @Test
    public void testUpdate(){
        Optional<Reply> reply = replyRepository.findById(100L);
        reply.ifPresent(reply1 -> {
            reply1.changeReply("저 살게요...");
            replyRepository.save(reply1);
        });
    }


}