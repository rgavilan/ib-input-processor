package es.um.asio.inputprocessor.kafka.model;

import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class that represents the response of ETL process.
 */
@XmlType(name = "webresult")
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ETLJobResponse {
    
    /**
     * The job result.
     */
    private String result;
    
    /**
     * The job message.
     */
    private String message;

    /**
     * The job execution id.
     */
    private String id;
}
