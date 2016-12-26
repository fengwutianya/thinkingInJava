package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by xuan on 2016/12/26 0026.
 */
public class DirList2 {
    public static FilenameFilter filter(String regex) {
        return new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(filter(args[0]));
        for (String dirItem: list)
            System.out.println(dirItem);
    }
}
