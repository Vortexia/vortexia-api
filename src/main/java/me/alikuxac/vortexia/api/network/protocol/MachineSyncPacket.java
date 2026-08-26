// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.protocol;

import io.netty.buffer.ByteBuf;
import org.bukkit.block.Block;

import java.util.Objects;

/**
 * Compact binary sync packet for machine synchronization & HUD metrics.
 * Payload schema:
 * - BlockPos (long: 8 bytes)
 * - MachineID (short: 2 bytes)
 * - CurrentEnergy (int: 4 bytes)
 * - State (byte: 1 byte)
 * Total binary footprint: 15 bytes (< 20 bytes payload).
 */
public record MachineSyncPacket(long blockPos, short machineId, int currentEnergy, byte state) {

    public static final PacketSerializer<MachineSyncPacket> SERIALIZER = (packet, buf) -> {
        buf.writeLong(packet.blockPos());
        buf.writeShort(packet.machineId());
        buf.writeInt(packet.currentEnergy());
        buf.writeByte(packet.state());
    };

    public static final PacketDeserializer<MachineSyncPacket> DESERIALIZER = buf -> new MachineSyncPacket(
            buf.readLong(),
            buf.readShort(),
            buf.readInt(),
            buf.readByte()
    );

    /**
     * Encodes Block location (x, y, z) into a single compact 64-bit long value.
     */
    public static long encodeBlockPos(int x, int y, int z) {
        return (((long) x & 0x3FFFFFF) << 38) | (((long) y & 0xFFF) << 26) | ((long) z & 0x3FFFFFF);
    }

    /**
     * Utility method to create MachineSyncPacket directly from a Bukkit Block.
     */
    public static MachineSyncPacket of(Block block, short machineId, int currentEnergy, byte state) {
        Objects.requireNonNull(block, "Block cannot be null");
        return new MachineSyncPacket(encodeBlockPos(block.getX(), block.getY(), block.getZ()), machineId, currentEnergy, state);
    }

    /**
     * Serializes this packet directly into a given ByteBuf.
     */
    public void writeTo(ByteBuf buf) {
        SERIALIZER.serialize(this, buf);
    }

    /**
     * Deserializes a MachineSyncPacket from a given ByteBuf.
     */
    public static MachineSyncPacket readFrom(ByteBuf buf) {
        return DESERIALIZER.deserialize(buf);
    }
}
