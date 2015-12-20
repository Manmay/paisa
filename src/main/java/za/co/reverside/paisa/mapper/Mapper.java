package za.co.reverside.paisa.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import za.co.reverside.paisa.domain.LoanType;
import za.co.reverside.paisa.domain.Login;
import za.co.reverside.paisa.domain.User;
import za.co.reverside.paisa.model.LoanTypesQueryModel;
import za.co.reverside.paisa.model.LoginQueryModel;
import za.co.reverside.paisa.model.UserCommandModel;


public class Mapper {

    public static User fromRegistration(UserCommandModel userCommandModel) {

        User user = new User();
        user.setFirst_name(userCommandModel.getFirstName());
        user.setLast_name(userCommandModel.getLastName());
        user.setMobile_number(userCommandModel.getPhoneNumber());
        user.setEmail(userCommandModel.getEmail());
        user.setPassword(userCommandModel.getPassword());
        user.setEnabled(true);
        return user;
    }
    
    public static Login fromLoginCommandModel(UserCommandModel userCommandModel,User users){
        Login loginDetails = new Login();
        loginDetails.setUser(users);
        loginDetails.setUserName(userCommandModel.getFirstName() + UUID.randomUUID().toString().substring(1, 3));
        loginDetails.setPassword(users.getPassword());
        loginDetails.setRole("USER");
        return loginDetails;
    }
    
    public static LoginQueryModel toLoginQueryModel(Login from) {
        
        LoginQueryModel user = new LoginQueryModel();
        user.setId(from.getId());
        user.setUserName(from.getUserName());
        user.setPassword(from.getPassword());
        user.setRole(from.getRole());
        return user;
    }

    public static List<LoginQueryModel> toUserQueryModel(List<Login> fromList) {
        List<LoginQueryModel> userList = new ArrayList<LoginQueryModel>();
        for (Login user : fromList) {
            userList.add(toLoginQueryModel(user));
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
