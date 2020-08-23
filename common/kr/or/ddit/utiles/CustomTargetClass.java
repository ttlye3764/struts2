package kr.or.ddit.utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

// 사용자 정의 태그 작성을 위해 활용되는 자원
// 1. 사용자 정의 태그는 특정 클래스 메서드를 대상으로 작성하고 활용
//    메서드 선언시 반환타입과 파라미터 타입은 반드시 WrapperClass타입이여야 함
// 	  ex) int (x) -> integer (o)
// 2. 메서드 접근 지정자는 반드시 public 이고, static 선언과 동반되어야 함.

public class CustomTargetClass {
	
	public CustomTargetClass() {
		
	}
	
	public CustomTargetClass(int i) {
		
	}

	public static Integer plus(Integer i, Integer j) {
		return i + j;
	}

	public static Integer multiple(String i, Integer j) {
		return Integer.parseInt(i) * j;
	}

	public static String today() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD");
		return dateFormat.format(new Date());
	}

	public static Integer charCount(String target, String delim){
		int idx = 0;
		int cnt = 0;
		
		// "1234561" 중에 "1"은 몇번 포함되어 있는지
		idx = target.indexOf(delim);
		  for(; idx != -1; cnt++){
		         target = target.substring(target.indexOf(delim)+1,target.length());
		         idx = target.indexOf(delim);
		      }
		      return cnt;

	}
}
