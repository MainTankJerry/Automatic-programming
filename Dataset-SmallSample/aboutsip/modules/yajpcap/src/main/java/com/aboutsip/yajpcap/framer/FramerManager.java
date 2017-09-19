/**
 * 
 */
package com.aboutsip.yajpcap.framer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aboutsip.buffer.Buffer;
import com.aboutsip.yajpcap.framer.layer2.EthernetFramer;
import com.aboutsip.yajpcap.framer.layer2.SllFramer;
import com.aboutsip.yajpcap.framer.layer3.IPv4Framer;
import com.aboutsip.yajpcap.framer.layer4.TCPFramer;
import com.aboutsip.yajpcap.framer.layer4.UDPFramer;
import com.aboutsip.yajpcap.framer.layer7.SDPFramer;
import com.aboutsip.yajpcap.framer.layer7.SIPFramer;
import com.aboutsip.yajpcap.protocol.Protocol;

/**
 * FramerFactory
 * 
 * @author jonas@jonasborjesson.com
 */
public final class FramerManager {

    private static final FramerManager instance = new FramerManager();

    private final Map<Protocol, Framer> framers = new HashMap<Protocol, Framer>();

    static {
        // should be moved somewhere else but for now...
        instance.registerDefaultFramers();
    }

    public static final FramerManager getInstance() {
        return instance;
    }

    /**
     * 
     */
    private FramerManager() {
        // left empty intentionally
    }

    public Framer getFramer(final Protocol p) {
        return this.framers.get(p);
    }

    /**
     * Register a new framer for a particular protocol.
     * 
     * @param p
     * @param framerClass
     * @return
     */
    public void registerFramer(final Protocol p, final Framer framer) throws IllegalArgumentException {
        if ((p == null) || (framer == null)) {
            throw new IllegalArgumentException("The protocol or framer cannot be null");
        }
        this.framers.put(p, framer);
    }

    /**
     * Convenience method for registering all the default framers for all the
     * protocols we currently can handle
     */
    public void registerDefaultFramers() {
        registerFramer(Protocol.SIP, new SIPFramer(this));
        registerFramer(Protocol.SDP, new SDPFramer(this));
        registerFramer(Protocol.SLL, new SllFramer(this));
        registerFramer(Protocol.ETHERNET_II, new EthernetFramer(this));
        registerFramer(Protocol.IPv4, new IPv4Framer(this));
        registerFramer(Protocol.UDP, new UDPFramer(this));
        registerFramer(Protocol.TCP, new TCPFramer(this));
    }

    /**
     * Try and find a framer for the data
     * 
     * @param data the data we are trying to find a framer for
     * @return
     */
    public Framer getFramer(final Buffer data) throws IOException {
        // TODO: if we know which ports the data was sent from
        // and came in on, we should be able to find a framer
        // faster. Hence, allow the user to register known ports
        // for certain protocols. However, this is just an optimization
        // and we would still have to loop over all of them in case
        // the port lookup doesn't turn out to be true

        for (final Framer framer : this.framers.values()) {
            if (framer.accept(data)) {
                return framer;
            }
        }

        // unknown data type
        return null;
    }

}
