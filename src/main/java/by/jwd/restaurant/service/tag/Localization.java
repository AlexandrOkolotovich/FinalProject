package by.jwd.restaurant.service.tag;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localization extends SimpleTagSupport {
    private String tagMessage;

    public String getTagMessage() {
        return tagMessage;
    }

    public void setTagMessage(String tagMessage) {
        this.tagMessage = tagMessage;
    }

    @Override
    public void doTag() throws IOException {

        String locale = (String) getJspContext().getAttribute("locale", PageContext.SESSION_SCOPE);

        ResourceBundle bundle = ResourceBundle.getBundle("locale", new Locale(locale));

        if(bundle.containsKey(tagMessage)){
            String message = bundle.getString(getTagMessage());
            getJspContext().getOut().print(message);
        }else{
            final String[] split = tagMessage.split("\\.");
            getJspContext().getOut().print(split[split.length - 1]);
        }

    }
}
