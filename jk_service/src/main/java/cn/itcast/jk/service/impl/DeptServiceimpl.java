package cn.itcast.jk.service.impl;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by WEYLAN on 2017/7/12.
 */
public class DeptServiceimpl implements DeptService {

    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {

        return baseDao.find(hql,entityClass,params);
    }

    @Override
    public Dept get(Class<Dept> entityClass, Serializable id) {

        return baseDao.get(entityClass,id);
    }

    @Override
    public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
        return baseDao.findPage(hql,page,entityClass,params);
    }

    @Override
    public void saveOrUpdate(Dept entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void saveOrUpdateAll(Collection<Dept> entitys) {
        baseDao.saveOrUpdate(entitys);
    }

    @Override
    public void deleteById(Class<Dept> entityClass, Serializable id) {
        baseDao.deleteById(entityClass,id);
    }

    @Override
    public void delete(Class<Dept> entityClass, Serializable[] ids) {
        baseDao.delete(entityClass,ids);
    }
}
