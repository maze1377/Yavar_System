import java.util.List;

public class Keeper {//todo mikham bezaram field faghat admin ezafe kone vali hastagh va institution ro karbar ham betone!
    private List<Hashtag> hashtagList;
    private List<Field> fieldList;
    private List<Institution> institutionList;

    public Keeper(List<Hashtag> hashtagList, List<Field> fieldList, List<Institution> institutionList) {//init with Db
        this.hashtagList = hashtagList;
        this.fieldList = fieldList;
        this.institutionList = institutionList;
    }
    public void addHashtag(Hashtag hashtag){
    }
    public void removeHashtag(Hashtag hashtag){

    }
    public void addField(Field field){

    }
    public void removeField(Field field){

    }
    public void addInstitution(Institution institution){

    }
    public void removeInstitution(Institution institution){

    }
}
