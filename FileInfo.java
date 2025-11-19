import java.io.File;

public class FileInfo {
    public static void main(String[] args) {
        crawl(new File("/Users/JustinMa/Library/CloudStorage/OneDrive-TheOverlakeSchool/5th Grade"));
    }

    public static void crawl(File f) {
        crawl(f, "");
    }

    private static void crawl(File f, String indent) {
        System.out.println(indent + f.getName());
        if (f.isDirectory()) {
            for (File c : f.listFiles()) {
                crawl(c, indent + "\t");
            }
        }
    }
}
