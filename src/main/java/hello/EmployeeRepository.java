/**
 * 
 */
package hello;


import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import example.com.webservice.generatedwsdl.Employee;
import example.com.webservice.generatedwsdl.Role;

/**
 * @author TCS
 *
 */
@Component
public class EmployeeRepository {
	private static final List<Employee> employee = new ArrayList<Employee>();

	@PostConstruct
	public void initData() {
		Employee e1 = new Employee();
		e1.setName("arun");
		e1.setId(535141);
		e1.setDesignation("ITA");
		e1.setRole(Role.DEVELOPER);

		employee.add(e1);

		Employee e2 = new Employee();
		e2.setName("madan");
		e2.setId(535141);
		e2.setDesignation("ASE");
		e2.setRole(Role.TESTER);

		employee.add(e2);

		
	}

	public Employee findEmployee(String name) {
		Assert.notNull(name);

		Employee result = null;

		for (Employee employ : employee) {
			if (name.equals(employ.getName())) {
				result = employ;
			}
		}

		return result;
	}
}
