package Management;

import Model.Block.BlockType;
import Model.Block.Blockable;
import Model.User;

public class BlockManagement {
    public static void block(Blockable input, BlockType type){
        if(input.block(type));
    }

    public static boolean isValidToLogin(User user){
        return user.negScoreExceeds(BlockType.ConnectionLimit) != -1;
    }
    

}
