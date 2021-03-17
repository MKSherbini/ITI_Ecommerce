package customtaghandlers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;
import models.Product;
import java.io.IOException;


public class TagHandler implements Tag {
    private Product product;
    private PageContext pc;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPageContext(PageContext p)
    {
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
        this.product = new Product((long)10,"camera",20,"electronics","jdjs dksks dksks dks",11,"images/preloader.png",10);

        ServletRequest request = pc.getRequest();
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
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
