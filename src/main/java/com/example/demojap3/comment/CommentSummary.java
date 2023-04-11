package com.example.demojap3.comment;

public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

    /**
     * Open Projection 방법
     * @return

     @Value("#{target.up + ' ' +target.down}")
     String getVotes();


     Hibernate:
     select
         c1_0.comment_id,
         c1_0.best,
         c1_0.comment,
         c1_0.down,
         c1_0.post_id,
         c1_0.up
     from
         comment c1_0
     where
        c1_0.post_id=?

     호출시
     ====================================
        10 1
     ====================================

     =====> 아래 같은 메서드 방법으로 커스텀화 되어 최적화된 쿼리로 출력 가능
     */


    default String getVotes(){
        return getUp() + " " +getDown();
    }

    /** ★ ★ ★최적화 되어 쿼리 원하는 것만 출력
     *     select
     *         c1_0.comment,
     *         c1_0.up,
     *         c1_0.down
     *     from
     *         comment c1_0
     *     where
     *         c1_0.post_id=?
     */


}
