DESCRIPTION = "EETI eGalaxy USB User daemon"

LICENSE = "CLOSED"

FILEEXTRAPATHS_prepend := "${THISDIR}/files/:"

SRC_URI += "file://eGTouchD"
SRC_URI += "file://eGTouchL.ini"
SRC_URI += "file://GetEvent.c"
SRC_URI += "file://eGTouch.service"

S = "${WORKDIR}"

do_compile() {
	${CC} -O2 -Wall -o GetEvent GetEvent.c
}

do_install() {
	install -v -d ${D}/usr/bin
	install -v -d ${D}/etc
	install -m 755 eGTouchD ${D}/usr/bin
	install -v -d ${D}/usr/sbin
	install -m 755 GetEvent ${D}/usr/sbin
	install -m 644 eGTouchL.ini ${D}/etc

	install -m 0755 -d ${D}${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/eGTouch.service ${D}${systemd_unitdir}/system/
}


SYSTEMD_SERVICE_${PN} = "eGTouch.service"

inherit systemd

PACKAGE_ARCH_mx6 = "${MACHINE_ARCH}"

