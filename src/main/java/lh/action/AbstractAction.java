package lh.action;


import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class AbstractAction {
    protected String title = "";
    @Autowired
    private MessageSource messageSource;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    public void setMsgAndUrl(String msg, String url, ModelAndView modelAndView) {
        modelAndView.addObject("msg", getResourceValue(msg, title));
        modelAndView.addObject("url", getResourceValue(url, title));
    }

    public String getResourceValue(String key, Object... agr) {
        try {
            return messageSource.getMessage(key, agr, Locale.getDefault());
        } catch (Exception e) {
            return null;//如果处异常，说明资源没有这key,直接返回null
        }
    }

    public void logout() {
        SecurityUtils.getSubject().logout();
    }
}
