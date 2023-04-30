package assignment3;

public class AituTeachers {
    private String firstName;
    private String lastName;
    private int age;
    private int yearOfBirth;
    private int experience;
    private String teachingSubject;
    public AituTeachers(){};
    public AituTeachers(String firstName, String lastName, int age, String teachingSubject, int yearOfBirth, int experience)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.teachingSubject = teachingSubject;
        this.yearOfBirth = yearOfBirth;
        this.experience = experience;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public int hashCode() {
        int hash = 4;
        for (char c: firstName.toCharArray()) {
            hash = c + hash * 17;
        }
        for (char c: lastName.toCharArray()) {
            hash = c + hash * 27;
        }
        for (char c: teachingSubject.toCharArray()) {
            hash = c + hash * 18;
        }
        hash = hash * 24 + age;
        hash = hash * 38 + (int) yearOfBirth;
        hash = hash * 21 + (int) experience;
        return hash;
    }
    @Override
    public String toString() {
        return "AituTeachers { " +
                "firstname = '" + firstName + '\'' +
                ", lastname = '" + lastName + '\'' +
                ", age = " + age +
                ", teachingSubject = ' " + teachingSubject +
                ", yearOfBirth = " + yearOfBirth +
                ", workingExperience = " + experience +
                '}';
    }

}
