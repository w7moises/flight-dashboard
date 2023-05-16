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

    private Long agent_id;

    private Long passenger_id;

    private Type travel_type_class;

    private Long number_in_party;

    private Long leg_id;
}
