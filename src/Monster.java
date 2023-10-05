public class Monster extends Person {
    public Monster() {
        name = "MONSTER";
        strong = 1000;
        defend = 1000;

    }

    public int getSkills() {
        return super.getSkills() + 2;
    }
}
