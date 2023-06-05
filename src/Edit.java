package src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit extends MemoInput {

   public Edit(){}
   public void update(MemoInput memoInput){

      memoInput.getMemos().clear(); // 받은 데이터 삭제

      Scanner sc = new Scanner(System.in);

      ArrayList<Memo> updateMemo = new ArrayList<>(); // 값 넣을 arrayList 생성


      // 변경값 입력
      System.out.print("변결한 이름: ");
      String newName = sc.nextLine();

      System.out.print("변결한 제목: ");
      String newTitle = sc.nextLine();

      System.out.print("변결한 내용: ");
      String newmemoContent = sc.nextLine();

      LocalDateTime localDateTime = LocalDateTime.now(); // 수정 시간으로 변경





      //현재시간







   }

}
