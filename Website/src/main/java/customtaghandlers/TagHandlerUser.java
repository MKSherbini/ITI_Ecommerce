package customtaghandlers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;
import models.User;

import java.io.IOException;

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
        this.user = new User((long)10,"mohamad","osman","osos","123456aB*","mohaelkaed@gmail.com");

        ServletRequest request = pc.getRequest();
        request.setAttribute("Uesr",user);
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