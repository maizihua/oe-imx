require gst-plugins.inc

PR = "r3"

SRC_URI += "file://fix-unit-scale-asseration.patch;patch=1"

OE_ALLOW_INSECURE_DOWNLOADS = "1"
inherit gconf 

DEPENDS += "gst-plugins-base openssl popt"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

