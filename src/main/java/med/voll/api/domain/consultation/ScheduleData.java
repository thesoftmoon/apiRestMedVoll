package med.voll.api.domain.consultation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ScheduleData(
        Long id,
        @NotNull
        Long idPaciente,
        Long idDoctor,
        @NotNull
        @Future
        LocalDateTime date
) {
}
