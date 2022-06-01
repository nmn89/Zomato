package zomatoapp.rowmapperimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zomatoapp.model.Owner;

public class OwnerRowMapperImpl implements RowMapper<Owner>{

	public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
		Owner owner = new Owner();
		owner.setId(rs.getInt("id"));
		owner.setOwnerName(rs.getString("ownerName"));
		owner.setMobileNo(rs.getLong("mobileNo"));
		owner.setEmail(rs.getString("email"));
		owner.setPassword(rs.getString("password"));
		return owner;
	}

}
