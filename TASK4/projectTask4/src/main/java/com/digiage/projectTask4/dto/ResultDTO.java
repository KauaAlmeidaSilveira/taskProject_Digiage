package com.digiage.projectTask4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResultDTO {
    private Integer total;
    private Integer masc;
    private Integer fem;

    @Override
    public String toString() {
        return """
               {
                    "total": %d,
                    "masc": %d,
                    "fem": %d
               }
               """.formatted(total, masc, fem);
    }

}
