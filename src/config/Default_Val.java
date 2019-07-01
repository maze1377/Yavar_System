package config;

import setting.Setting;

public enum Default_Val {
    SuccesAddUser("کاربر با موفقت اضافه شد.", "User add successful"),
    ;
    private String per;
    private String En;

    Default_Val(String per, String en) {
        this.per = per;
        En = en;
    }

    public String getPer() {
        return per;
    }

    //set date for user 
    public void setPer(String per) {
        this.per = per;
    }

    public String getEn() {
        return En;
    }

    public void setEn(String en) {
        En = en;
    }

    @Override
    public String toString() {
        if (Setting.curentState == Setting.stateLan.En) {
            return getEn();
        } else if (Setting.curentState == Setting.stateLan.Fa) {
            return getPer();
        } else {//defualt val
            return getEn();
        }
    }
}
