LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := AndroidAutoStubPrebuilt AppDirectedSMSService ConnMO DCMO
LOCAL_OVERRIDES_PACKAGES += DMService GCS GoogleCamera MaestroPrebuilt MyVerizonServices
LOCAL_OVERRIDES_PACKAGES += SafetyHubPrebuilt SCONE ScribePrebuilt Showcase
LOCAL_OVERRIDES_PACKAGES += SoundAmplifierPrebuilt TurboPrebuilt Tycho VZWAPNLib
LOCAL_OVERRIDES_PACKAGES += VzwOmaTrigger obdm_stub arcore RecorderPrebuilt
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := platform
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
