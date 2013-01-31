package beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Blog;

@ManagedBean
@SessionScoped
public class BlogBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Blog> blogList = new ArrayList<Blog>();
	
	public BlogBean() {
		System.out.println("BlogBean constructor");
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
	
	synchronized public void addBlog(Blog blog) {
		blogList.add(blog);
	}
	
	synchronized public List<Blog> getBlogList() {
		return blogList;
	}
}
