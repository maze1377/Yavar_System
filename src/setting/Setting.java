package setting;

import Model.Admin;
import Model.Date;

public class Setting {
    public static Integer genarateIdDoc(){
            return null;
    }

    public static Integer genarateIdMessage() {
        return null;
    }

    public static Admin SYSTEM = new Admin();//todo
    public static stateLan curentState = stateLan.Fa;

    public static long minCredit = 10000;
    public static long minDateOfLogin = 5;
    public static long maxDevices = 4;
    public static void setCurentState(stateLan curentState) {
        Setting.curentState = curentState;
    }

    public static Date getToday (){
        Date date = new Date();
        return date;
    }

    public enum stateLan {
        En,
        Fa
    }

    public enum BlockMinimumDefault{
        ConnectionLimit(10),
        Document(10),
        User(10),
        Comment(10),

        ;

        private int val;
        BlockMinimumDefault(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public enum Db_Table_name {
        User("Users"),
        Document("Documents"),
        Admin("Admins"),
        Field("Fields"),
        Hashtag("Hashtags"),
        Institution("Institutions"),
        Message("Message"),
        Report("Report"),
        Comment("Comment"),
        Suggestion("Suggestion"),
        Support("Support"),
        UserReport("UserReport"),
        DocReport("DocReport"),
        templateOfDocs("templateOfDocs"),
        ;
        private String Table_name;

        Db_Table_name(String table_name) {
            Table_name = table_name;
        }

        public String getTable_name() {
            return Table_name;
        }
    }
}
