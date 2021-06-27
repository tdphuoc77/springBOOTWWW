package com.onthi.bai17client.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onthi.bai17client.model.TacPham;

@Component
public class TacPhamValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return TacPham.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(!supports(target.getClass())) {
			return;
		}
		TacPham tacPham= (TacPham) target;
		 String tenTP= tacPham.getTenTP() ;
		 if(tenTP.length()==0) {
			 errors.rejectValue("tenTP", null, "Không hợp lệ");
		 }
		 String loaiTP=tacPham.getLoaiTP() ;
		 if(loaiTP.length()==0) {
			 errors.rejectValue("loaiTP", null, "Không hợp lệ");
		 }
		 int soTrang=tacPham.getSoTrang();
		 if(soTrang<=0) {
			 errors.rejectValue("soTrang", null, "Không hợp lệ");
		 }
		 double gia=tacPham.getGia();
		 if(gia<=0) {
			 errors.rejectValue("gia", null, "Không hợp lệ");
		 }
		 String tomtat=tacPham.getTomtat();
		 if(tomtat.length()==0) {
			 errors.rejectValue("tomtat", null, "Không hợp lệ");
		 }
		 String hinh=tacPham.getHinh();
		 if(hinh.length()==0) {
			 errors.rejectValue("hinh", null, "Không hợp lệ");
		 }
	}

}
