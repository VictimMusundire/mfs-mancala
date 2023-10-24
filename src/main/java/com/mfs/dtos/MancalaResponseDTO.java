package com.mfs.dtos;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MancalaResponseDTO {

    private List<PlayerResponseDTO> players;
    private boolean gameEnded;
}