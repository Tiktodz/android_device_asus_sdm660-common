LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := \
    AmbientSensePrebuilt \
    Aperture \
    AmbientStreaming \
    arcore \
    Camera2 \
    CarrierLocation \
    CarrierMetrics \
    ConnMO \
    ConnMetrics \
    DCMO \
    DevicePolicyPrebuilt \
    DiagnosticsToolPrebuilt \
    DMService \
    Drive \
    GCS \
    GoogleCamera \
    Maps \
    Music \
    MyVerizonServices \
    OBDM_Permissions \
    obdm_stub \
    OdadPrebuilt \
    OemDmTrigger \
    OPScreenRecord \
    Ornament \
    PixelLiveWallpaperPrebuilt \
    PlayAutoInstallConfig \
    PrebuiltGmail \
    RecorderPrebuilt \
    SafetyHubPrebuilt \
    SCONE \
    ScribePrebuilt \
    Showcase \
    Snap \
    Snap2 \
    SnapdragonCamera \
    SoundAmplifierPrebuilt \
    SprintDM \
    SprintHM \
    USCCDM \
    Videos \
    VZWAPNLib \
    VzwOmaTrigger \
    YouTube \
    YouTubeMusicPrebuilt
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
