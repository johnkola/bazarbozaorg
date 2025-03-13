package com.bazarbozorg.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static org.bson.codecs.configuration.CodecRegistries.*;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.authentication-database}")
    private String authenticationDatabase;

    @Value("${spring.mongodb.min-pool-size}")
    private int minPoolSize;

    @Value("${spring.mongodb.max-pool-size}")
    private int maxPoolSize;

    @Value("${spring.mongodb.connection-timeout}")
    private int connectionTimeout;

    @Value("${spring.mongodb.max-wait-time}")
    private int maxWaitTime;

    @Value("${spring.mongodb.max-connection-life-time}")
    private int maxConnectionLifeTime;

    @Value("${spring.mongodb.max-connection-idle-time}")
    private int maxConnectionIdleTime;

    @Bean
    public CodecRegistry pojoCodecRegistry() {
        return fromRegistries(
                fromCodecs(new UUIDCodec()),   // ✅ Custom UUID Codec
                fromProviders(PojoCodecProvider.builder().automatic(true).build()),
                MongoClientSettings.getDefaultCodecRegistry()
        );
    }

    @Bean
    public MongoClient mongoClient() {

        return MongoClients.create(
                MongoClientSettings.builder()
                        .uuidRepresentation(UuidRepresentation.STANDARD)
                        .codecRegistry(pojoCodecRegistry())
                        .applyConnectionString(new ConnectionString(mongoUri))
                        .applyToConnectionPoolSettings(builder ->
                                builder.minSize(minPoolSize)
                                        .maxSize(maxPoolSize)
                                        .maxWaitTime(maxWaitTime, TimeUnit.MILLISECONDS)
                                        .maxConnectionIdleTime(maxConnectionIdleTime, TimeUnit.MILLISECONDS)
                                        .maxConnectionLifeTime(maxConnectionLifeTime, TimeUnit.MILLISECONDS)
                        )
                        .build()
        );
    }
}
