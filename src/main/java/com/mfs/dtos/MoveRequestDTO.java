package com.mfs.dtos;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MoveRequestDTO {
    private int pit;
    private List<PlayerMoveRequestDTO> players;
}
