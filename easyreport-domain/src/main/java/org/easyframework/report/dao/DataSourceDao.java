﻿package org.easyframework.report.dao;

import java.sql.DriverManager;
import java.util.List;

import org.easyframework.report.data.PageInfo;
import org.easyframework.report.data.criterion.Restrictions;
import org.easyframework.report.data.jdbc.BaseDao;
import org.easyframework.report.entity.DataSource;
import org.springframework.stereotype.Repository;

/**
 * DataSourceDao提供数据源配置信息表表(datasource)的相关数据访问操作的类。
 * 
 * @author Tom Deng
 */
@Repository
public class DataSourceDao extends BaseDao<DataSource> {

	public DataSourceDao() {
		super(DataSource.EntityName, DataSource.Id);
	}

	public boolean testConnection(String url, String pass, String user) {
		try {
			DriverManager.getConnection(url, user, pass);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<DataSource> queryByPage(String createUser, PageInfo page) {
		String condition = Restrictions.equal(DataSource.CreateUser, "?").toString();
		Object[] args = new Object[] { createUser };
		return this.query(condition, page, args);
	}
}