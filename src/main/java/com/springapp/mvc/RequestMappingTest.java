package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tan on 15/5/26.
 */

@Controller
/** 1：RequestMapping注解为控制器指定可以处理那些URL的请求
 *  2：在控制器的类定义已经方法定义处都可以标注
 *  2.1 在类定义处：提供初步的请求映射信息。相对于Web应用的根目录
 *  2.2 方法处定义：提供进一步的细分银映射信息。相对于类定义处的URL，
 *      若类定义处未标注@RequestMapping,则方法处标记的URL相对于Web应用的根目录
 *  3：函数的返回值会通过试图解析器，解析为实际的物理试图，对于org.springframework.web.servlet.view.InternalResourceViewResolver视图解析器，会做如下的解析
 *  3.1：通过prefix + returnVal + 后缀suffix方式返回 得到实际的物理地址
 *
 */
@RequestMapping("/SpringMvc")
public class RequestMappingTest {

    private static final String HelloWorld = "HelloWorld";

    private static final String Call = "/Call/callInfo";

    /**
     * 可以使用method 映射请求的方式 如Post、get等
     */
    @RequestMapping(value = "/testMethodPost.acs", method = RequestMethod.POST)
    public String testMethodPost() {
        System.out.println("testMethodPost");
        return HelloWorld;
    }

    @RequestMapping(value = "/requestMappingTest.acs")
    public String requestMappingTest() {
        System.out.println("requestMappingTest");
        return HelloWorld;
    }

    /**
     * 使用 params 和headers能够更加精确的映射请求，params 和headers支持简单的表达式
     *
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders.acs", method = RequestMethod.GET, params = {"userName", "age!=10"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return HelloWorld;
    }

    @RequestMapping(value = "/pathVariable{id}.acs", method = RequestMethod.GET)
    public String pathVariable(@PathVariable("id") Integer id) {
        System.out.println("/pathVariable.acs" + id);
        return HelloWorld;
    }

    @RequestMapping(value = "/postVariable{Id}.acs", method = RequestMethod.POST)
    public String postVariable(@PathVariable("Id") Integer Id) {
        System.out.println("/postVariable.acs" + Id);
        return HelloWorld;
    }

    @RequestMapping(value = "/postVariableStr{foldIds}", method = RequestMethod.POST)
    public String postVariableStr(@PathVariable("foldIds") String foldIds) {
        System.out.println("/postVariableStr:" + foldIds);
        return Call;
    }

    @RequestMapping(value = "/testGetRest{Id}.acs", method = RequestMethod.GET)
    public String testGetRest(@PathVariable("Id") Integer id) {
        System.out.println("/testGetRest:" + id);
        return HelloWorld;
    }

    @RequestMapping(value = "/testRestPostDelete{Id}.acs", method = RequestMethod.DELETE)
    public String testRestPostDelete(@PathVariable("Id") Integer id) {
        System.out.println("/testRestPostDelete:" + id);
        return HelloWorld;
    }

    @RequestMapping(value = "/testRestPostPut{Id}.acs", method = RequestMethod.PUT)
    public String testRestPostPut(@PathVariable("Id") Integer id) {
        System.out.println("/testRestPostPut:" + id);
        return HelloWorld;
    }

    /**
     * @RequestParam 来映射请求参数
     *  value 值即请求参数的参数名
     *  required 参数是否必须，默认为true，表示该参数值必须有，如果是false 表示不是必须
     *  defaultValue 请求参数的默认值
     * @param id
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/testRestPostPut.acs", method = RequestMethod.PUT)
    public void testRestPostPut1(@RequestParam(value = "Id", required = true, defaultValue = "") String id, HttpServletResponse response) throws IOException {
        System.out.println("/testRestPostPut:" + id);
        response.getWriter().println(id);
        //        return HelloWorld;
    }
}
