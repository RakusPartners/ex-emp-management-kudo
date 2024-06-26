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
import com.example.springexam.domain.Employee;

/**
 * 従業員のリポジトリクラス
 */

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 従業員情報のローマッパー
     *
     * @param Admin 従業員情報
     * @return 従業員情報
     */
    private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
		// ここに結果の処理を書く
		Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setImage(rs.getString("image"));
        employee.setGender(rs.getString("gender"));
        employee.setHireDate(rs.getDate("hire_date"));
        employee.setMailAddress(rs.getString("main_address"));
        employee.setZipCode(rs.getString("zip_code"));
        employee.setAddress(rs.getString("address"));
        employee.setTelephone(rs.getString("telephone"));
        employee.setSalary(rs.getInt("salary"));
        employee.setCharacteristics(rs.getString("characteristics"));
        employee.setDependentsCount(rs.getInt("dependents_count"));
		return employee;
	};

    /**
     * 従業員⼀覧情報を⼊社⽇順(降順)で取得する(従業員が存在しない場合はサイズ 0件の従業員⼀覧を返す)
     *
     * @param Admin 従業員情報
     * @return 従業員一覧
     */
    public List<Employee> findAll() {
		String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees ORDER BY hire_date DESC;";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER); 
		return employeeList;
	}

    /**
     * 主キーから従業員情報を取得する(従業員が存在しない場合は Spring が⾃動的に例外を発⽣します)。
     *
     * @param Admin 従業員情報
     * @return 従業員情報
     */
    public Employee load(Integer id) {
		String sql = "SELECT id, name, image, gender, hire_date, mail_address, zip_code, address, telephone, salary, characteristics, dependents_count FROM employees WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER); // ←ここに実行処理を書く

		return employee;
	}

    /**
     * 従業員情報を変更する
     *
     * @param Admin 従業員情報
     * @return なし
     */
    public void update(Employee employee) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
        String updateSql = "UPDATE employees SET name=:name, image=:image, gender=:gender, hire_date=:hireDate, mail_address=:mailAddress, zip_code=:zipCode, address=:address, telephone=:telephone, salary=:salary, characteristics=:characteristics, dependents_count=:dependentsCount WHERE id=:id;";
        template.update(updateSql, param);
    }
    
}
