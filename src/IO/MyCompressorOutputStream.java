package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MyCompressorOutputStream extends OutputStream {
    private OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }
    @Override
    public void write(int b) throws IOException {
        this.out.write(b);
    }

    @Override

    // 24 bytes for the maze details
    //insert the 1's indexes into the stream
    //creating a stream of 1's indexes representing the maze
    public void write(byte[] bytes) throws IOException
    {
        int count_for_256 = 0;
        for (int i=0;i< bytes.length;i++)
        {
            count_for_256 = i/256;
            byte b = bytes[i];
            if(i<24)
            {
                write(b);
                continue;
            }
            //if the byte is 1, insert its index into the stream

            if(b==1)
            {
                write(i-count_for_256*256);
            }

        }

    }



}
