package za.co.reverside.paisa.mapper;

import java.util.ArrayList;
import java.util.List;
import za.co.reverside.paisa.domain.LoanType;
import za.co.reverside.paisa.domain.User;
import za.co.reverside.paisa.model.LoanTypesQueryModel;
import za.co.reverside.paisa.model.UserCommandModel;
import za.co.reverside.paisa.model.UserQueryModel;



public class Mapper {

    public static User fromRegistration(UserCommandModel userCommandModel) {

        User user = new User();
        user.setFirst_name(userCommandModel.getFirstName());
        user.setLast_name(userCommandModel.getLastName());
        user.setPhoneNumber(userCommandModel.getPhoneNumber());
        user.setEmail(userCommandModel.getEmail());
        user.setPassword(userCommandModel.getPassword());
        user.setRole("USER");
        user.setEnabled(true);
        return user;
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
