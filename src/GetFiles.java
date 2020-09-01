import java.io.File;

public class GetFiles {
    public static void main(String[] args) {
        String directory = "\\c:\\Windows";
        String fileName = "csc.exe";
        File file = new File(directory);
        if (!file.exists()) {
            System.out.println("directory does not exist");
            return;
        }
        String res = "";
        Long latest = Long.MIN_VALUE;
        dfs(directory, fileName, res, latest);
        System.out.println(res);
    }


    /*DFS search to get the files in current directory or its subdirectory
    * pathName: the current directory we will search
    * fileName: the target file name we aer looking for
    * res: the result absolute path we will return
    * latest: the time of the latest version with the same name as fileName
    *
    * idea:
    * get all subdirectories and files under the current directory
    * case1. if its a file, call accept() to check if its the target file name
    *           if yes, check if its the latest version with latest modified time
    *                   if yes, update the result resPath and latest time
    * case2. if its a folder, recursively call the function to check all its subdirectory
    * */
    public static void dfs(String pathName, String fileName,String res, Long latest) {// 递归查找包含关键字的文件
        File dir = new File(pathName);		// 创建一个File对象

        if (!dir.exists() || !dir.isDirectory()) {	// 判断目录是否存在
            System.out.println("Input is not a valid directory or does not exist!");
            return;
        }

        File[] folders = dir.listFiles();
        for(int i = 0; i < folders.length; i++){
           if(folders[i].isFile()){
               if(accept(folders[i], fileName)){
                   if(folders[i].lastModified() > latest){
                       res = folders[i].getAbsolutePath();//update the res path as the cur file path
                       latest = folders[i].lastModified();//uodate the latest version time as cur one
                   }
               }
           }else if (folders[i].isDirectory()){
               dfs(folders[i].getPath(), fileName, res, latest);
           }
        }
    }


    /*
    * accept method to determine if the current file has the same name with the target file name
    * */
    public static boolean accept(File file, String target){
        String curName = file.getName();
        if(curName.equals(target)){
            return true;
        }
        return false;
    }

}
