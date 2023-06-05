package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MemoInput implements Comparator<Memo>{
    //이름, 제목, 내용, 비밀번호를 입력 받아야 한다.
    private ArrayList<Memo> memos;
    private int contentNumber;
    public MemoInput(){
        memos = new ArrayList<>();
        contentNumber = 0;

    }
    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("이름");
        String name = sc.nextLine();

        System.out.println("제목");
        String title = sc.nextLine();

        System.out.println("내용");
        String memoContent = sc.nextLine();

        System.out.println("비밀 번호");
        int passWord = sc.nextInt();

        LocalDateTime localDateTime = LocalDateTime.now();


        memos.add(new Memo(++contentNumber, name, title, memoContent, passWord, localDateTime));
    }

    public List<Memo> getMemos() {

        return memos;
    }

    @Override
    public int compare(Memo o1, Memo o2) {
        //측정할 시간
        LocalDateTime age0 = o1.localDateTime;
        //기준시간
        LocalDateTime age1 = o2.localDateTime;

        //    compareTo()
        //   isAfter() - 인자보다 미래 시간이라면 true 반환
        //   isBefore() - 인자보다 과거 시간이면 true 반환
        //   isEqual() - 인자와 같은 시간이면 true 반환

        if(age0.isEqual(age1)){
            return 0;
        }
        else if(age0.isAfter(age1)){
            return 1;
        } else{
            return -1;
        }

    }

}