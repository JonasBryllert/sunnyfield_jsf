package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Blog;

@ManagedBean
@SessionScoped
public class BlogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String email;
	private String comment;
	
	private List<Blog> blogList = new ArrayList<Blog>();
	
	public BlogBean() {
		System.out.println("CommentBean constructor");
		Blog blog = new Blog();
		blog.setDate(DateFormat.getDateTimeInstance().format(new Date()));
		blog.setMessage("test");
		blog.setUser("test emnail");
		blogList.add(blog);
		Blog blog2 = new Blog();
		blog2.setDate(DateFormat.getDateTimeInstance().format(new Date()));
		blog2.setMessage("this is  a long message that will probabaly never end unless someone puts an end to it.....");
		blog2.setUser("test emnail");
		blogList.add(blog2);
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
		blogList.add(blog);
		FacesContext.getCurrentInstance().addMessage("Blog added", new FacesMessage("Comment added"));
		return null;
	}
	
	public List<Blog> getBlogList() {
		return blogList;
	}
}
