package DB;

public abstract class Database {
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "Yavar";
    private static final String KEY_NAME = "mazTeam";
    private static final String KEY_PH_NO = "984532167";
    private static final String URL_Connection = "yavar.com/Db";

    public abstract boolean isOpen();

    public boolean validDatabase() {
        return this != null && this.isOpen();
    }
}
