package za.co.reverside.paisa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.reverside.paisa.domain.UserComment;
import static za.co.reverside.paisa.mapper.Mapper.fromUserComment;
import static za.co.reverside.paisa.mapper.Mapper.toUserCommentQueryModel;
import za.co.reverside.paisa.model.UserCommentCommandModel;
import za.co.reverside.paisa.model.UserCommentQueryModel;
import za.co.reverside.paisa.repository.UserCommentRepository;



@RestController
public class UserCommentService {
    
    
    @Autowired
    private UserCommentRepository userCommentRepository;
 
    @RequestMapping(value = "api/comment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void  commentOfUser(@RequestBody UserCommentCommandModel userCommentCommandModel) {

        UserComment userComment = fromUserComment(userCommentCommandModel);
        userCommentRepository.save(userComment);
        System.out.println("Saved Successfully");
    }
    
    @RequestMapping(value = "api/usersComment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserCommentQueryModel> findAllCommentOfUsers() {
        List<za.co.reverside.paisa.domain.UserComment> usersComment = userCommentRepository.findAll();
        List<UserCommentQueryModel> result = toUserCommentQueryModel(usersComment);
        return result;
    }


} 