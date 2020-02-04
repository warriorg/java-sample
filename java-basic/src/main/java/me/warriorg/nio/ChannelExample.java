package me.warriorg.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;

/**
 * @author warrior
 */
public class ChannelExample {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(ChannelExample.class.getClassLoader().getResource("data/nio-data.txt").getFile(), "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            Logger.getLogger(ChannelExample.class.getSimpleName()).info("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
