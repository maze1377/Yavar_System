package FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class WrapperFile implements Component_File {
        public List<Component_File> list=new ArrayList<>();

    public void addFiles(WrapperFile file) {
        list.addAll(file.getList());
        }

        public void removeFile(Component_File file){

        }
        @Override
        public void code(File file) {
        }

        @Override
        public void decode(File file) {
        }

    public List<Component_File> getList() {
        return list;
    }
}
