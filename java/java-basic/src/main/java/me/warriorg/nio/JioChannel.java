package me.warriorg.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.time.Duration;
import java.time.Instant;

public class JioChannel {
    public static void main(String[] args) throws IOException {
        JioChannel channel = new JioChannel();
        String from = "/Users/warriorg/Downloads/output.rar";
        String to = "/Users/warriorg/Downloads/xxx/output.rar";
        Instant start = Instant.now();
        channel.copy(from, to);
        System.out.println("copy:" + Duration.between(start, Instant.now()).toMillis());
        start = Instant.now();
        channel.zeroCopy(from, to);
        System.out.println("zero Copy:" + Duration.between(start, Instant.now()).toMillis());

        start = Instant.now();
        Files.copy(Path.of("/", from).normalize(), Path.of("/", to).normalize(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File Copy:" + Duration.between(start, Instant.now()).toMillis());

    }

    public void zeroCopy(String from, String to) throws IOException {

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(from).getChannel();
            destination = new FileOutputStream(to).getChannel();
            source.transferTo(0, source.size(), destination);
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }

        }
    }

    public void copy(String from, String to) throws IOException {

        byte[] data = new byte[8 * 1024];
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long bytesToCopy = new File(from).length();
        long bytesCopied = 0;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            while (bytesCopied < bytesToCopy) {
                fis.read(data);
                fos.write(data);
                bytesCopied += data.length;
            }
            fos.flush();
        } finally {
            if(fis != null) {
                fis.close();
            }
            if(fos != null) {
                fos.close();
            }
        }

    }
}
