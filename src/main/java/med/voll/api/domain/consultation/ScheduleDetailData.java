package med.voll.api.domain.consultation;

import java.time.LocalDateTime;

public record ScheduleDetailData(Long id, Long idPaciente, Long idDoctor, LocalDateTime date) {
}
