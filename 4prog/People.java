import java.util.Objects;

class People {
    private final String name;
    private final String faculty;

    public People(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public String getFac() {
        return faculty;
    }
    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof People)) return false;
            People people = (People) o;
            return Objects.equals(name, people.name) &&
                    Objects.equals(faculty, people.faculty);
        }
}
