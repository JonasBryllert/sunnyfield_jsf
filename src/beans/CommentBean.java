package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import model.Blog;

@ManagedBean
@RequestScoped
public class CommentBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email;
	private String comment;
	@ManagedProperty(value="#{blogBean}") BlogBean blogBean;
	
	public CommentBean() {
		System.out.println("CommentBean constructor");
	}
	
	public void setBlogBean(BlogBean blogBean) {
		this.blogBean = blogBean;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String processComment() {
		Blog blog = new Blog();
		blog.setDate(DateFormat.getDateTimeInstance().format(new Date()));
		blog.setMessage(comment);
		blog.setUser(email);
		blogBean.addBlog(blog);
		FacesContext.getCurrentInstance().addMessage("Blog added", new FacesMessage("Comment added"));
//		email = null;
//		comment = null;
		return null;
	}
	
}
