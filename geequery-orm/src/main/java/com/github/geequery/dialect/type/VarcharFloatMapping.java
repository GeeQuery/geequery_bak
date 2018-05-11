package com.github.geequery.dialect.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.geequery.dialect.DatabaseDialect;
import jef.database.jdbc.result.IResultSet;

public class VarcharFloatMapping extends AColumnMapping{
	public Object jdbcSet(PreparedStatement st, Object value, int index, DatabaseDialect session) throws SQLException {
		if(value==null){
			st.setNull(index, java.sql.Types.VARCHAR);
		}else{
			st.setString(index, value.toString());
		}
		return value;
	}

	public int getSqlType() {
		return java.sql.Types.VARCHAR;
	}

	public Object jdbcGet(IResultSet rs, int n) throws SQLException {
		String obj=rs.getString(n);
		if(obj==null || obj.length()==0)return null;
		return Float.parseFloat(obj);
	}

	@Override
	protected String getSqlExpression(Object value, DatabaseDialect profile) {
		return super.wrapSqlStr(String.valueOf(value));
	}

	@Override
	protected Class<?> getDefaultJavaType() {
		return Float.class;
	}

	@Override
	public void jdbcUpdate(ResultSet rs, String columnIndex, Object value, DatabaseDialect dialect) throws SQLException {
		rs.updateString(columnIndex, value.toString());
	}
}
