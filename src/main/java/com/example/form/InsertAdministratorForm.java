package com.example.form;

/**
 * 管理者情報を受け取るフォームクラス
 */
public class InsertAdministratorForm {
    
    private String name;
    private String mailAddress;
    private String password;

    /**
     * 以下、getter/setter/toStringメソッド
     *
     * @param Admin 管理者情報
     */
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
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
        return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }

}
