package br.ifsp.library.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import br.ifsp.library.config.RabbitMQConfig;
import br.ifsp.library.dto.ReservationEventDTO;
@Service
public class RabbitMQProducer {
	
	private final RabbitTemplate rabbitTemplate;
	
	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void produceReservationEvent(ReservationEventDTO event) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
		System.out.println("Event delivered to RabbitMQ: " + event);
	}
	
}
