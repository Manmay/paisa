package za.co.reverside.paisa.mapper;

import java.util.ArrayList;
import java.util.List;
import za.co.reverside.paisa.domain.AdminComment;
import za.co.reverside.paisa.domain.LoanType;
import za.co.reverside.paisa.domain.User;
import za.co.reverside.paisa.domain.UserComment;
import za.co.reverside.paisa.model.AdminCommandModel;
import za.co.reverside.paisa.model.LoanTypesQueryModel;
import za.co.reverside.paisa.model.UserCommandModel;
import za.co.reverside.paisa.model.UserCommentCommandModel;
import za.co.reverside.paisa.model.UserCommentQueryModel;
import za.co.reverside.paisa.model.UserQueryModel;



public class Mapper {

    public static User fromUser(UserCommandModel userCommandModel) {

        User user = new User();
        user.setFirst_name(userCommandModel.getFirstName());
        user.setLast_name(userCommandModel.getLastName());
        user.setPhoneNumber(userCommandModel.getPhoneNumber());
        user.setEmail(userCommandModel.getEmail());
        user.setPassword(userCommandModel.getPassword());
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        return user;
    }
   
    
    public static UserComment fromUserComment(UserCommentCommandModel userCommentCommandModel) {

        UserComment user_Comment = new UserComment();
        user_Comment.setFirst_name(userCommentCommandModel.getFirstName());
        user_Comment.setLast_name(userCommentCommandModel.getLastName());
        user_Comment.setPhone(userCommentCommandModel.getPhoneNumber());
        user_Comment.setComment(userCommentCommandModel.getComment());
        return user_Comment;
    }
    
     
    
    public static UserQueryModel toUserQueryModel(User from) {
        UserQueryModel user = new UserQueryModel();
        user.setId(from.getId());
        user.setFirstName(from.getFirst_name());
        user.setLastName(from.getLast_name());
        user.setEmail(from.getEmail());
        user.setPassword(from.getPassword());
        user.setRole(from.getRole());
        return user;
    }

    public static List<UserQueryModel> toUserQueryModel(List<User> fromList) {
        List<UserQueryModel> userList = new ArrayList<UserQueryModel>();
        for (User user : fromList) {
            userList.add(toUserQueryModel(user));
        }
        return userList;
    }
   
    
    
    public static UserCommentQueryModel toUserCommentQueryModel(UserComment userComment) {
        UserCommentQueryModel userCommentQueryModel = new UserCommentQueryModel();
        userCommentQueryModel.setId(userComment.getId());
        userCommentQueryModel.setFirstName(userComment.getFirst_name());
        userCommentQueryModel.setLastName(userComment.getLast_name());
        userCommentQueryModel.setPhoneNumber(userComment.getPhone());
        userCommentQueryModel.setComment(userComment.getComment());
        return userCommentQueryModel;
    }

    public static List<UserCommentQueryModel> toUserCommentQueryModel(List<UserComment> fromCommentList) {
        List<UserCommentQueryModel> userCommentList = new ArrayList<UserCommentQueryModel>();
        for (UserComment userComment : fromCommentList) {
            userCommentList.add(toUserCommentQueryModel(userComment));
        }
        return userCommentList;
    }
      
    
    public static LoanTypesQueryModel toProductQueryModel(LoanType from) {
        LoanTypesQueryModel loanTypesQueryModel = new LoanTypesQueryModel();
        loanTypesQueryModel.setId(from.getId());
        loanTypesQueryModel.setName(from.getName());
        loanTypesQueryModel.setDescription(from.getDescription());
        loanTypesQueryModel.setImage(from.getImage());
        return loanTypesQueryModel;
    }

    public static List<LoanTypesQueryModel> toProductQueryModel(List<LoanType> fromList) {
        List<LoanTypesQueryModel> loanTypesQueryModels = new ArrayList<LoanTypesQueryModel>();
        for (LoanType product : fromList) {
            loanTypesQueryModels.add(toProductQueryModel(product));

        }
        return loanTypesQueryModels;
    }

}
