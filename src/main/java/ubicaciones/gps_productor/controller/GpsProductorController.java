package ubicaciones.gps_productor.controller;

import org.springframework.web.bind.annotation.RestController;

import ubicaciones.gps_productor.dto.GpsActualizacion;
import ubicaciones.gps_productor.service.GpsProductorService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/gps")
public class GpsProductorController {

    private final GpsProductorService gpsProductorService;

    public GpsProductorController(GpsProductorService gpsProductorService) {
        this.gpsProductorService = gpsProductorService;
    }

    @PostMapping("/actualizacion")
    public ResponseEntity<String> postGpsActualizacion(@RequestBody GpsActualizacion actualizacion) {
        gpsProductorService.enviarActualizacionGps(actualizacion);
        return ResponseEntity.ok().body("Actualización GPS enviada exitosamente");
    }    
}
