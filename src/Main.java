package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemoInput memoInput = new MemoInput();
        Edit edit = new Edit(); // 인스턴스 생성
        print(memoInput);
    }

    public static void print(MemoInput memoInput){
        // 주석만 추가
        System.out.println("[메모장]");
        System.out.println("1. 입력");
        System.out.println("2. 목록 보기");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 종료");

        hendle(memoInput);
    }


    public static void hendle(MemoInput memoInput) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input){
            case 1:
                memoInput.input();
                print(memoInput);
                break;
            case 2:
                //메모목록 보여주기
                memoListPrint(memoInput);
                break;
            case 3:
                //수정
                //메모목록 보여주기
                memoListPrint(memoInput);
                // 정보들 중 선택
                choiceMemo(memoInput);
                break;
            case 4:
            case 5:
                exitNotepad();
                break;
        }
    }

    public static void exitNotepad() {
        System.out.println("이용해주셔서 감사합니다.");;
        System.exit(0);
    }
    //메모 내용 출력
    private static void memoListPrint(MemoInput memoInput) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<memoInput.getMemos().size(); i++){
            //시간데이터 변경
            String localDateTimeFormat
                    = memoInput.getMemos().get(i).localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm"));

            //메모 내용 출력
            System.out.println(memoInput.getMemos().get(i).contentNumber+". "+memoInput.getMemos().get(i).title+" "+localDateTimeFormat);
        }

        System.out.println("1. 돌아가기 2. 수정하기");
        if(sc.nextInt() == 1){
            //메인화면
            print(memoInput);
        }else {
            //수정으로 바로
            choiceMemo(memoInput);
        }
    }

    //글 번호로 분별
    private static void choiceMemo(MemoInput memoInput){
        Scanner sc = new Scanner(System.in);
//        int selectNumber = sc.nextInt() -1;
        //변경될 내용 저장 리스트
        Memo newmMemo;
        for(int i = 1 ; i <= memoInput.getMemos().size(); i++){
            if(sc.nextInt() != memoInput.getMemos().get(i).contentNumber){
                //메모가 존재 하지 않을 경우
                System.out.println("존재하지 않는 메모입니다.");

                memoListPrint(memoInput);

            }else{
                //존재 하는 메모가 있을 경우
                //비밀번호 입력후 확인
                System.out.println("비밀번호를 입력하세요");
                int pass = sc.nextInt();
                if(pass == memoInput.getMemos().get(i).passWord){
                    sc.nextLine();
                    //현재 입력된 메모 출력
                    Edit edit = new Edit();
                    edit.update(memoInput);

                } else{
                    System.out.println("비밀번호가 다릅니다");
                    memoListPrint(memoInput);
                }

            }

        }
    }
}