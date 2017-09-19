/**
 * 
 */
package com.aboutsip.yajpcap.packet.impl.sip;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aboutsip.buffer.Buffer;
import com.aboutsip.buffer.Buffers;
import com.aboutsip.yajpcap.packet.layer7.sip.impl.SipInitialLine;
import com.aboutsip.yajpcap.packet.layer7.sip.impl.SipParseException;
import com.aboutsip.yajpcap.packet.layer7.sip.impl.SipParser;
import com.aboutsip.yajpcap.packet.layer7.sip.impl.SipRequestLine;
import com.aboutsip.yajpcap.packet.layer7.sip.impl.SipResponseLine;

/**
 * @author jonas@jonasborjesson.com
 */
public class SipInitialLineTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test so that we correctly can parse a request line
     */
    @Test
    public void testParseRequestLine() throws Exception {
        final Buffer buffer = Buffers.wrap("INVITE sip:alice@example.com SIP/2.0");
        final SipInitialLine initialLine = SipInitialLine.parse(buffer);
        assertThat(initialLine.isRequestLine(), is(true));
        assertThat(initialLine.isResponseLine(), is(false));

        final SipRequestLine requestLine = (SipRequestLine) initialLine;
        assertThat(requestLine.getMethod().toString(), is("INVITE"));
        assertThat(requestLine.getRequestUri().toString(), is("sip:alice@example.com"));
    }

    /**
     * Basic response line test
     * 
     * @throws Exception
     */
    @Test
    public void testParseResponseLine() throws Exception {
        final Buffer buffer = Buffers.wrap("SIP/2.0 200 OK");
        final SipInitialLine initialLine = SipInitialLine.parse(buffer);
        assertThat(initialLine.isRequestLine(), is(false));
        assertThat(initialLine.isResponseLine(), is(true));

        final SipResponseLine requestLine = (SipResponseLine) initialLine;
        assertThat(requestLine.getStatusCode(), is(200));
        assertThat(requestLine.getReason().toString(), is("OK"));
    }

    /**
     * If we get back something like "INVITE sip:hello" then this should error
     * out
     * 
     * @throws Exception
     */
    @Test
    public void testBadInitialLineNotEnoughSections() throws Exception {
        final Buffer buffer = Buffers.wrap("INVITE sip:alice@example");
        try {
            SipInitialLine.parse(buffer);
            fail("Expected SipParseException");
        } catch (final SipParseException e) {
            // the error offset should be set to the very and of the buffer
            // since that is where we bailed out.
            assertThat(e.getErroOffset(), is(24));
        }
    }

    /**
     * Wrong SIP version
     * 
     * @throws Exception
     */
    @Test
    public void testBadInitialLineWrongSipVersion() throws Exception {
        final Buffer buffer = Buffers.wrap("INVITE sip:alice@example.com SIP/3.0");
        try {
            SipInitialLine.parse(buffer);
            fail("Expected SipParseException");
        } catch (final SipParseException e) {
            // the error offset should be set to the very and of the buffer
            // since that is where we bailed out.
            assertThat(e.getErroOffset(), is(33));
        }
    }

    /**
     * Wrong Status code
     * 
     * @throws Exception
     */
    @Test
    public void testBadInitialLineBadStatusCode() throws Exception {
        final Buffer buffer = Buffers.wrap("SIP/2.0 twohundred OK");
        try {
            SipInitialLine.parse(buffer);
            fail("Expected SipParseException");
        } catch (final SipParseException e) {
            // the error offset should be set to the very and of the buffer
            // since that is where we bailed out.
            assertThat(e.getErroOffset(), is(8));
        }
    }

    @Test
    public void testBufferThrowsIOException() throws Exception {
        final Buffer buffer = mock(Buffer.class);
        when(buffer.readUntil(SipParser.SP)).thenThrow(new IOException("From unit tests"));
        when(buffer.getReaderIndex()).thenReturn(5);
        try {
            SipInitialLine.parse(buffer);
            fail("Expected SipParseException");
        } catch (final SipParseException e) {
            // five because that is what we mocked it to return
            assertThat(e.getErroOffset(), is(5));
        }

    }

}
