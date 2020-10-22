import java.util.*;

class Student{
    Student(int g){
        grade=g;
    }
    public int grade;
}
class SortingStudentsByGPA implements Comparator<Student> {
    void quickSort(Student[] numbers, int left, int right)
    {
        Student pivot;
        int l_hold = left;
        int r_hold = right;
        pivot = numbers[left];
        while (left < right)
        {
            while (compare(numbers[right],pivot)==1 ||(compare(numbers[right],pivot)==0)&& (left < right))
                right--;
            if (left != right)
            {
                Student tmp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = tmp;
                left++;
            }
            while (compare(numbers[left],pivot)==-1 ||(compare(numbers[left],pivot)==0) && (left < right))
                left++;
            if (left != right)
            {
                Student tmp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = tmp;
                right--;
            }
        }
        numbers[left] = pivot;
        int pivot1 = left;
        left = l_hold;
        right = r_hold;
        if (left < pivot1)
            quickSort(numbers, left, pivot1 - 1);
        if (right > pivot1)
            quickSort(numbers, pivot1 + 1, right);
    }

    public int binarySearch(Student[] sortedArray, Student key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (compare(sortedArray[mid],key)==-1) {
                low = mid + 1;
            } else if (compare(sortedArray[mid],key)==1) {
                high = mid - 1;
            } else if (equals(sortedArray[mid], key)) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int linearSearch(Student arr[], Student elementToSearch) {

        for (int index = 0; index < arr.length; index++) {
            if (equals(arr[index],elementToSearch))
                return index;
        }
        return -1;
    }
    public int linearSearchRev(Student arr[], Student elementToSearch) {

        for (int index = arr.length-1; index >= 0; index--) {
            if (equals(arr[index],elementToSearch))
                return index;
        }
        return -1;
    }

    public int binarySearchRev(Student[] sortedArray, Student key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (compare(sortedArray[mid],key)==1) {
                low = mid + 1;
            } else if (compare(sortedArray[mid],key)==-1) {
                high = mid - 1;
            } else if (equals(sortedArray[mid], key)) {
                index = mid;
                break;
            }
        }
        return index;
    }




    @Override
    public int compare(Student a, Student b) {

        int sum=a.grade-b.grade;
        if(sum>0)
            return 1;
        if(sum==0)
            return 0;
        if(sum<0)
            return -1;
        return sum;
    }
    public boolean equals(Student a, Student b){
        int sum=a.grade-b.grade;
        if(sum==0)
            return true;
        return false;

    }
}


public class Test {
    public static void main(String[] args) {
        int n = 10;
        Student[] students= new Student[n];
        for(int i=0;i<n;i++)
            students[i]=new Student((int)(Math.random()*10));

        SortingStudentsByGPA sort=new SortingStudentsByGPA();
        int[] IDNumber = new int[n];
        for(int i=0;i<n;i++)
            IDNumber[i]=(int)(Math.random()*10);

        Arrays.sort(IDNumber);
        sort.quickSort(students,0,9);
        for(Student o: students){
            System.out.println(o.grade);
        }
        System.out.println("!!!!!!!!!!");
        int x=(int)(Math.random()*10);
        //System.out.println(x);
        System.out.println(students[x].grade);
        System.out.println("!!!!!!!!!!");
        System.out.println(sort.binarySearch(students,students[x],0,n-1));
        Arrays.sort(students);
        System.out.println("!!!!!!!!!!");
        for(Student o: students){
            System.out.println(o.grade);
        }

    }

}