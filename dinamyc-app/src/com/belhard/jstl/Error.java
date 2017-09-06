package com.belhard.jstl;

import javax.servlet.jsp.ErrorData;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Error extends TagSupport {

    private String message;

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int doStartTag() throws JspException {

        ErrorData errorData =  pageContext.getErrorData();
        Exception exception =  pageContext.getException();
        String errors = errorData.toString();
        String exceptions = exception.getMessage();
        JspWriter out = pageContext.getOut();
        try {
            out.write(errors + exceptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
