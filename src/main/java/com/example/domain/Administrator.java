package com.example.domain;

 /**
* Administratorは、管理員情報を表すドメインです。
*
*/

public class Administrator {

    private Integer id;
    private String name;
    private String mailAddress;
    private String password;

    /**
     * コンストラクタ
     *
     * @param Admin 管理者情報
     */
    public void Administrator() {

    }

    /**
     * 以下、getter/setter
     *
     * @param Admin 管理者情報
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "Administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }

}
