package play.core.server.websocket

import org.jboss.netty.buffer.ChannelBuffer
import org.jboss.netty.channel.Channel
import java.nio.charset.Charset
import org.jboss.netty.buffer.ChannelBuffers
import java.util._
/**
 * Websocket ping frame.
 */
class PingFrame(rsv: Int) extends Frame(true, rsv, ChannelBuffers.EMPTY_BUFFER) {

}