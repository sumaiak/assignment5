package org.ExerciseDog;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DogDTO {
    int id;
    String name;
    String breed;
    String gender;
    int age;
}
