/**
 * 
 */
package com.aboutsip.yajpcap.packet.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aboutsip.yajpcap.frame.layer1.PcapRecordHeader;
import com.aboutsip.yajpcap.packet.PCapPacket;

/**
 * @author jonas@jonasborjesson.com
 */
public final class PCapPacketImpl implements PCapPacket {

    private final PcapRecordHeader pcapHeader;

    /**
     * 
     */
    public PCapPacketImpl(final PcapRecordHeader pcapHeader) {
        assert pcapHeader != null;
        this.pcapHeader = pcapHeader;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getArrivalTime() {
        return (this.pcapHeader.getTimeStampSeconds() * 1000000) + this.pcapHeader.getTimeStampMicroSeconds();
    }

    @Override
    public long getTotalLength() {
        return this.pcapHeader.getTotalLength();
    }

    @Override
    public long getCapturedLength() {
        return this.pcapHeader.getCapturedLength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void verify() {
        // nothing to verify for the pcap packet since that would
        // have been detected when we framed the pcap packet.
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
        final Date date = new Date(getArrivalTime() / 1000);
        sb.append("Arrival Time: ").append(formatter.format(date));
        sb.append(" Epoch Time: ").append(this.pcapHeader.getTimeStampSeconds()).append(".")
        .append(this.pcapHeader.getTimeStampMicroSeconds());
        sb.append(" Frame Length: ").append(getTotalLength());
        sb.append(" Capture Length: ").append(getCapturedLength());

        return sb.toString();
    }


}
