# Provides the i.MX6 Tinto project common settings

require conf/machine/include/imx-base.inc
require conf/machine/include/tune-cortexa9.inc

SERIAL_CONSOLES = "115200;ttymxc2"
UBOOT_ENTRYPOINT_mx6  = "0x12000000"
KERNEL_DEVICETREE = "imx6dl-bobo9.dtb \
		     imx6dl-bobo12.dtb"

MACHINE_FEATURES += " wifi bluetooth"

IMAGE_INSTALL_append += " eeti"
CORE_IMAGE_EXTRA_INSTALL += " u-boot-fw-utils"

KERNEL_MODULE_AUTOLOAD ?= ""

