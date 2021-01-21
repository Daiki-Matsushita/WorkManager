package com.dreamhanks.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



public class LoginForm {

	// DBはvarcharだけど(DBは関係ない）クライアント側がどんな型でいれるかが問題
	@NotEmpty(message="空欄は不可です。パスワードを入力してください。")
	@Size(max = 10, message="最高１０桁以内でパスワードを入力ください。")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
