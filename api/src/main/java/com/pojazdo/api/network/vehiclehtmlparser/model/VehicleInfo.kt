package com.pojazdo.api.network.vehiclehtmlparser.model
import pl.droidsonroids.jspoon.annotation.Selector


data class VehicleInfo constructor (val info: String){
  @Selector(value="#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:typ")
  var typ: String? = null
  @Selector(value="#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:marka")
  var marka: String? = null
  @Selector(value="#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:model")
  var model: String? = null
  @Selector(value="#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:rodzaj")
  var type: String? = null
  @Selector(value="#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:podrodzaj")
  var subtype: String? = null
  @Selector(value="#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:pojemnosc")
  var pojemnosc: String? = null
}