package com.soondae.camp.favorite.entity;

import com.soondae.camp.board.entity.Board;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "tbl_favorite")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;
    @Builder.Default
    private boolean fstatus = false;

    @ManyToOne
    private Board board;

    public void changeFavorite(boolean fstatus) {
        this.fstatus = fstatus;
    }

}
