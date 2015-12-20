package za.co.reverside.paisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.reverside.paisa.domain.User;
import static za.co.reverside.paisa.mapper.Mapper.fromUser;
import za.co.reverside.paisa.model.UserCommandModel;
import za.co.reverside.paisa.repository.UserRepository;



@RestController
public class UserService {
    
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NotificationService notificationService;

        
    @RequestMapping(value = "api/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  registerUser(@RequestBody UserCommandModel userCommandModel) {

        
        User user = fromUser(userCommandModel);
        notificationService.sendLoginDetailsNotification(user);
        userRepository.save(user);
        System.out.println("Saved Successfully");
    }


} 