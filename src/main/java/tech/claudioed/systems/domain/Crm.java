package tech.claudioed.systems.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author claudioed on 2019-05-21.
 * Project systems
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "crm")
public class Crm {

  private String id;

  private String url;

  private Integer port;

}
