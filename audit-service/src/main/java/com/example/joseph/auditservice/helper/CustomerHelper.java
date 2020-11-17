package com.example.joseph.auditservice.helper;

import com.example.joseph.auditservice.model.CustomerBehavior;
import com.example.joseph.auditservice.repository.CustomerBehaviorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class CustomerHelper {

  @Autowired
  private CustomerBehaviorRepository customerBehaviorRepository;

  @StreamListener(Sink.INPUT)
  public void process(CustomerBehavior customerBehavior) {
    customerBehaviorRepository.save(customerBehavior);
  }
}
