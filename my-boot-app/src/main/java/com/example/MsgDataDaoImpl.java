package com.example;

import java.util.List;

import javax.persistence.EntityManager;

public class MsgDataDaoImpl implements MsgDataDao<MsgDataDao> {
	
	private EntityManager entityManager;
	
	public MsgDataDaoImpl() {
		super();
	}
	
	public MsgDataDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<MsgData> getAll() {
		return entityManager.createQuery("from MsgData").getResultList();
	}

	public MsgData findById(long id) {
		return (MsgData)entityManager.createQuery("from MsgData where id = " + id).getSingleResult();
	}

}
