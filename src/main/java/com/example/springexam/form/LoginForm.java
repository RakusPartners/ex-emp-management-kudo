package com.example.springexam.form;

/**
 * ログイン時に使用するフォームクラス
 */

public class LoginForm {

    private String mailAddress;
    private String password;

    /**
     * 以下、getter/setter/toStringメソッド
     *
     * @param Admin 管理者情報
     */
    
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
    }
}
