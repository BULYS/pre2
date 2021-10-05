import java.io.*;

public class Compiler {
    public static void main(String [] args) throws IOException {
        Reader reader = new Reader(args[0]);

        String line;
        while ((line = reader.getBufferedReader().readLine()) != null) {
            String str="";
            for(int i=0; i<line.length(); i++) {
                char ch = line.charAt(i);
                str = "";
                if(isSpace(ch)) {

                }
                else if(isDigit(ch)) {
                    while(isDigit(ch)) {
                        str+=ch;

                        i++;
                        if (i == line.length()) {
                            break;
                        }
                        ch = line.charAt(i);
                    }
                    i--;
                    System.out.println("Number("+str+")");
                }
                else if(isLetter(ch)) {
                    while (isLetter(ch)||isDigit(ch)) {
                        str+=ch;
                        i++;
                        if (i == line.length()) {
                            break;
                        }
                        ch = line.charAt(i);
                    }
                    i--;
                    if (isKey(str) != "ToT") {
                        System.out.println(isKey(str));
                    }
                    else
                        System.out.println("Ident("+str+")");
                }
                else if (ch=='=') {
                    if (line.charAt(i+1)=='=') {
                        System.out.println("Eq");
                        i++;
                    }
                    else
                        System.out.println("Assign");
                }
                else switch (ch) {
                        case ';':
                            System.out.println("Semicolon");
                            break;
                        case '(':
                            System.out.println("LPar");
                            break;
                        case ')':
                            System.out.println("RPar");
                            break;
                        case '{':
                            System.out.println("LBrace");
                            break;
                        case '}':
                            System.out.println("RBrace");
                            break;
                        case '+':
                            System.out.println("Plus");
                            break;
                        case '*':
                            System.out.println("Mult");
                            break;
                        case '/':
                            System.out.println("Div");
                            break;
                        case '<':
                            System.out.println("Lt");
                            break;
                        case '>':
                            System.out.println("Gt");
                            break;
                        default:
                            System.out.println("Err");
                            System.exit(0);
                }

            }
        }

    }
    //判断是否是字母
    static boolean isLetter(char letter)
    {
        if((letter >= 'a' && letter <= 'z')||(letter >= 'A' && letter <= 'Z') || letter=='_')
            return true;
        else
            return false;
    }
    //判断是否是数字
    static boolean isDigit(char digit)
    {
        if(digit >= '0' && digit <= '9')
            return true;
        else
            return false;
    }
    static boolean isSpace(char ch)
    {
        if(ch==' '||ch=='\n'||ch=='\t'||ch=='\r')
            return true;
        else
            return false;
    }
    static String isKey(String str) {
        if (str.equals("if"))
            return "If";
        else if(str.equals("else"))
            return "Else";
        else if(str.equals("while"))
            return "While";
        else if(str.equals("break"))
            return "Break";
        else if(str.equals("continue"))
            return "Continue";
        else if(str.equals("return"))
            return "Return";
        else
            return "ToT";
    }
}
class Reader {
    private String in ;
    private File file;
    private FileReader reader;
    private BufferedReader bufferedReader;

    public Reader(String file) throws FileNotFoundException {
        this.in = file;
        this.file = new File(in);
        this.reader = new FileReader(file);
        this.bufferedReader = new BufferedReader(reader);
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}