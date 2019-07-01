package setting;

import Model.Admin;

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

    public static void setCurentState(stateLan curentState) {
        Setting.curentState = curentState;
    }

    public enum stateLan {
        En,
        Fa
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
