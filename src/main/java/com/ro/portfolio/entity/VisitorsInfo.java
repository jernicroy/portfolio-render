package com.ro.portfolio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * Document Entity for the visitor collection in MONGODB
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "t101_visitors_info")
public class VisitorsInfo {
    @Id
    String id;

    @Field("c101_ip_address")
    String ip;

    @Field("c101_city")
    String city;
    @Field("c101_region")
    String region;
    @Field("c101_country")
    String country;
    @Field("c101_loc")
    String loc;
    @Field("c101_org")
    String org;
    @Field("c101_postal")
    String postal;
    @Field("c101_timezone")
    String timezone;

    @Field("c101_last_updated_by")
    private LocalDateTime lastUpdatedBy;
}
