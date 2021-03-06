package cn.itcast.jk.service;

import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.utils.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by WEYLAN on 2017/7/12.
 */
public interface DeptService {

    //查询所有，带条件查询
    List<Dept> find(String hql, Class<Dept> entityClass, Object[] params);

    //获取一条记录
    Dept get(Class<Dept> entityClass, Serializable id);

    //分页查询，将数据封装到一个page分页工具类对象
    Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params);

    //新增和修改保存
    void saveOrUpdate(Dept entity);

    //批量新增和修改保存
    void saveOrUpdateAll(Collection<Dept> entitys);

    //单条删除，按id
    void deleteById(Class<Dept> entityClass, Serializable id);

    //批量删除
    void delete(Class<Dept> entityClass, Serializable[] ids);


}
