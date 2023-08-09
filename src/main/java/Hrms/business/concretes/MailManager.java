package Hrms.business.concretes;

import org.springframework.stereotype.Service;

import Hrms.core.utilities.MailService;
@Service
public  class MailManager implements MailService{

		@Override
		public String postMail(String eMail) {

			return "Mail Gönderildi Lütfen Aktif Ediniz";
		}

		@Override
		public String isCheckMail(boolean link) {
		if(link) {
			return "Hesabınız Aktif Edildi";
			
			
		} return "Hesabınız Onaylanamadı";
			
		}

}
