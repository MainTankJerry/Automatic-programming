/**
 * 
 */
package com.aboutsip.yajpcap.frame.layer4;

import java.io.IOException;

import com.aboutsip.buffer.Buffer;
import com.aboutsip.yajpcap.frame.AbstractFrame;
import com.aboutsip.yajpcap.frame.Frame;
import com.aboutsip.yajpcap.frame.layer3.Layer3Frame;
import com.aboutsip.yajpcap.framer.Framer;
import com.aboutsip.yajpcap.framer.FramerManager;
import com.aboutsip.yajpcap.packet.PacketParseException;
import com.aboutsip.yajpcap.packet.layer3.IPPacket;
import com.aboutsip.yajpcap.packet.layer4.TransportPacket;
import com.aboutsip.yajpcap.packet.layer4.TransportPacketImpl;
import com.aboutsip.yajpcap.protocol.Protocol;

/**
 * @author jonas@jonasborjesson.com
 * 
 */
public final class UDPFrame extends AbstractFrame implements Layer4Frame {

    private final Layer3Frame parent;

    private final Buffer headers;

    /**
     * 
     */
    public UDPFrame(final FramerManager framerManager, final Layer3Frame parent, final Buffer headers,
            final Buffer payload) {
        super(framerManager, Protocol.UDP, payload);
        assert parent != null;
        assert headers != null;
        assert payload != null;
        this.parent = parent;
        this.headers = headers;
    }


    // TODO: move all of this stuff into the packet itself
    public int getSourcePort() {
        return this.headers.getUnsignedShort(0);
    }

    public int getDestinationPort() {
        return this.headers.getUnsignedShort(2);
    }

    public int getLength() {
        return this.headers.getUnsignedShort(4);
    }

    public int getChecksum() {
        return this.headers.getUnsignedShort(6);
    }

    @Override
    protected Frame framePayload(final FramerManager framerManager, final Buffer payload) throws IOException {
        final Framer framer = framerManager.getFramer(payload);
        if (framer != null) {
            return framer.frame(this, payload);
        }

        // unknown payload
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransportPacket parse() throws PacketParseException {
        // TODO: perhaps do a UDPPacket
        final IPPacket packet = this.parent.parse();
        return new TransportPacketImpl(packet, true, getSourcePort(), getDestinationPort());
    }

}
