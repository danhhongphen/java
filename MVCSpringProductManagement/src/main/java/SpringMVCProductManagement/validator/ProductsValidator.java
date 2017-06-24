package SpringMVCProductManagement.validator;

import SpringMVCProductManagement.model.ProductsInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
@Component
public class ProductsValidator implements Validator {
  
  
   // Các class được hỗ trợ Validate
   @Override
   public boolean supports(Class<?> clazz) {
       return clazz == ProductsInfo.class;
   }
 
   @Override
   public void validate(Object target, Errors errors) {
	   ProductsInfo productsInfo = (ProductsInfo) target;
 
  
       // Kiểm tra các field của ApplicantInfo.
       // (Xem thêm file property: messages/validator.property)
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product_id", "NotEmpty.managerForm.product_id");
       
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.managerForm.name");

    
   }
 
}