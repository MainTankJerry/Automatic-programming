package com.aboutsip.yajpcap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aboutsip.yajpcap.FrameHandler;
import com.aboutsip.yajpcap.Pcap;
import com.aboutsip.yajpcap.frame.Frame;

public class PcapTest extends YajTestBase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testLoop() throws Exception {
        // there are 30 packets in this capture.
        final InputStream stream = YajTestBase.class.getResourceAsStream("sipp.pcap");
        final Pcap pcap = Pcap.openStream(stream);
        final FrameHandlerImpl handler = new FrameHandlerImpl();
        pcap.loop(handler);
        pcap.close();
        assertThat(handler.count, is(30));
    }

    private static class FrameHandlerImpl implements FrameHandler {
        public int count;

        @Override
        public void nextFrame(final Frame frame) {
            ++this.count;
        }
    }

}
