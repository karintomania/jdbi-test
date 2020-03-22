package com.example.jdbitest.repository;

import java.util.List;

import com.example.jdbitest.entity.Employee;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@RegisterBeanMapper(Employee.class)
public interface EmployeeJdbiRepository{
	
	// 一件挿入
	// @GetGeneratedKeysをつけると結果に自動生成されたキーを返してくれる
	@GetGeneratedKeys
	// @BindBeanアノテーションでEmployeeクラスのfirstName,lastNameプロパティを
	// @SqlUpdate内のプレースホルダ(:firstName,:lastName)に紐づけている
	@SqlUpdate("insert into TBL_EMPLOYEES (first_name, last_name) values(:firstName, :lastName)")
	int insertEmployee(@BindBean Employee employee);

	// idで検索
	// こちらも@Bindアノテーションでプレースホルダと引数を紐づけている
	@SqlQuery("select * from TBL_EMPLOYEES where id = :id")
	Employee findById(@Bind("id") int id);

	// 全件選択
	// 検索結果とList<Employee>の紐付けは勝手にやってくれてる
	@SqlQuery("select * from TBL_EMPLOYEES")
	List<Employee> findAll();

}