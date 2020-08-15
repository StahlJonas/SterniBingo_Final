public class Bierdeckel {
    private int wert;
    private Person person;

    public Bierdeckel(int wert, Person person) {
        this.wert = wert;
        this.person = person;
    }

    public int getWert() {
        return wert;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
