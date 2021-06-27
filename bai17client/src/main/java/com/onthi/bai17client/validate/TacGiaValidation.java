package com.onthi.bai17client.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onthi.bai17client.model.TacGia;

@Component
public class TacGiaValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TacGia.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return ;
		}
		TacGia tacGia= (TacGia) target;
		 String hoTen = tacGia.getHoTen();
		 if(hoTen.length()==0) {
			 errors.rejectValue("hoTen", null, "Không hợp lệ");
		 }
		 String linhVuc=tacGia.getLinhVuc();
		 if(linhVuc.length()==0) {
			 errors.rejectValue("linhVuc", null, "Không hợp lệ");
		 }
		 String tieuSu=tacGia.getTieuSu();
		 if(tieuSu.length()==0) {
			 errors.rejectValue("tieuSu", null, "Không hợp lệ");
		 }
	}

}
