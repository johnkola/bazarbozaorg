package com.bazarbozorg.mongodb;

import org.bson.BsonBinary;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import java.util.UUID;

public class UUIDCodec implements Codec<UUID> {

    @Override
    public void encode(BsonWriter writer, UUID value, EncoderContext encoderContext) {
        if (value != null) {
            writer.writeBinaryData(new BsonBinary(value)); // ✅ Store UUID as Binary (Subtype 4)
        } else {
            writer.writeNull();
        }
    }

    @Override
    public UUID decode(BsonReader reader, DecoderContext decoderContext) {
        switch (reader.getCurrentBsonType()) {
            case BINARY:
                return reader.readBinaryData().asUuid(); // ✅ Read Binary as UUID
            case STRING:
                return UUID.fromString(reader.readString()); // ✅ Read String as UUID
            case NULL:
                reader.readNull();
                return null; // ✅ Handle null values
            default:
                throw new IllegalStateException("Expected UUID, but found: " + reader.getCurrentBsonType());
        }
    }

    @Override
    public Class<UUID> getEncoderClass() {
        return UUID.class;
    }
}
