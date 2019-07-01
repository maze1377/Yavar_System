package config;

import setting.Setting;

public enum Default_Val {
    SuccesAddUser("کاربر با موفقت اضافه شد.", "User add successful"),

    CommentSuccessful("نظر شما با موفقیت ارسال شد.", "Comment has been sent successfully"),
    CommentNotSuccessful("نظر شما ارسال نشد.", "Comment has not been sent successfully"),

    ReportUserSuccessful("گزارش شما با موفقیت ارسال شد.", "Your report has been sent successfully"),
    ReportUserNotSuccessful("گزارش شما ارسال نشد.", "Your report has not been sent successfully"),
    NotValidateMessage("پیام دارای کلمات فیلتر شده میباشد.", "Your Message have bad Words"),

    ReportDocSuccessful("گزارش شما با موفقیت ارسال شد.",  "Your report has been sent successfully"),
    ReportDocNotSuccessful("گزارش شما با موفقیت ارسال نشد.",  "Your report has not been sent successfully"),
    NotUserFind("کاربری یافت نشد.", "User not finds!"),

    SuggestionSuccessful("ممنون از ارسال نظرات.", "Thank you for your suggestion"),
    SuggestionNotSuccessful("متاسفانه پیام شما ارسال نشد.", "Your message could not be delivered"),
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
