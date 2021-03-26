package customtaghandlers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;
import models.orm.User;

import java.io.IOException;
import java.sql.Date;

public class TagHandlerUser implements Tag {
    private User user;
    private PageContext pc;

    public User getProduct() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPageContext(PageContext p) {
        pc = p;
    }

    @Override
    public void setParent(Tag tag) {

    }

    public void release() {}
    public Tag getParent() {
        return null;
    }
    @Override
    public int doStartTag() {
        return Tag.SKIP_BODY;
    }
    @Override
    public int doEndTag()
    {
        this.user = new User("hadeerelnagar@jdk.ckd", "moha", "123", "kaed", "hdjs", Date.valueOf("29/6/1998"));

        ServletRequest request = pc.getRequest();
        request.setAttribute("User",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");
        try {
            requestDispatcher.include(request,pc.getResponse());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

}