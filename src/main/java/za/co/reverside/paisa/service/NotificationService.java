package za.co.reverside.paisa.service;


import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.co.reverside.paisa.domain.Notification;
import za.co.reverside.paisa.domain.User;
import za.co.reverside.paisa.repository.MessageRepository;


@Service
public class NotificationService {

	@Autowired
	public MessageRepository messageRepository;
        
	private Notification notification;

	@Value("${application.hostname}")
	private String hostname;

	@Value("${application.port}")
	private String port;

	public void sendLoginDetailsNotification(User user) {

		String subject = "Please verify your email address !";

		String message = String.format("Dear  " +  user.getFirst_name() + ",\n \n"
                                                + "\n"
                                                + "\n"
                                                + "Verify your Email Address" + "\n"
                                                + "\n"
                                                + "\n"
                                                + "\n"
                                                + "Please click on this this link to activate your account" + "\n"
                                                + "\n"
                                                + "http://%s:%s/index.html#/sign-in/" + "  " + UUID.randomUUID().toString().substring(1, 15) + "\n"
                                                + "\n"
                                                + "\n"
                                                + "Thanks" + " & " + "Regards" + "\n"
                                                + "\n"
                                                + "Polygon Team"
                                                + "\n",
						hostname,
						port);
		notification = new Notification(user.getEmail(), subject, message);
		messageRepository.publish(notification, "q.notification");
	}
        
	
	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
}