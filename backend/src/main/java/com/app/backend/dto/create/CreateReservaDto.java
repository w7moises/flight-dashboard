package com.app.backend.dto.create;

import com.app.backend.model.Status;
import com.app.backend.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservaDto {

    private Long agentId;

    private Long passengerId;

    private Type travelTypeClass;

    private Long numberInParty;

    private Long legId;
}
