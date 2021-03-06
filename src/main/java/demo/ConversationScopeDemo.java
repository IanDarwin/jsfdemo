package demo;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named@ConversationScoped
public class ConversationScopeDemo implements Serializable {

	private static final long serialVersionUID = -6623869935887347917L;

	@Inject
	Conversation conv;

	/** 
	 * In JSF: this'll cause #{convBean…} to start conversation! 
	 */
	@PostConstruct
	void init() {
		System.out.println("ConversationScopeDemo.init()");
		conv.begin("conversationDemo");
	}

	public Conversation getConversation() {
		return conv;
	}

	public void end() {
		conv.end();
	}
}
