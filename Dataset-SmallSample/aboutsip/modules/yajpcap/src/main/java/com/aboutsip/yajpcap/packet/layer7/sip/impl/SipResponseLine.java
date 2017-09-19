/**
 * 
 */
package com.aboutsip.yajpcap.packet.layer7.sip.impl;

import com.aboutsip.buffer.Buffer;
import com.aboutsip.buffer.Buffers;

/**
 * @author jonas@jonasborjesson.com
 */
public final class SipResponseLine extends SipInitialLine {

    /**
     * The status code of the response. I.e., 180, 200, 404 etc etx
     */
    private final int statusCode;

    /**
     * The response reason
     */
    private final Buffer reason;

    private Buffer responseLine;

    public SipResponseLine(final int statusCode, final Buffer reason) {
        super();
        assert reason != null;
        this.statusCode = statusCode;
        this.reason = reason;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isResponseLine() {
        return true;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public Buffer getReason() {
        return this.reason;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Buffer getBuffer() {
        // TODO: redo
        if (this.responseLine == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SIP/2.0 ").append(this.statusCode).append(" ").append(this.reason.toString());
            this.responseLine = Buffers.wrap(sb.toString());
        }

        return this.responseLine;
    }

    @Override
    public String toString() {
        return getBuffer().toString();
    }

}
