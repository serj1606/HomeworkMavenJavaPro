package Entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder

public class Lesson {
  int id;
  String name;
  Homework homework;

}
