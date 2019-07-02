package Model;

import Model.Block.BlockType;
import Model.Block.BlockTypeException;
import Model.Block.Blockable;

public class Comment implements Blockable {
    String body;
    Date dateOfComment;
    User user;
    String name;

    public Comment(String body, Date dateOfComment, User user, String name, boolean show_name) {
        this.body = body;
        this.dateOfComment = dateOfComment;
        this.user = user;
        this.name = name;
        this.show_name = show_name;
    }

    boolean show_name;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateOfComment() {
        return dateOfComment;
    }

    public void setDateOfComment(Date dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int negScoreExceeds(BlockType type) throws BlockTypeException {
        if (type == BlockType.Comment) {
            return 0;
        } else {
            throw new BlockTypeException(type);
        }
    }

    @Override
    public boolean block(BlockType type) throws BlockTypeException {
        if (type == BlockType.Comment) {
            return this.user.block(type);
        } else {
            throw new BlockTypeException(type);
        }
    }
}
