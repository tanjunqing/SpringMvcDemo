package com.springapp.mvc;

import com.springapp.mvc.PoJo.Person;
import com.springapp.mvc.PoJo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Tan on 15/5/26.
 */

@SessionAttributes(value = {"user"}, types = {String.class})
@Controller
@RequestMapping("/SpringMvc")
/** 1：RequestMapping注解为控制器指定可以处理那些URL的请求
 *  2：在控制器的类定义已经方法定义处都可以标注
 *  2.1 在类定义处：提供初步的请求映射信息。相对于Web应用的根目录
 *  2.2 方法处定义：提供进一步的细分银映射信息。相对于类定义处的URL，
 *      若类定义处未标注@RequestMapping,则方法处标记的URL相对于Web应用的根目录
 *  3：函数的返回值会通过试图解析器，解析为实际的物理试图，对于org.springframework.web.servlet.view.InternalResourceViewResolver视图解析器，会做如下的解析
 *  3.1：通过prefix + returnVal + 后缀suffix方式返回 得到实际的物理地址
 *
 */ public class RequestMappingTest {

    private static final String HelloWorld = "HelloWorld";

    private static final String Call = "/Call/callInfo";

    private static final String ModelAndViewJsp = "ModelAndView";

    private static final String GLOBAL = "Global";

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
    @RequestMapping(value = "/testParamsAndHeaders.acs", method = RequestMethod.GET, params = {"userName","age!=10"})
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
     * value 值即请求参数的参数名
     * required 参数是否必须，默认为true，表示该参数值必须有，如果是false 表示不是必须
     * defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testRestPostPut.acs", method = RequestMethod.PUT)
    public void testRestPostPut1(@RequestParam(value = "Id", required = true, defaultValue = "") String id,HttpServletResponse response) throws IOException {
        System.out.println("/testRestPostPut:" + id);
        response.getWriter().println(id);
        //        return HelloWorld;
    }

    /**
     * @RequestHeader 用来映射请求头
     * 方法同@RequestParam 相同
     */
    @RequestMapping(value = "/getRequestHeader.acs", method = RequestMethod.GET)
    public String getRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
        System.out.println("getRequestHeader中的参数Accept-Language的值:" + al);
        return HelloWorld;
    }

    /**
     * @param sessionId
     * @return
     * @CookieValue 用来映射Cookie值，属性同@RequestParam相同
     */
    @RequestMapping(value = "/getRequestCookie.acs", method = RequestMethod.GET)
    public String getRequestCookie(@CookieValue(value = "JSESSIONID", required = true, defaultValue = "") String sessionId) {
        System.out.println("getRequestCookie中的值为:" + sessionId);
        return HelloWorld;
    }

    /**
     * SpringMVc会按照请求的参数名和OPJO的属性进行自动配置，自动为该对象填充属性值，支持级联属性，
     * 如Pojo包中使用Address类下的属性；需要在User类中添加需要级联的类，并且设置Get,Set属性
     * 使用时候 在jsp页面中 定义为：address:<input type="text" value="" name="address.city">
     * 其中name 中的address 就是在User类中定义的Address类的名称
     * 如果只需要使用User类中的参数 定义为：email:<input type="text" value="" name="email">
     * 其中name 中的email 就是User类中定义的属性
     */
    @RequestMapping(value = "/testPojo.acs", method = RequestMethod.POST)
    public String testPojo(User user) {
        System.out.println("testPojo:" + user.toString());
        return HelloWorld;
    }

    /**
     * 可以使用原生的ServletAPI作为目标方法的具体的参数具体支持以下的类型
     * HttpServletRequest
     * HttpServletRequest
     * HttpSeesion
     * java.security.Principal
     * Local InputStream
     * OutputStream
     * Reader
     * Writer
     */
    @RequestMapping(value = "/testHttpServletAPI.acs", method = RequestMethod.POST)
    public String testHttpServletAPI(HttpServletRequest request,HttpServletResponse response) {
        System.out.println("testHttpServletAPI--HttpServletRequest:" + request.toString() + "HttpServletResponse:" + response.toString());
        return HelloWorld;
    }

    /**
     * 1.目标返回值可以用ModelAndView
     * 2.其中可以包含视图和模型信息
     * 3.SpringMvc会把ModelAndView的Model中的数据放入到Request域对象中
     * 4.requestScope是一个定义， 表明一个http请求的整个声明周期，
     * 它只是一个定义而已，不是一个对象。
     * EL中你可以在这个周期中放置、获取对象。
     * （当然，其实真正的操作也是针对request对象的）
     */
    @RequestMapping(value = "/testModelAndVeiw.acs", method = RequestMethod.GET)
    public ModelAndView testModelAndVeiw() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(ModelAndViewJsp);
        modelAndView.addObject("message","HelloWorld");
        return modelAndView;
    }

    /**
     * 目标方法可以添加Map类型（实际上也可以是Model类型、或者ModelMap类型）的参数
     *
     * @param maps
     * @return
     */
    @RequestMapping(value = "/testMap.acs", method = RequestMethod.GET)
    public String testMap(Map<String, Object> maps) {
        System.out.println(maps.getClass().getName());
        maps.put("message","Jack,Hello,Fk");
        return ModelAndViewJsp;
    }

    /**
     * 测试使用ModelMap类型的参数
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/testModelMap.acs", method = RequestMethod.GET)
    public String testModelMap(ModelMap modelMap) {
        System.out.println(modelMap.getClass().getName());
        modelMap.put("message","Jack,Hello,FK,MOdelMap");
        return ModelAndViewJsp;
    }

    @RequestMapping(value = "/testModel.acs", method = RequestMethod.GET)
    public String testModel(Model model) {
        System.out.println(model.getClass().getName());
        model.addAttribute("message","Jack,Hello,FK,ModelTest");
        return ModelAndViewJsp;
    }

    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
     * 注意: 该注解只能放在类的上面. 而不能修饰放方法.
     */
    @RequestMapping(value = "/testSessionAttributes.acs", method = RequestMethod.GET)
    public String testSessionAttributes(Map<Object, Object> map,HttpServletRequest request) {
        User user = new User();
        user.setUserName("Hello");
        user.setPassWord("1234");
        map.put("user",user);
        map.put("school","atshengguigu");
        request.getSession().setAttribute("user",user);
        return ModelAndViewJsp;
    }

    @RequestMapping(value = "/testgetSessionAttrbuters.acs", method = RequestMethod.GET)
    public void getSessionAttrbuters(ModelMap modelMap,HttpServletResponse response) throws Exception {
        User user = (User)modelMap.get("user");
        response.getWriter().println(user.toString());
    }

    @RequestMapping(value = "/testGetHttpSession.acs", method = RequestMethod.GET)
    public void getSessionAttrbuters(HttpSession session) {
        User user = (User)session.getAttribute("user");
    }

    /**
     * 1.执行@ModelAttribute 注解修饰的方法：从数据库中取出对象，把对象放入到Map中，键为：user
     * 2.SpringMvc 从Map中取出User对象，并且把表单的请求参数赋给User对象相应的属性
     * 3.SpringMvc 把上述对象传入目标方法的对象
     * 注意：在@ModelAttribute 修饰的方法中，放入到Map时的键，需要和目标方法的入参
     * 类型的第一个字母小写的字符串一致！
     * <p/>
     * SpringMVC 确定目标方法的 POJO 类型的入参过程
     * 1. 确定一个 key:
     * 1). 若目标方法的 POJO 类型的参数没有使用 @ModelAttribute 作为修饰, 则 key 为 POJO 类名第一个字母的小写
     * 2). 若使用了  @ModelAttribute 来修饰, 则 key 为 @ModelAttribute 注解的 value 属性值.
     * 2. 在 implicitModel 中查找 key 对应的对象, 若存在, 则作为入参传入
     * 1). 若在 @ModelAttribute 标记的方法中在 Map 中保存过, 且 key 和 1 确定的 key 一致, 则会获取到.
     * 3. 若 implicitModel 中不存在 key 对应的对象, 则检查当前的 Handler 是否使用 @SessionAttributes 注解修饰,
     * 若使用了该注解, 且 @SessionAttributes 注解的 value 属性值中包含了 key, 则会从 HttpSession 中来获取 key 所
     * 对应的 value 值, 若存在则直接传入到目标方法的入参中. 若不存在则将抛出异常.
     * 4. 若 Handler 没有标识 @SessionAttributes 注解或 @SessionAttributes 注解的 value 值中不包含 key, 则
     * 会通过反射来创建 POJO 类型的参数, 传入为目标方法的参数
     * 5. SpringMVC 会把 Key 和 POJO 类型的对象保存到 implicitModel 中, 进而会保存到 request 中.
     * 源码分析
     * 1.调用 HandlerMethodInvoker 类中的 invokeHandlerMethod 方法
     * 调用 @MoedlAttribute 注释的方法，实际上 @MoedlAttribute 方法中的Map 中的数据放在 implicitModel 中。
     * 2.解析请求处理器的目标参数，实际上该目标参数来自于 WebDataBinder 对象的target属性
     * 2.1 创建 WbeDataBinder 对象：
     * 1）确定 objectName 属性：若传入的 attrName 的属性值为 ""，则 objcetName 为类名的第一个字母小写
     * ******* 注意：若目标方法的 PoJo 属性使用了 @ModelAttribute 来修饰 ，则 attrName 值即为 @ ModelAttribute 的value属性
     * 2）确定 target
     * >在 implicitModel 中查找 attrName 对应的值。若存在OK
     * >若不存在： 则验证当面的 Handler 是否使用了 @SessionAttribute 进行修饰。若使用了则尝试从 Session中
     * >获取attrName 所对应的属性值，若 session 中没有对应的属性值 ，则抛出异常。
     * > 若 Handler 没有使用@SessionAttributes 进行修饰，或 @SessionAttributes 中没有使用value 值指定的 Key
     * 和attrName 相匹配，则通过反射创建PoJO
     * 2.2 SpringMVC 把表单的请求参数赋给了 WebDataBinder 的 target 对应的属性
     * 2.3 SpringMVC 会把 WebDataBinder 的 attrName 和 target 给到 implicitModel，进而传到 request 域对象中
     * 2.4 把 WebDataBinder 的 target 作为参数查传递给目标的入参
     */
    @RequestMapping(value = "/testPersonPojo.acs", method = RequestMethod.POST)
    // public String savePerson(Person person) {
    public String savePerson(@ModelAttribute("person") Person person) {
        System.out.println(person.toString());
        return ModelAndViewJsp;
    }

    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
     */
    @ModelAttribute
    public void getPerson(@RequestParam(value = "id", required = false) Long id,Map<String, Object> map) {
        System.out.println("调用了@ModelAttribute方法：Id" + id);
        if (id != null) {
            Person person = new Person();
            person.setId(3L);
            person.setUserName("tan1");
            person.setAge("22");
            person.setPassWord("123456");
            map.put("person",person);
        }
    }

    /**
     * 测试 Global全球化
     *
     * @return
     */
    @RequestMapping(value = "/testGlobal.acs", method = RequestMethod.GET)
    public String testGlobal() {
        System.out.println("testGlobal:::");
        return GLOBAL;
    }

    /**
     * 测试BeanNameViewResolver
     * BeanNameViewResolver 将逻辑视图名解析为一个 Bean，Bean 的 Id 等于逻辑视图名（注意返回的视图的名称 头字母小写。）
     *
     * @return
     */
    @RequestMapping(value = "/testBeanNameView.acs", method = RequestMethod.GET)
    public String testBeanNameView() {
        /**
         * 注意此处的返回值是 views包中 com.springapp.mvc.views.HelloView 的头字母小写
         */
        return "helloView";
    }

    /**
     * 测试Redirest 重定向
     *
     * @return
     */
    @RequestMapping(value = "/testRedirect.acs", method = RequestMethod.GET)
    public String testRedirest() {
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
        //        return  "redirect:http://www.chinatcc.com";
    }
}
