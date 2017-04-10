/**
 * 
 */
package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import example.com.webservice.generatedwsdl.GetEmployeeRequest;
import example.com.webservice.generatedwsdl.GetEmployeeResponse;

/**
 * @author TCS
 *
 */
@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://com.example/webservice/generatedwsdl";

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeEndpoint(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		response.setEmployee(employeeRepository.findEmployee(request.getName()));

		return response;
	}
}
