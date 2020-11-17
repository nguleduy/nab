package com.example.joseph.auditservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBehavior {

  @Id
  private Long id;
  private String username;
  private LocalDateTime actionOn;
  private Long productId;
  private Map<String, List<String>> filterBy;
  private List<String> sortBy;
}
