package Model.Block;

public interface Blockable {
    public int negScoreExceeds(BlockType type) throws BlockTypeException;
    public boolean block(BlockType type) throws BlockTypeException;
    public void checkDeadline();
}
