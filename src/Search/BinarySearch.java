package Search;

import java.util.Scanner;
// 이진 검색
/*
BinarySearch는 자바에서 API로 제공해줌. 검색해서 사용 가능.
binarySearch를 사용하면 됨. (해당 내용은 BinarySerachTester.java 에서 확인 가능.)

 */

class BinarySearch {
    // 요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색합니다.
    int binSearch(int[] a, int n, int key) {
        int pl = 0;			// 검색 범위의 첫 인덱스
        int pr = n - 1;		// 검색 범위의 끝 인덱스

        do { //검색을 반복 할 때 마다 검색 범위가 절반이 되므로 검색에 필요한 비교횟수의 평균값은 log n 임을 알 수 있다. O(log n)
            int pc = (pl + pr) / 2;		// 중앙 요소의 인덱스
            if (a[pc] == key)
                return pc;				// 검색 성공!
            else if (a[pc] < key)
                pl = pc + 1;			// 검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1;			// 검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1;						// 검색 실패!
    }
    public void run(){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수：");
        int num = stdIn.nextInt();
        int[] x = new int[num];				// 요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]：");			// 첫 요소 입력
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]：");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);		// 바로 앞의 요소보다 작으면 다시 입력
        }

        System.out.print("검색할 값：");		// 키값을 입력
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);	// 배열x에서 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) x[" + idx + "]에 있습니다.");
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        bs.run();
    }
}