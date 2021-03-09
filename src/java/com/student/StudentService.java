
package com.student;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author abhi
 */
@Path("/Service")
public class StudentService {
    StudentDao Stu=new StudentDao();
    @GET
    @Path("/StudentList")
    //@Produces(MediaType.APPLICATION_JSON)
   // @Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_XML)
    public List<Student> displayStudent(){
        try {
            return Stu.fetchAllStudentList();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @POST
    @Path("/addStudent")
    @Produces(MediaType.APPLICATION_XML)
    public String addStudent(@FormParam("student_no") int student_no,
            @FormParam("name") String name,@FormParam("dob") String dob,@FormParam("doj") String doj,
            @Context HttpServletResponse servletResponse) throws ClassNotFoundException, SQLException{
        return Stu.addstudent(student_no,name,dob,doj);
    }
}

