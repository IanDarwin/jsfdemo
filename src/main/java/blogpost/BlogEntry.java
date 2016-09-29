package blogpost;

import java.time.LocalDate;

public class BlogEntry {
	
	private LocalDate date;
	private String subject;
	private String content;
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}
	
	public BlogEntry() {
		this.date = LocalDate.now();
	}

	public BlogEntry(String subject, String content) {
		this();
		this.subject = subject;
		this.content = content;
	}


}
