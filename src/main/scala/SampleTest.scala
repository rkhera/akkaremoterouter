import java.net.{Inet6Address, Inet4Address}

object NetworkInterfaceTest extends App {

  doo

  def doo = {
    import java.net.NetworkInterface
    import scala.collection.JavaConverters._
    val interfaces = NetworkInterface.getNetworkInterfaces.asScala.filter(p => !p.isLoopback && p.isUp && !p.isVirtual)
    interfaces.foreach{ n=>
      println("---------")
      println("Display name " + n.getDisplayName)
      println(Option(n.getHardwareAddress).map("Hardware Address " + _.toString).getOrElse(" NO HARDWARE ADDRESS "))
      println(n.getName)
      println(n.isLoopback + " <--- Isloopback")
      println(n.isUp + " <--- IsUp")
      println(n.isVirtual + " <--- IsVirtual")

      val ipv4Addresses = n.getInetAddresses.asScala.filter{p => p match {
           case i:Inet4Address => true
           case i:Inet6Address => false
           case _ => false
        }
      }
      println(ipv4Addresses.toList(0).getHostAddress)
      println("---------")
    }




  }

}
