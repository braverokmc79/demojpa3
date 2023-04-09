package com.example.demojap3.post;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.example.demojap3.post.QPost.post;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository{

    private final JPAQueryFactory queryFactory;


    @Override
    public Page<PostDto> searchPostList(PostSearchCondition condition, Pageable pageable) {
        List<PostDto> postDtoList = queryFactory.select(
                        new QPostDto(post.id, post.title, post.content, post.created)
                ).where(titleEq(condition.getTitle()),
                        contentEq(condition.getContent())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .from(post).fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(post.count())
                .from(post)
                .where(titleEq(condition.getTitle()),
                        contentEq(condition.getContent())
                );

        return PageableExecutionUtils.getPage(postDtoList, pageable, countQuery::fetchOne);
    }


    private BooleanExpression titleEq(String title) {
        return hasText(title) ?  post.title.eq(title) :null;
    }


    private BooleanExpression contentEq(String content) {
        return hasText(content) ? post.content.eq(content) :null;
    }

}
