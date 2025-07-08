package br.ifsp.library.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ifsp.library.config.RabbitMQConfig;
import br.ifsp.library.dto.ReservationEventDTO;
@Service
public class RabbitMQProducer {
	
	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper;
	
	public RabbitMQProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
	}
	
	public void produceReservationEvent(ReservationEventDTO event) {
		try {
			//String json = objectMapper.writeValueAsString(event);
			rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
			System.out.println("Event delivered to RabbitMQ: " + event);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao serializar o evento", e);
		}
		
	}
	
}
