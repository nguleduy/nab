package com.example.joseph.auditservice.helper;

import com.example.joseph.auditservice.model.CustomerBehavior;
import com.example.joseph.auditservice.repository.CustomerBehaviorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.time.LocalDateTime;

@SpringBootTest
public class CustomerHelperTest {

  @Autowired
  private Sink sink;

  @MockBean
  private CustomerBehaviorRepository customerBehaviorRepository;

  private PodamFactory podam = new PodamFactoryImpl();

  @Test
  void storeDataWhenCustomerDoSomethingTest() {
    CustomerBehavior customerBehavior = podam.manufacturePojo(CustomerBehavior.class);
    Message<CustomerBehavior> message = new GenericMessage<>(customerBehavior);
    sink.input().send(message);
    Mockito.when(customerBehaviorRepository.save(Mockito.eq(customerBehavior))).thenReturn(customerBehavior);
    Mockito.verify(customerBehaviorRepository).save(customerBehavior);
  }
}
