package com.mfs.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BoardResponseDTO {

    private int[] pits;
    private int bigPit;
}