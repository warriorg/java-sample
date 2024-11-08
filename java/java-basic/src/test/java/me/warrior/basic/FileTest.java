package me.warrior.basic;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileTest {

    @Test
    public void wirte() throws IOException {
        byte[] body = new byte[0];
        String filename = "//Users/warriorg/Downloads/ss222wwww2dsssssssdddf/xxxds222fsdfs/xxxx.txt";
        File file = new File("/Users/warriorg/Downloads/");

        Path path = Path.of(filename);
        try {
            Files.createDirectories(path.getParent());
//            if (!zipFile.exists()) {
//                Files.createFile(zipFile);
//                if (!zipFile.createNewFile()) {
//                    logger.error("文件生成失败 {} {}", property, zipFile.getPath());
//                    throw new ArgumentException("文件生成失败");
//                }
//            }
            try (OutputStream out = Files.newOutputStream(path)) {
                out.write(body);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
