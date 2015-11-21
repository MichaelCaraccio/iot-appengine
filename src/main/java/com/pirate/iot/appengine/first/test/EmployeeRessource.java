package com.pirate.iot.appengine.first.test;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * TODO
 * Exemple class, can be removed before release version !
 */
@Path("/hr/")
public class EmployeeRessource {

    /**
     * @Access http://localhost:8080/rest/hr/employee/deruazvincent@gmail.com
     * @param email
     * @return
     */
    @GET
    @Produces("application/json")
    @Path("/employee/{employeeEmail}/")
    public Employee getEmployee(@PathParam ("employeeEmail") String email) {
        //dummy code
        Employee emp = new Employee();
        emp.setEmail(email);
        emp.setFirstName("John");
        emp.setLastName("Doe");

        return emp;
    }
}