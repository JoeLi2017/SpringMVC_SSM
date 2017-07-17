package com.happy.util;


import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.BeanUtils;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by lirongbo on 2017/7/6.
 */
public class CloudTldFunction {

    /**
     * html转义
     * @param source
     * @return
     */
    public static String htmlEscape(String source){
        return HtmlUtils.htmlEscape(source);
    }

    /**
     * 传入时间到现在总共有多少天
     * @param date
     * @return
     */
    public static String dayToNow(Date date){
        if(date == null){
            return "";
        }
        DateTime dt = new DateTime(date);
        DateTime now = new DateTime();
        return String.valueOf(Days.daysBetween(dt, now).getDays());
    }

    public static String apiMapBaiduUrl(){
        String ak = ApplicationContextUtil.getBean("resourcesProperties", Properties.class).getProperty("api.map.baidu.ak");
        String protocol = WebUtil.getRequest().getScheme();
        if("https".equals(protocol)){
            return "https://api.map.baidu.com/api?v=2.0&ak="+ak+"&s=1";
        }else{
            return "http://api.map.baidu.com/api?v=2.0&ak="+ak;
        }
    }

}
