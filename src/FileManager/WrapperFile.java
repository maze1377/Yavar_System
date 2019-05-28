package FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class WrapperFile implements Component_File {
        public List<Component_File> list=new ArrayList<>();
        public void addFile(Component_File file){

        }
        public void removeFile(Component_File file){

        }
        @Override
        public File code(File file) {
                return null;
        }

        @Override
        public File decode(File file) {
                return null;
        }

}
