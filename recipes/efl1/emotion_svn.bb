DESCRIPTION = "The Enlightenment multimedia library"
LICENSE = "MIT BSD"
# we no longer build the libxine backend, since the gstreamer backend seems more promising
DEPENDS = "eet evas ecore edje gstreamer gst-plugins-base"
PV = "0.1.0.042+svnr${SRCREV}"
PR = "r3"

inherit efl

EXTRA_OECONF = "--disable-xine --enable-gstreamer --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

PACKAGES =+ "emotion-backend-gstreamer"
FILES_emotion-backend-gstreamer = "${libdir}/emotion/*.so"
RRECOMMENDS_${PN} = "emotion-backend-gstreamer"


do_configure_append() {
	for i in $(find ${WORKDIR}/emotion -name 'Makefile'); do 
		sed -i -e s:/usr/bin/edje_cc:${STAGING_DIR}/${BUILD_SYS}/usr/bin/edje_cc: \
			${i}
	done
}
