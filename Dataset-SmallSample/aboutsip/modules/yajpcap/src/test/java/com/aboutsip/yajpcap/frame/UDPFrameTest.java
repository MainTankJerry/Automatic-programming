/**
 * 
 */
package com.aboutsip.yajpcap.frame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aboutsip.yajpcap.YajTestBase;
import com.aboutsip.yajpcap.frame.layer1.Layer1Frame;
import com.aboutsip.yajpcap.frame.layer2.EthernetFrame;
import com.aboutsip.yajpcap.frame.layer3.IPv4Frame;
import com.aboutsip.yajpcap.frame.layer4.UDPFrame;
import com.aboutsip.yajpcap.framer.layer1.Layer1Framer;
import com.aboutsip.yajpcap.framer.layer1.PcapFramer;
import com.aboutsip.yajpcap.framer.layer2.EthernetFramer;
import com.aboutsip.yajpcap.framer.layer3.IPv4Framer;
import com.aboutsip.yajpcap.framer.layer4.UDPFramer;
import com.aboutsip.yajpcap.packet.layer4.TransportPacket;

/**
 * @author jonas@jonasborjesson.com
 */
public class UDPFrameTest extends YajTestBase {

    /**
     * {@inheritDoc}
     */
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testParsePacket() throws Exception {
        final Layer1Framer pcapFramer = new PcapFramer(this.defaultByteOrder, this.framerManager);
        final Layer1Frame pcapFrame = pcapFramer.frame(null, this.pcapStream);

        final EthernetFramer ethFramer = new EthernetFramer(this.framerManager);
        final EthernetFrame ethFrame = ethFramer.frame(pcapFrame, pcapFrame.getPayload());

        final IPv4Framer ipv4Framer = new IPv4Framer(this.framerManager);
        final IPv4Frame ipv4Frame = ipv4Framer.frame(ethFrame, this.ipv4FrameBuffer);

        final UDPFramer framer = new UDPFramer(this.framerManager);
        final UDPFrame frame = framer.frame(ipv4Frame, this.udpFrameBuffer);
        final TransportPacket p = frame.parse();
        assertThat(p.getSourcePort(), is(5060));
        assertThat(p.getDestinationPort(), is(5090));

        assertThat(p.getDestinationIP(), is("127.0.0.1"));
        assertThat(p.getSourceIP(), is("127.0.0.1"));
        assertThat(p.getSourceMacAddress(), is("00:00:00:00:00:00"));
        assertThat(p.getDestinationMacAddress(), is("00:00:00:00:00:00"));
        assertThat(p.getArrivalTime(), is(1340495109792862L));
    }

}
