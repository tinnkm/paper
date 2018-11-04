package com.tinnkm.wechat.fileupload.dao;

import org.aspectj.weaver.Iterators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author tinnkm
 * @version 1.0
 * @classname AbstractBatchDao
 * @description 批量查询
 * @date 2018/11/4 17:45
 **/
public class AbstractBatchDao<T> {
    @PersistenceContext
    protected EntityManager em;

    @Transactional
    public void batchInsert(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            em.persist(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }

    @Transactional
    public void batchUpdate(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            em.merge(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }
}
