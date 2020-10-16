package com.example.weekopk.dao;

import com.example.weekopk.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long>{
    public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId);
}
