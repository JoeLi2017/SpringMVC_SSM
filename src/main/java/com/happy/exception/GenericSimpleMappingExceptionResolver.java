package com.happy.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lirongbo on 2017/7/7.
 */
public class GenericSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        // Expose ModelAndView for chosen error view.
        String viewName = determineViewName(ex, request);
        //log exception
        logException(ex, request);
        if (viewName != null) {
            //返回为JSP视图
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                    .getHeader("X-Requested-With")!= null && request
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else {
                //JSON格式
                try {
                    response.setContentType("application/json");
                    PrintWriter writer = response.getWriter();
                    writer.write("{\"success\":\"false\",\"code\":-1,\"message\":\"系统错误\"}");
                    writer.flush();
                } catch (IOException e) {
                    logger.error(e,e);
                }
                return null;

            }
        } else {
            return null;
        }
    }

}
