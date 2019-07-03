package Model;

import service.PublicFunctions;
import service.Search;

import java.util.List;

public class Admin {//todo baiad az User extend kone ia na? age bokone id ke to User hast to in iek chiz dige ast!
    //bahse in ke admin kar haie User nemitone bokone!

    //private final Integer idAdmin;

    public List<User> requestSearchAndFilterUser(String input, String field, String certificate, String university, String enterData, String enterYear) {
        boolean cancelSearch = false;
        List<User> resultUser = null;
        Search search = new Search();
        while(!cancelSearch) {
            List<User> users = search.searchUser(input);
            List<User> users1 = search.filterUser(field, certificate, university, enterData, enterYear);
            resultUser = PublicFunctions.intersection(users, users1);
            boolean searchAgain = true;
            while(searchAgain){
                List<User> users2 = search.searchUser(resultUser, input);
                List<User> users3 = search.filterUser(resultUser, field, certificate, university, enterData, enterYear);
                resultUser = PublicFunctions.intersection(users2, users3);
            }
        }
        return resultUser;
    }

    public List<Document> requestSearchAndFilterDocument(String input,String field, String certificate, String university, String course, long price, java.util.Date enterDate) {
        boolean cancelSearch = false;
        List<Document> resultDocument = null;
        Search search = new Search();
        while(!cancelSearch) {
            List<Document> documents = search.searchDocument(input);
            List<Document> documents1 = search.filterDocument(field, certificate, university, course, price, enterDate);
            resultDocument = PublicFunctions.intersection(documents, documents1);
            boolean searchAgain = true;
            while (searchAgain) {
                List<Document> documents2 = search.searchDocument(resultDocument, input);
                List<Document> documents3 = search.filterDocuments(resultDocument, field, certificate, university, course, price, enterDate);
                resultDocument = PublicFunctions.intersection(documents2, documents3);
            }
        }
        return resultDocument;
    }

}
