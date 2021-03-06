DESCRIPTION = "Runtime support for GTK interface builder"
HOMEPAGE = "http://glade.gnome.org/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "gtk+ gtk-doc"

inherit autotools pkgconfig

headers = "glade-build.h glade-init.h glade-parser.h glade-xml.h glade.h"

do_stage () {
	oe_libinstall -a -so -C glade libglade-2.0 ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/libglade-2.0/glade
	for i in ${headers}; do
		install -m 0644 ${S}/glade/$i ${STAGING_INCDIR}/libglade-2.0/glade/$i
	done
}

PACKAGES += " ${PN}-data"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-data = "${datadir}/xml/libglade/glade-2.0.dtd"
FILES_${PN}-dev += "${bindir}/libglade-convert"
#RDEPENDS_${PN} = "${PN}-data"
