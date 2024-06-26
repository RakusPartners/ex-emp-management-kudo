package com.example.springexam.repository;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.springexam.domain.Administrator;

/**
 * 管理者のリポジトリクラス
 */

@Repository
public class AdministratorRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 管理者情報のローマッパー
     *
     * @param Admin 管理者情報
     * @return 管理者情報
     */
    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		// ここに結果の処理を書く
		Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));
		return administrator;
	};

    /**
     * 管理者情報を挿入する
     *
     * @param Admin 管理者情報
     * @return なし
     */
    public void insert(Administrator administrator) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
        String insertSql = "INSERT INTO administrators (name, mail_address, password) VALUES (:name, :mailAddress, :password);";
        template.update(insertSql, param);
    }

    /**
     *  メールアドレスとパスワードから管理者情報を取得する(1 件も存在しない場合は null を返す※)。
     *
     * @param Admin 管理者情報
     * @return 管理者情報
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
        String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address=:mailAddress AND password=:password;";
        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
        List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administratorList.size() == 0) {
            return null;
        }
        return administratorList.get(0);
    }
    
}
