import java.net.NetworkInterface


































































































































import scala.collection.JavaConverters._
val interfaces = NetworkInterface.getNetworkInterfaces.asScala








































interfaces.foreach{ n=>
  println("---------")
  println(n.getDisplayName)
  println(Option(n.getHardwareAddress).map(_.toString).getOrElse(" NO HARDWARE ADDRESS "))
  println(n.getInetAddresses.asScala.foreach{ i =>
    println("\t"+i.getAddress.toString)
    println("\t"+i.getCanonicalHostName)
    println("\t"+i.getHostAddress)
    println("\t"+i.getHostName)
  })
  println(n.getName)
  println(n.isLoopback + " <--- Isloopback")
  println(n.isUp + "<--- IsUp")
  println(n.isVirtual + " <--- IsVirtual")
  println("---------")
}



