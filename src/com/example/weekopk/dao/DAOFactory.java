package com.example.weekopk.dao;

import com.example.weekopk.exception.NoSuchDbTypeException;

public abstract class DAOFactory {

    public static final int MYSQL_DAO_FACTORY = 1;

    public abstract DiscoveryDAO getDiscoveryDAO();

    public abstract UserDAO getUserDAO();

    public abstract VoteDAO getVoteDAO();

    private static DAOFactory factory;

    public static DAOFactory getDAOFactory(){
        if(factory == null){
            try {
                factory = getDAOFactory(MYSQL_DAO_FACTORY);
            } catch (NoSuchDbTypeException e) {
                e.printStackTrace();
            }
        }
        return factory;
    }

    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
        switch (type) {
            case MYSQL_DAO_FACTORY:
                return new MysqlDAOFactory();
            default:
                throw new NoSuchDbTypeException();
        }
    }
}
