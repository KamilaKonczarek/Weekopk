package com.example.weekopk.dao;

import com.example.weekopk.model.Discovery;

import java.util.List;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long>{
    List<Discovery> getAll();
}
