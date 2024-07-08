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
    public void write(int b) {
    }

    @Override
    public void write(byte[] b) throws IOException
    {
            ArrayList<Byte> result = new ArrayList<>();
            //the count will represent the number of times the last byte was repeated
            //the count is initialized to -128 because the byte representation of -128 is 10000000 and the byte representation of 127 is 01111111
            //so the count will be in the range of -128 to 127 because 256 is the range of a byte
            int count = -128;
            //the param - last will represent the last byte that was written
            int last = 0;
            for (int i = 0; i < b.length; i++)
            {
                if (i < 12)
                {
                    result.add(b[i]);
                    continue;
                }
                if (b[i] != last)
                {
                    last = b[i];
                    result.add((byte) count);
                    count = -127;
                    if (i == b.length - 1)
                    {
                        result.add((byte) count);
                    }
                    continue;
                }

                if (i == b.length - 1)
                {
                    result.add((byte) count);
                }
                //means that the last byte was repeated 127 times
                if (count == 127)
                {
                    result.add((byte) count);
                    result.add((byte) 0);
                    count = -128;
                }

                count++;
            }
            for (Byte result_byte : result)
            {
                out.write(result_byte);
            }
        }


}
