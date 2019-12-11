# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@bitbucket.org/mindswteam/elk-standalone-home.git;protocol=ssh;branch=develop"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "ed3ba53ab60f385beda4940ade713bbcd945dd93"

UDATA_DIR = "/udata"

MIND_HOME_DIR = "/home/mind"
S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${MIND_HOME_DIR}
    install -d ${D}${UDATA_DIR}
    cp -r ${S}/config_files ${D}${MIND_HOME_DIR}

    install -d ${D}${bindir}
    install -m 0755 ${S}/scripts/connect-midi-apps ${D}${bindir}
}

FILES_${PN} += "${MIND_HOME_DIR}"
FILES_${PN} += "${MIND_HOME_DIR}/*"
FILES_${PN} += "${UDATA_DIR}"
FILES_${PN} += "${bindir}/connect-midi-apps"