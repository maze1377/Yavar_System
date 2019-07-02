package Model;

import DB.Db_Handler;
import FileManager.WrapperFile;
import Tools.Code;
import Tools.Decode;
import setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class Document implements Code<Document> {
    private final Integer idDocument;
    private final User publisher;
    private final Date publishDate;
    private String name;
    private Type_FreeDom freeDom;
    private List<Hashtag> hashtagList;
    private Double cost;
    private String details;
    private String nameOfWriter;
    private List<PreViews> preViewsList;//check max size in seter and adder !//todo
    private Date writeDate;
    private String correspondingTeacher;
    private String defects;
    private Field field;
    private Institution institution;
    private Level level;
    private WrapperFile files;
    private Doc_State stateDoc;
    private ArrayList<Score> scores;
    private ArrayList<Comment> comments;

    public static boolean Validator(User publisher, String name, Type_FreeDom freeDom, List<Hashtag> hashtagList, Double cost, String details) {
        return true;
    }

    private Document(User publisher, String name, Type_FreeDom freeDom, List<Hashtag> hashtagList, Double cost, String details) {
        this(publisher, name, freeDom, hashtagList, cost, details, new Date());
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);

    }

    public boolean removeComment(Comment comment) {
      for(int w = 0 ; w<comments.size() ; w++){
          if(comment.user.equals(comments.get(w).user)){
              comments.remove(w);
              return true;
          }
      }
      return false;

    }

    public static boolean Validator(List<String> codes) {
        return true;
    }

    protected Document clone() {
        return this;
    }

    public void Update(List<String> codes) {
        Db_Handler.getDatabaseHandler(Setting.Db_Table_name.templateOfDocs).saveLastVertionOfDoc(this);
        String concats = "";
        for (String xxx : codes) {
            concats += xxx;
        }
        Document document = DocumentBuilder.decodeObject(concats);
        Db_Handler.getDatabaseHandler(Setting.Db_Table_name.Document).updateDocument(this);
    }

    public Document ChangeForPrew(List<String> Userinput, WrapperFile files) {
        Document temp = this.clone();
        temp.files.addFiles(files);
        //
        return temp;
    }


    private Document(User publisher, String name, Type_FreeDom freeDom, List<Hashtag> hashtagList, Double cost, String details, Date publishDate) {
        this.publisher = publisher;
        this.name = name;
        this.freeDom = freeDom;
        this.hashtagList = hashtagList;
        this.cost = cost;
        this.details = details;
        this.publishDate = publishDate;
        this.idDocument = Setting.genarateIdDoc();
        scores = new ArrayList();
        comments = new ArrayList<>();
    }

    @Override
    public String code(Document obj) {
        return null;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public User getPublisher() {
        return publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getName() {
        return name;
    }

    public Type_FreeDom getFreeDom() {
        return freeDom;
    }

    public List<Hashtag> getHashtagList() {
        return hashtagList;
    }

    public Double getCost() {
        return cost;
    }

    public String getDetails() {
        return details;
    }

    public String getNameOfWriter() {
        return nameOfWriter;
    }

    public List<PreViews> getPreViewsList() {
        return preViewsList;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public String getCorrespondingTeacher() {
        return correspondingTeacher;
    }

    public String getDefects() {
        return defects;
    }

    public ArrayList<Score> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Score score) {
       scores.add(score);
    }

    public boolean removeScore(Score score) {
       for(int w = 0 ; w< scores.size();w++){
           if(score.user.getUserName() .equals(scores.get(w).user.getUserName())){
               scores.remove(w);
               return true;
           }
       }
       return false;
    }

    public int getAverageScore() {
        int sum = 0;
        for(int w = 0 ; w< scores.size();w++){
         w+= scores.get(w ).getScoreNum();
            }
        return  sum/scores.size();
        }


    public boolean updateScore(Score score) {
        for(int w = 0 ; w< scores.size();w++){
            if(score.user.getUserName() .equals(scores.get(w).user.getUserName())){
                scores.remove(w);
                scores.add(score);
                return true;
            }
        }
        return false;
    }

    public Field getField() {
        return field;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Level getLevel() {
        return level;
    }

    public View preview() {
        return null;
    }

    public static class DocumentBuilder implements Decode<DocumentBuilder> {
        private Document obj;

        public DocumentBuilder(Document obj) {
            this.obj = obj;
        }

        public DocumentBuilder build(User publisher, String name, Type_FreeDom freeDom, List<Hashtag> hashtagList, Double cost, String details) {
            return new DocumentBuilder(new Document(publisher, name, freeDom, hashtagList, cost, details));
        }

        public DocumentBuilder build(User publisher, String name, Type_FreeDom freeDom, List<Hashtag> hashtagList, Double cost, String details, Date publishdate) {
            return new DocumentBuilder(new Document(publisher, name, freeDom, hashtagList, cost, details, publishdate));
        }

        public DocumentBuilder setName(String name) {
            obj.name = name;
            return this;
        }

        public DocumentBuilder setFreeDom(Type_FreeDom freeDom) {
            obj.freeDom = freeDom;
            return this;
        }

        public DocumentBuilder addHashtag(Hashtag hashtag) {
            obj.hashtagList.add(hashtag);
            return this;
        }

        public DocumentBuilder removeHashtag(Hashtag hashtag) {
            obj.hashtagList.remove(hashtag);
            return this;
        }

        public DocumentBuilder setCost(Double cost) {
            obj.cost = cost;
            return this;
        }

        public DocumentBuilder setDetails(String details) {
            obj.details = details;
            return this;
        }

        public DocumentBuilder setNameOfWriter(String nameOfWriter) {
            obj.nameOfWriter = nameOfWriter;
            return this;
        }

        public DocumentBuilder addPreViews(PreViews preViews) {
            //todo
            return this;
        }

        public DocumentBuilder removePreViews(PreViews preViews) {
            //todo
            return this;
        }

        public DocumentBuilder setFiles(WrapperFile files) {
            obj.files = files;
            return this;
        }

        public DocumentBuilder setStateDoc(Doc_State stateDoc) {
            obj.stateDoc = stateDoc;
            return this;
        }

        public DocumentBuilder setWriteDate(Date writeDate) {
            obj.writeDate = writeDate;
            return this;
        }

        public DocumentBuilder setCorrespondingTeacher(String correspondingTeacher) {
            obj.correspondingTeacher = correspondingTeacher;
            return this;
        }

        public DocumentBuilder setDefects(String defects) {
            obj.defects = defects;
            return this;
        }

        public DocumentBuilder setField(Field field) {
            obj.field = field;
            return this;
        }

        public DocumentBuilder setInstitution(Institution institution) {
            obj.institution = institution;
            return this;
        }

        public DocumentBuilder setLevel(Level level) {
            obj.level = level;
            return this;
        }

        public Document getObj() {
            return obj;
        }

        @Override
        public DocumentBuilder decodeObject(String code) {
            return null;
        }
    }

}
