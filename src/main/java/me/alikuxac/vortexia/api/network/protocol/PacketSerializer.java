// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.protocol;

import io.netty.buffer.ByteBuf;

/**
 * Interface for serializing objects/packets into Netty {@link ByteBuf}.
 *
 * @param <T> Target object type
 */
@FunctionalInterface
public interface PacketSerializer<T> {

    /**
     * Serializes object into the target ByteBuf.
     *
     * @param object Object to serialize
     * @param buf    ByteBuf target buffer
     */
    void serialize(T object, ByteBuf buf);
}
