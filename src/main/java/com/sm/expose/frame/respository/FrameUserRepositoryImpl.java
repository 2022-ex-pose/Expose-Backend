package com.sm.expose.frame.respository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sm.expose.frame.domain.FrameUser;
import com.sm.expose.frame.domain.QFrameUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FrameUserRepositoryImpl implements FrameUserRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public FrameUser findByFrameUser(Long frameId, Long userId) {
        return (FrameUser) queryFactory.from(QFrameUser.frameUser)
                .where(QFrameUser.frameUser.frame.frameId.eq(frameId).and(QFrameUser.frameUser.user.userId.eq(userId)))
                .fetchOne();
    }

    @Override
    public List<FrameUser> findByFrame(Long frameId) {
        return (List<FrameUser>) queryFactory.from(QFrameUser.frameUser)
                .where(QFrameUser.frameUser.frame.frameId.eq(frameId))
                .fetch();
    }

    @Override
    public List<FrameUser> findByUser(Long userId){
        return (List<FrameUser>) queryFactory.from(QFrameUser.frameUser)
                .where(QFrameUser.frameUser.user.userId.eq(userId))
                .fetch();
    }

    @Override
    public List<FrameUser> findByOtherUser(Long frameId, Long userId){
        return (List<FrameUser>) queryFactory.from(QFrameUser.frameUser)
                .where(QFrameUser.frameUser.frame.frameId.eq(frameId).and(QFrameUser.frameUser.user.userId.ne(userId)))
                .fetch();
    }

    @Override
    public List<FrameUser> findByFrameUserLike(Long userId){
        return (List<FrameUser>) queryFactory.from(QFrameUser.frameUser)
                .where(QFrameUser.frameUser.user.userId.eq(userId).and(QFrameUser.frameUser.likeState.eq(true)))
                .fetch();
    }
}
