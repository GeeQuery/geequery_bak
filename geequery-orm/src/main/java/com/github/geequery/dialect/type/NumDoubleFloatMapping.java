package com.github.geequery.dialect.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.geequery.dialect.DatabaseDialect;
import jef.database.jdbc.result.IResultSet;

public class NumDoubleFloatMapping extends AColumnMapping{
	public Object jdbcSet(PreparedStatement st, Object value, int index, DatabaseDialect session) throws SQLException {
		if(value==null){
			st.setNull(index, java.sql.Types.DOUBLE);
		}else{
			st.setDouble(index, ((Number)value).floatValue());
		}
		return value;
	}

	public int getSqlType() {
		return java.sql.Types.DOUBLE;
	}

	@Override
	protected String getSqlExpression(Object value, DatabaseDialect profile) {
		return value.toString();
	}
	
	public Object jdbcGet(IResultSet rs, int n) throws SQLException {
		Object obj=rs.getObject(n);
		if(obj==null)return null;
		if(obj instanceof Float)return obj;
		return ((Number)obj).floatValue();
	}

	@Override
	protected Class<?> getDefaultJavaType() {
		return Float.class;
	}

	@Override
	public void jdbcUpdate(ResultSet rs, String columnIndex, Object value, DatabaseDialect dialect) throws SQLException {
		rs.updateDouble(columnIndex, ((Number)value).floatValue());
	}
}
