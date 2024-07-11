package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consultation.ScheduleData;
import med.voll.api.domain.consultation.ScheduleDetailData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultationController {

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid ScheduleData scheduleData){
        System.out.println(scheduleData);

        return ResponseEntity.ok(new ScheduleDetailData(null, null, null, null));
    }
}
