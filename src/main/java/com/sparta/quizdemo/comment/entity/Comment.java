package com.sparta.quizdemo.comment.entity;

import com.sparta.quizdemo.comment.dto.CommentRequestDto;
import com.sparta.quizdemo.common.entity.TimeStamped;
import com.sparta.quizdemo.product.entity.Product;
import com.sparta.quizdemo.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Setter
@Getter
@NoArgsConstructor
@DynamicInsert //INSERT를 실행할 때 해당 컬럼이 null일 경우 insert에서 제외된다.
@Entity
@Table(name = "comment")
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false, name = "comment_content")
    private String content;

    //기본값 0으로 설정
    @ColumnDefault("0")
    @Column(nullable = false, name = "comment_likeCnt")
    private int likeCnt;

    //기본값 false로 설정, 좋아요 판별하는 컬럼
    @ColumnDefault("false")
    @Column(name = "commentlike_bool")
    private boolean bool;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Comment(CommentRequestDto commentRequestDto, User user) {
        this.content = commentRequestDto.getComment_content();
        this.user = user;
    }

    public void update(CommentRequestDto commentRequestDto, User user) {
        this.content = commentRequestDto.getComment_content();
        this.user = user;
    }
}