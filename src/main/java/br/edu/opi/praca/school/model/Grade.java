package br.edu.opi.praca.school.model;

public enum Grade {
    FIRST_ELEMENTARY("FIRST_ELEMENTARY", "1º ano do Ensino Fundamental"),
    SECOND_ELEMENTARY("SECOND_ELEMENTARY", "2º ano do Ensino Fundamental"),
    THIRD_ELEMENTARY("THIRD_ELEMENTARY", "3º ano do Ensino Fundamental"),
    FOURTH_ELEMENTARY("FOURTH_ELEMENTARY", "4º ano do Ensino Fundamental"),
    FIFTH_ELEMENTARY("FIFTH_ELEMENTARY", "5º ano do Ensino Fundamental"),
    SIXTH_ELEMENTARY("SIXTH_ELEMENTARY", "6º ano do Ensino Fundamental"),
    SEVENTH_ELEMENTARY("SEVENTH_ELEMENTARY", "7º ano do Ensino Fundamental"),
    EIGHTH_ELEMENTARY("EIGHTH_ELEMENTARY", "8º ano do Ensino Fundamental"),
    NINTH_ELEMENTARY("NINTH_ELEMENTARY", "9º ano do Ensino Fundamental"),

    FIRST_HIGH("FIRST_HIGH", "1º ano do Ensino Médio"),
    SECOND_HIGH("SECOND_HIGH", "2º ano do Ensino Médio"),
    THIRD_HIGH("THIRD_HIGH", "3º ano do Ensino Médio"),
    FOURTH_HIGH("FOURTH_HIGH", "4º ano do Ensino Médio");

    private String key;
    private String name;

    Grade(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static Grade from(String string) {
        for (Grade grade : Grade.values()) {
            if (grade.name.equalsIgnoreCase(string)) {
                return grade;
            }
        }
        throw new RuntimeException("Grade '" + string + "' don't exists");
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return key;
    }

}
