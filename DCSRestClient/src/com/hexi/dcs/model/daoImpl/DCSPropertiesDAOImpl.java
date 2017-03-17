package com.hexi.dcs.model.daoImpl;

import com.hexi.dcs.model.dao.DCSPropertiesDAO;
import com.hexi.dcs.model.pojo.DCSProperties;
import com.hexi.dcs.model.util.SQLConstants;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DCSPropertiesDAOImpl implements DCSPropertiesDAO {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
   

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    
    @Override
    public List<DCSProperties> retrieveDCSProperties() {
     List<DCSProperties> dcsProperties = jdbcTemplate.query(SQLConstants.SQL_GET_DCS_PROPERTIES,new BeanPropertyRowMapper(DCSProperties.class));
        return dcsProperties;
    }
}
