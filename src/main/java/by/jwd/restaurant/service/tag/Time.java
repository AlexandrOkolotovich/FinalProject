package by.jwd.restaurant.service.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Time extends TagSupport {
   @Override
    public int doStartTag() throws JspException{
       GregorianCalendar gc = new GregorianCalendar();
       String time = String.valueOf(gc.getTime());
       try{
           JspWriter out = pageContext.getOut();
           out.write(time);
       } catch (IOException e){
           throw new JspException("write time exception", e);
       }

       return SKIP_BODY;
   }

   @Override
    public int doEndTag() throws JspException{
       return EVAL_PAGE;
   }
}
