package blogpost;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped // Keep the list in memory
public class Blogster implements Serializable {

	private String subject;
	private String content;

	private List<BlogEntry> list = new ArrayList<>();

	public Blogster() {
		System.out.println("Blogster.Blogster()");
	}
	
	public List<BlogEntry> list() {
		return list;
	}

	public String save() {
		System.out.println("BlogPoster.save()");
		BlogEntry e = new BlogEntry(subject, content);
		list.add(0, e);

		// In real life the new entity would be saved to the DB here...

		return "BlogList";
	}

    public String cancel() {
    	System.out.println("BlogPoster.cancel()");
		// Undo anything that needs undoing, like a Conversation...

		return "BlogList";
	}

    // Boring accessors, generated by Eclipse:
    
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
