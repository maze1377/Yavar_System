package Model.Block;

public enum BlockType {
    Document("Document"),
    User("User"),
    ConnectionLimit("ConnectionLimit"),
    Comment("Comment"),
    ;
    private String type;
    BlockType(String str){
        this.type = str;
    }
}
