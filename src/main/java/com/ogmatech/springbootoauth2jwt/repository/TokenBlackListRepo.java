package com.ogmatech.springbootoauth2jwt.repository;

import com.ogmatech.springbootoauth2jwt.model.TokenBlackList;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TokenBlackListRepo extends Repository<TokenBlackList, Long> {

    Optional<TokenBlackList> findByJti(String jti);
    List<TokenBlackList> queryAllByUserIdAndIsBlackListedTrue(Long userId);
    void save(TokenBlackList tokenBlackList);
    List<TokenBlackList> deleteAllByUserIdAndExpiresBefore(Long userId, Long date);
}
