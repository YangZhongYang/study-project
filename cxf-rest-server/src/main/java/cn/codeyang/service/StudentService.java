package cn.codeyang.service;

import cn.codeyang.domain.Student;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

/**
 * @author YangZhongYang
 */
@WebService
@Path("/student")
public interface StudentService {

    @GET
    @Produces("application/xml")
    @Path("/query/{id}")
    public Student query(@PathParam("id")long id);

    @GET
    @Produces("application/json")
    @Path("/queryList/{name}")
    public List<Student> queryList(@PathParam("name")String name);
}
