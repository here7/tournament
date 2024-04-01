public class Player {
    private String firstName;
    private String lastName;

    private int age;
    private int dorsal;

    public Player(String firstName, String lastName, int age, int dorsal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dorsal = dorsal;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
}
