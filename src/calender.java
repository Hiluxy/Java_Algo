/*2번. 신대륙 발견
예지는 오늘 항해99를 시작했다. 성격이 급한 예지는 항해 1일 차부터 언제 수료를 하게될 지 궁금하다.
항해 1일 차 날짜를 입력하면 98일 이후 항해를 수료하게 되는 날짜를 계산해주는 알고리즘을 만들어보자.*/

public class calender {
        public String solution(int month, int day) {
            String answer = "";
            int[] month_day= {0,31,28,31,30,31,30,31,31,30,31,30,31};
            int sum=98;
            sum-=(month_day[month]-day);
            int i=1;
            while(true){
                sum-=month_day[month+i];
                i++;
                if(month+i>=12){
                    month-=12;
                }
                if(sum<=month_day[month+i]){
                    break;
                }
            }
            answer=(month+i)+"월"+sum+"일";
            return answer;
        }

        public static void main(String[] args) {
            calender method = new calender();
            System.out.println(method.solution(6, 22));
        }

}
