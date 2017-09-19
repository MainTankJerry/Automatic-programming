/**
 * 
 */
package com.aboutsip.yajpcap.frame.layer2;

import java.io.IOException;

import com.aboutsip.buffer.Buffer;
import com.aboutsip.yajpcap.frame.AbstractFrame;
import com.aboutsip.yajpcap.frame.Frame;
import com.aboutsip.yajpcap.frame.layer1.Layer1Frame;
import com.aboutsip.yajpcap.framer.Framer;
import com.aboutsip.yajpcap.framer.FramerManager;
import com.aboutsip.yajpcap.packet.Packet;
import com.aboutsip.yajpcap.packet.PacketParseException;
import com.aboutsip.yajpcap.packet.layer2.MACPacket;
import com.aboutsip.yajpcap.packet.layer2.MACPacketImpl;
import com.aboutsip.yajpcap.protocol.Protocol;

/**
 * @author jonas@jonasborjesson.com
 */
public final class EthernetFrame extends AbstractFrame implements Layer2Frame {

    private final Layer1Frame parentFrame;
    private final Buffer destMacAddress;
    private final Buffer srcMacAddress;
    private final EtherType type;

    /**
     * 
     */
    public EthernetFrame(final FramerManager framerManager, final Layer1Frame parentFrame, final Buffer destMacAddress,
            final Buffer srcMacAddress,
            final EtherType type,
            final Buffer payload) {
        super(framerManager, Protocol.ETHERNET_II, payload);
        assert parentFrame != null;

        this.parentFrame = parentFrame;
        this.destMacAddress = destMacAddress;
        this.srcMacAddress = srcMacAddress;
        this.type = type;
    }

    /**
     * Get the destination mac address as a raw byte buffer
     * 
     * @return
     */
    public Buffer getRawDestinationMacAddress() {
        return this.destMacAddress;
    }

    /**
     * Get the source mac address as a raw byte buffer
     * 
     * @return
     */
    public Buffer getRawSourceMacAddress() {
        return this.srcMacAddress;
    }

    /**
     * Get the source mac address as a human friendly string
     * 
     * @return
     */
    public String getSourceMacAddress() throws IOException {
        if (this.srcMacAddress.readableBytes() != 6) {
            // probably want to throw some parse/frame exception
            // or something
            throw new IllegalArgumentException("Not enough bytes in the source mac address");
        }
        return toHexString(this.srcMacAddress);
    }

    /**
     * Get the destination mac address as a human friendly string
     * 
     * @return
     */
    public String getDestinationMacAddress() throws IOException {
        if (this.destMacAddress.readableBytes() != 6) {
            // probably want to throw some parse/frame exception
            // or something
            throw new IllegalArgumentException("Not enough bytes in the source mac address");
        }
        return toHexString(this.destMacAddress);
    }

    /**
     * Convert the buffer into a hex string
     * 
     * TODO: move somewhere else...
     * 
     * @param buffer
     * @return
     * @throws IOException
     */
    public static String toHexString(final Buffer buffer) throws IOException {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buffer.capacity(); ++i) {
            final byte b = buffer.getByte(i);
            sb.append(String.format("%02X", b));
            if (i < (buffer.capacity() - 1)) {
                sb.append(":");
            }
        }
        return sb.toString();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MACPacket parse() throws PacketParseException {
        try {
            final Packet parentPacket = this.parentFrame.parse();
            final String source = getSourceMacAddress();
            final String dest = getDestinationMacAddress();
            return new MACPacketImpl(parentPacket, source, dest);
        } catch (final IOException e) {
            throw new RuntimeException("TODO: need to parse exception or something", e);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Destination Mac Address: ").append(this.destMacAddress);
        sb.append("Source Mac Address: ").append(this.srcMacAddress);
        sb.append("EtherType: ").append(this.type);

        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Frame framePayload(final FramerManager framerManager, final Buffer buffer) throws IOException {
        switch(this.type){
        case IPv4:
            final Framer framer = framerManager.getFramer(Protocol.IPv4);
            return framer.frame(this, buffer);
        case IPv6:
            throw new RuntimeException("Cant do ipv6 right now");
        default:
            throw new RuntimeException("Uknown ether type");
        }
    }

    public static enum EtherType {
        IPv4, IPv6;
    }

}
