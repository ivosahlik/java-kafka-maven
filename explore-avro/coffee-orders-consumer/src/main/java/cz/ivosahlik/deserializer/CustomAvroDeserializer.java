package cz.ivosahlik.deserializer;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class CustomAvroDeserializer extends KafkaAvroDeserializer {

    @Override
    public Object deserialize(String s, byte[] bytes) {
        try{
            return super.deserialize(s, bytes);
        }catch (Exception e){
            log.error("Exception in deserialization : {} ", e.getMessage(), e);
            return null;
        }

    }

    @Override
    public Object deserialize(String s, byte[] bytes, Schema readerSchema) {

        try{
            return super.deserialize(s, bytes, readerSchema);
        }catch (Exception e){
            log.error("Exception in deserialization with Schema: {} ", e.getMessage(), e);
            return null;
        }
    }
}
