package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SimpleCompressorOutputStream extends OutputStream {
    private OutputStream out;

    public SimpleCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException
    {
        out.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        // Check if the input bytes are valid and have a length of at least 25
        if (b == null || b.length < 24)
            throw new IOException();

        int i = 0;
        for (; i < 24; i++)
        {
            // Write the first 24 bytes as-is to the output stream
            write(b[i]);
        }
        int count = 0;
        int curr = 0;
        for (; i < b.length; i++)
        {
            if (b[i] == curr)
            {
                // If the current byte is equal to the previous byte, increment the counter
                if (count == 256)
                {
                    // If the counter reaches the maximum value (256), write a marker value of 255
                    // followed by a counter value of 0 to the output stream
                    write(255);
                    write(0);
                    count = 0;
                }
                count++;
            }
            else
            {
                // If the current byte is different from the previous byte, write the counter value
                write(count);
                curr = b[i]; // Update the current byte
                count = 1;
            }
        }
    }

}
