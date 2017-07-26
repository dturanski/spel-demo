package io.spring.example.speldemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpelDemoApplicationTests {

	@Autowired
	MessageChannel input;

	@Autowired
	SubscribableChannel output;

	@Test
	public void contextLoads() {
		Message message = MessageBuilder.withPayload("hello").setHeader("bar","somevalue").build();
		output.subscribe(message1 -> {
			assertThat(message1.getHeaders().get("foo")).isEqualTo("SOMEVALUE");
		});
		input.send(message);
	}

}
