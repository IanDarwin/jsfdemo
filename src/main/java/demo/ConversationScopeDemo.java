package demo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ConversationScoped
@Named("convBean")
public class ConversationScopeDemo {
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