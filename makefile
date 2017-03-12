#Package details
NAME = simple-database-app
VERSION = 1.0.0
PACKAGE_NAME = $(NAME)-$(VERSION)

#Directories
OUT_DIR = lib
DIST_DIR = dist
SRC_DIR = src
BIN_DIR = bin

JCC = javac
JFLAGS = -g -d $(OUT_DIR)
MKDIR_P = mkdir -p

.PHONY: directories, clean

#Compile all program and make executable file
default: directories all
	cd $(OUT_DIR) && jar cmf ../manifest.mf ../$(DIST_DIR)/$(PACKAGE_NAME)/$(PACKAGE_NAME).jar .
	cp dependencies/sqlite* $(DIST_DIR)/$(PACKAGE_NAME)/
	cp $(BIN_DIR)/* $(DIST_DIR)/$(PACKAGE_NAME)/
	chmod +x $(DIST_DIR)/$(PACKAGE_NAME)/*.sh


#Compile all program sources
all:
	$(JCC) $(JFLAGS) $(SRC_DIR)/**/*

#Create required directories
directories:
	${MKDIR_P} $(OUT_DIR)
	${MKDIR_P} $(DIST_DIR)/$(PACKAGE_NAME)

#Clean folders produced by make
clean:
	rm -rf $(OUT_DIR) $(DIST_DIR)