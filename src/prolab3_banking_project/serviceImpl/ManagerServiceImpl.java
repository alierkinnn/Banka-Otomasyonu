
package prolab3_banking_project.serviceImpl;

import prolab3_banking_project.model.ResponseModel;
import prolab3_banking_project.repository.ManagerRepository;
import prolab3_banking_project.service.ManagerService;


public class ManagerServiceImpl implements ManagerService{
    
    private ManagerRepository managerRepository = new ManagerRepository();

    @Override
    public ResponseModel<Boolean> maasBelirle(Long salary) {
        ResponseModel responseModel = new ResponseModel();
        
        if(managerRepository.maasBelirle(salary)==false){
            responseModel.setSuccess(false);
            responseModel.setMessage("İşlem Başarısız");
        }
        else{
            responseModel.setSuccess(true);
            responseModel.setMessage("İşlem Başarılı");
            
        }
        
        return responseModel;
    }

}
