JCC = javac
OUT_DIR = lib
JFLAGS = -g -d $(OUT_DIR)
SRC_DIR = src/
PACKAGE_NAME = simple-database
MKDIR_P = mkdir -p

.PHONY: directories, clean

default: directories all
	cd $(OUT_DIR) && jar cmf ../manifest.mf ../$(PACKAGE_NAME).jar .

all:
	$(JCC) $(JFLAGS) $(SRC_DIR)**/*

directories:
	${MKDIR_P} $(OUT_DIR)

clean:
	rm -rf $(OUT_DIR) $(PACKAGE_NAME).jar