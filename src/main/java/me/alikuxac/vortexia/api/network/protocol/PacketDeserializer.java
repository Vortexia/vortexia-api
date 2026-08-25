// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.protocol;

import io.netty.buffer.ByteBuf;

/**
 * Interface for deserializing Netty {@link ByteBuf} into objects/packets.
 *
 * @param <T> Result object type
 */
@FunctionalInterface
public interface PacketDeserializer<T> {

    /**
     * Deserializes ByteBuf into object T.
     *
     * @param buf Source ByteBuf
     * @return Deserialized object
     */
    T deserialize(ByteBuf buf);
}
