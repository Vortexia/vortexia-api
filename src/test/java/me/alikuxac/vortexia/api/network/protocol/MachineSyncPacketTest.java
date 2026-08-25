// Developed by alikuxac - Project Vortexia
package me.alikuxac.vortexia.api.network.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MachineSyncPacketTest {

    @Test
    void testSerializationAndDeserialization() {
        long pos = MachineSyncPacket.encodeBlockPos(100, 64, -200);
        short machineId = 42;
        int energy = 150000;
        byte state = 1;

        MachineSyncPacket original = new MachineSyncPacket(pos, machineId, energy, state);

        ByteBuf buf = Unpooled.buffer();
        try {
            original.writeTo(buf);

            // Verify binary packet size < 20 bytes (exact 15 bytes)
            int readableBytes = buf.readableBytes();
            assertEquals(15, readableBytes, "Packet binary size should be exactly 15 bytes");
            assertTrue(readableBytes < 20, "Packet binary size must be less than 20 bytes");

            MachineSyncPacket decoded = MachineSyncPacket.readFrom(buf);

            assertEquals(original.blockPos(), decoded.blockPos());
            assertEquals(original.machineId(), decoded.machineId());
            assertEquals(original.currentEnergy(), decoded.currentEnergy());
            assertEquals(original.state(), decoded.state());
        } finally {
            buf.release();
        }
    }
}
