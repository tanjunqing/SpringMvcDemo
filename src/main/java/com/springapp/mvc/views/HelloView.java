package com.springapp.mvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by Tan on 2015/6/6.
 */
@Component
public class HelloView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model,HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.getWriter().print("Hello Word View Tiem" + new Date());
    }
}
