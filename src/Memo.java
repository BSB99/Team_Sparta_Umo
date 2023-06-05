package src;

import java.time.LocalDateTime;

public class Memo {
    int contentNumber;
    String name;
    String title;
    String memoContent;
    int passWord;
    LocalDateTime localDateTime;

    public Memo(int contentNumber,String name, String title, String memoContent, int passWord,LocalDateTime localDateTime){
        this.contentNumber = contentNumber;
        this.name = name;
        this.title = title;
        this.memoContent = memoContent;
        this.passWord = passWord;
        this.localDateTime = localDateTime;
    }

}