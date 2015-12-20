package za.co.reverside.paisa.service;

import static java.lang.StrictMath.log;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.reverside.paisa.domain.LoanType;
import static za.co.reverside.paisa.mapper.Mapper.toProductQueryModel;
import za.co.reverside.paisa.model.LoanTypesQueryModel;
import za.co.reverside.paisa.repository.LoanTypeRepository;



@RestController
public class LoanTypeService {
    
    @Autowired
    private LoanTypeRepository loanTypeRepository;
    

        
    @RequestMapping(value = "api/loanTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LoanTypesQueryModel> findAllLoanTypes() {
        List<LoanType> loanTypes = loanTypeRepository.findAll();
        return toProductQueryModel(loanTypes);
    }


} 