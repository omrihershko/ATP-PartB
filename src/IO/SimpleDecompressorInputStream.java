package IO;
import java.io.IOException;
import java.io.InputStream;
public class SimpleDecompressorInputStream extends InputStream
{
    private InputStream in;
    public SimpleDecompressorInputStream(InputStream in)
    {
        this.in = in;
    }
    public int read() throws IOException
    {
        return in.read();
    }
    public int read(byte[] bytes) throws IOException
    {
        // Check if the input bytes are valid
        if (bytes.length == 0)
            return -1;

        // Read the first 24 bytes from the input stream
        for (int i = 0; i < 24; i++) {
            int input = read();
            bytes[i] = (byte) input;
        }
        // Decompress the remaining bytes using the flag value
        int flag = 0;
        int input = read();
        int index = 24;
        while(input != -1 && index<bytes.length)
        {
            for(int i =0; i<input;i++)
            {
                bytes[index] = (byte)flag;
                index++;
            }
            flag = 1-flag;
            input = read();
        }

        return 1;
    }



}
