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
    public void write(int b) {
    }

    @Override
    // This function compress the byte array that represent the maze to a smaller byte array that represent the maze
    // The first 12 bytes are the maze details , the rest  are the maze cells
    // The function compress the maze cells from 8 bytes to one byte
    //because each cell can be 0 or 1, so we can represent 8 cells in one byte
    public void write(byte[] b) throws IOException {
        ArrayList<Byte> result = new ArrayList<>();
        int current = 0;
        byte[] array_of_8 = new byte[8];
        for (int i = 0; i < b.length; i++) {
            if (i < 12)
            {
                // Write the first 10 bytes as is
                // The first 10 bytes are the maze details
                result.add(b[i]);
                continue;
            }
            //create a byte array of 8 cells and turn it to a single byte
            array_of_8[current] = b[i];
            current++;
            if (current == 8) {
                // Write the compressed byte
                // The compressed byte is the 8 cells in one byte
                result.add(byte_arr_to_byte_num(array_of_8));
                // Reset the array of 8 cells
                current = 0;
            }
            // If the last byte is not a full byte
            // Fill the rest of the byte with 0
            if (i+1 == b.length && current != 0)
            {
                while(current < 8)
                {
                    array_of_8[current] = 0;
                    current++;
                }
                result.add(byte_arr_to_byte_num(array_of_8));
            }
        }
        // Write the compressed maze to the output stream
        for (Byte B : result)
        {
            out.write(B);
        }
    }
    private byte byte_arr_to_byte_num(byte[] arr) {
        int result = 0;
        for (int i = 7; i >= 0; i--) {
            result += (arr[i]) * (int) Math.pow(2, 7 - i);
        }
        return (byte) (result - 128);
    }



}
