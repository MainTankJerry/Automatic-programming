/**
 * 
 */
package com.aboutsip.yajpcap.packet.impl;

import com.aboutsip.yajpcap.packet.layer4.TransportPacket;

/**
 * Represents a packet from the Application Layer (layer 7) in the OSI model.
 * 
 * Since layer 5 and 6 hasn't been added to this implementation yet, this packet
 * will extend layer 4 (transport layer) directly.
 * 
 * @author jonas@jonasborjesson.com
 */
public interface ApplicationPacket extends TransportPacket {

}
