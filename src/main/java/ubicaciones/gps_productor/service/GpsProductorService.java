package ubicaciones.gps_productor.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import ubicaciones.gps_productor.dto.GpsActualizacion;

@RestController
public class GpsProductorService {    

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbit.exchange}")
    private String exchange;

    @Value("${app.rabbit.routingKey}")
    private String routingKey;

    public GpsProductorService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void enviarActualizacionGps(GpsActualizacion actualizacion) {
        rabbitTemplate.convertAndSend(exchange, routingKey, actualizacion);
        System.out.println("Enviado a RabbitMQ: " + actualizacion);
    }
}
