package assignment3;
import java.util.Random;
import java.util.Arrays;

public class MyTestingClass {
    public static void main(String[] args)
    {
        MyHashTable<AituTeachers, String> table = new MyHashTable<>();
        Random random = new Random();
        for(int i = 0; i < 10000; i++){
            StringBuilder firstname = new StringBuilder();
            StringBuilder lastname = new StringBuilder();
            StringBuilder teachingSubject = new StringBuilder();
            int age = random.nextInt(23, 72);
            int yearOfBirth = random.nextInt(1951,2001);
            int experience = random.nextInt(1, 50);
            for(int j = 0; j < 15; j++){
                if (i == 0) {
                    firstname.append(random.nextInt(65, 90));
                }
                else {
                    firstname.append((char) random.nextInt(97, 123));
                }
            }
            for(int j = 0; j < 15; j++){
                if (i == 0) {
                    lastname.append(random.nextInt(65, 90));
                }
                else {
                    lastname.append((char) random.nextInt(97, 123));
                }
            }
            for(int j = 0; j < 15; j++){
                teachingSubject.append(random.nextInt(65, 90));
            }
            table.put(new AituTeachers(firstname.toString(), lastname.toString(), age, teachingSubject.toString(),
                    yearOfBirth, experience), "teacher " + i);

        }

        AituTeachers teacher1 = new AituTeachers("Askhar", "Khaimuldin", 30, "Programming", 1993, 11);
        AituTeachers teacher2 = new AituTeachers("Nursultan", "Khaimuldin", 36, "Programming", 1987, 20);
        AituTeachers teacher3 = new AituTeachers("Aizhan", "Aibatbek", 28, "English", 1995, 9);
        AituTeachers teacher4 = new AituTeachers("Kairat", "Batalov", 50, "History", 1973, 25);

        table.put(teacher1, "teacher1");
        table.put(teacher2, "teacher2");
        table.put(teacher3, "teacher3");
        table.put(teacher4, "teacher4");
        System.out.println("HashTable has buckets: " + Arrays.toString(table.getSizeOfBucket()));
        String valueToGet = "teacher3";
        AituTeachers teacherToGet = table.getKey(valueToGet);
        System.out.println("Teacher with value \"" + valueToGet + "\" is: " + teacherToGet);
        String valueToCheck = "teacher2";
        boolean containsValue = table.contains(valueToCheck);
        System.out.println("Hash table contains value \"" + valueToCheck + "\": " + containsValue);
    }
}
