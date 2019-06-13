import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/6/12 20:14
 */
public class RLEtxt {
    public static void main(String[] args) {
        RLEtxt rle = new RLEtxt();
        String txtPath = "F:\\ASCII.txt";
        String enOutPath = "F:\\EncodeASCII.txt";
        String deOutPath = "F:\\DecodeASCII.txt";
        rle.RLEEncode(txtPath, enOutPath);
        System.out.println("RLE Encode success !，Path:" + enOutPath);
        rle.RLEDecode(enOutPath, deOutPath);
        System.out.println("RLE Decode success !，Path:" + deOutPath);
    }
    /**
     * txt read
     * @param fliePath
     * @return
     */
    private BufferedReader readFile(String fliePath) {
        BufferedReader br = null;
        try {
            FileReader reader = new FileReader(fliePath);
            br = new BufferedReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    /**
     * write txt
     * @param txt
     * @param out
     */
    private void writeFile(List<String> txt, BufferedWriter out) throws IOException{
        for (int i = 0; i < txt.size(); i++) {
            out.write(txt.get(i));
        }
    }

    /**
     * RLE decode
     * @param inPath
     * @param outPath
     */
    public void RLEEncode(String inPath, String outPath) {
        BufferedReader reader = readFile(inPath);
        try {
            File writename = new File(outPath);
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            String line;
            while ((line = reader.readLine()) != null) {
                //转化为数组处理
                String[] strings = line.split(" ");
                List<String> resultLine = encodeCore(strings);
                writeFile(resultLine, out);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //标志
    //222 222 222 223 223 ---> 3#222 2#223
    private final String FLAG = "#";

    /**
     * 对文本按照rle算法进行编码：
     * 222 222 222 223 223 ---> 3#222 2#223
     * @param strings
     * @return
     */
    private List<String> encodeCore(String[] strings) {
        if (strings == null) {
            return null;
        }
        String nowStr = null;
        List<String> resultStr = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if (nowStr == null) {
                nowStr = strings[i];
                count++;
            } else {
                //相等的像素值序列需要压缩
                if (nowStr.equals(strings[i])) {
                    count++;
                } else {
                    //重复结束
                    if (count == 1) {
                        resultStr.add(nowStr);
                    } else {
                        resultStr.add(count + FLAG +nowStr);
                    }
                    resultStr.add(" ");
                    count = 1;
                    nowStr = strings[i];
                }
            }
        }
        String end;
        if (count == 1) {
            end = nowStr;
        } else {
            end = count + FLAG +nowStr;
        }
        resultStr.add(end);
        resultStr.add(" ");
        resultStr.add("\r\n");
        return resultStr;
    }

    /**
     * RLE encode
     * @param inPath
     * @param outPath
     */
    public void RLEDecode(String inPath, String outPath) {
        BufferedReader reader = readFile(inPath);
        try {
            File writename = new File(outPath);
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            String line;
            while ((line = reader.readLine()) != null) {
                //转化为数组处理
                String[] strings = line.split(" ");
                List<String> resultLine = decodeCore(strings);
                writeFile(resultLine, out);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *RLE decode
     * @param strings
     * @return
     */
    private List<String> decodeCore(String[] strings) {
        if (strings == null) {
            return null;
        }
        List<String> resultStr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains(FLAG)) {
                String[] s = strings[i].split(FLAG);
                int count = Integer.valueOf(s[0]);
                while (count > 0) {
                    //""的特殊情况
                    if (s.length == 1) {
                        resultStr.add(" ");
                    } else {
                        resultStr.add(s[1]);
                        resultStr.add(" ");
                    }
                    count--;
                }
            } else {
                resultStr.add(strings[i]);
                resultStr.add(" ");
            }
        }
        resultStr.add("\r\n");
        return resultStr;
    }
}
