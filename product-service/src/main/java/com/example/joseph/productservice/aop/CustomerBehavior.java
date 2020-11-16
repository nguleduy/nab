package com.example.joseph.productservice.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBehavior {

  private String username;
  private LocalDateTime actionOn;
  private Long productId;
  private Map<String, List<String>> filterBy;
  private List<String> sortBy;

  public CustomerBehavior(String username, LocalDateTime actionOn, Long productId) {
    this.username = username;
    this.actionOn = actionOn;
    this.productId = productId;
  }

}
