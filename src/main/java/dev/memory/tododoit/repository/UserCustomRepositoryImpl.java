package dev.memory.tododoit.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.memory.tododoit.entity.Deleted;
import dev.memory.tododoit.entity.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {

    private final JPAQueryFactory queryFactory;

    /**
     * 계정이 존재여부
     * @param accountId: 사용자 계정
     * @return 계정 존재:true / 계정 미존재:false
     */
    @Override
    public Boolean existsNotDeletedByAccountId(String accountId) {
        Integer fetchOne = queryFactory.selectOne()
                .from(QUser.user)
                .where(
                        QUser.user.accountId.eq(accountId)
                                .and(QUser.user.isDeleted.eq(Deleted.N))

                )
                .fetchFirst();
        return fetchOne != null;
    }

    /**
     * 이메일 존재여부
     * @param email 이메일
     * @return 이메일 존재:true / 이메일 미존재:false
     */
    @Override
    public Boolean existsNotDeletedByEmail(String email) {
        Integer fetchOne = queryFactory.selectOne()
                .from(QUser.user)
                .where(
                        QUser.user.email.eq(email)
                                .and(QUser.user.isDeleted.eq(Deleted.N))

                )
                .fetchFirst();
        return fetchOne != null;
    }
}
