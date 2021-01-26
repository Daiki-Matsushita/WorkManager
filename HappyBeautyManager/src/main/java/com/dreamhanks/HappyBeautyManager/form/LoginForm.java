package com.dreamhanks.HappyBeautyManager.form;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * ログイン画面から入力された値が入っているフォームクラス
 * @author elmu
 *
 */


public class LoginForm {

	 /** userId*/
		@NotNull(message="is required")
		@NotEmpty(message="is required")
		@Size(min=1, message="is required")
		private String id;

		 /** userPassword*/
		@NotNull(message="is required")
		@NotEmpty(message="is required")
		@Size(min=1, max = 100, message="is required")
		private String password;

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
}
