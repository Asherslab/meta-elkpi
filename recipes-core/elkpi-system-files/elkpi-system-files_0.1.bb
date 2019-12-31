SUMMARY = "System files and startup sripts for the Elk Pi"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://load-drivers \
    file://connect-midi-apps \
    file://change-udata-perms \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/load-drivers ${D}${bindir}
    install -m 0755 ${WORKDIR}/connect-midi-apps ${D}${bindir}
    install -m 0755 ${WORKDIR}/change-udata-perms ${D}${bindir}
}

FILES_${PN} = "${bindir}*"

RDEPENDS_${PN} = "bash"