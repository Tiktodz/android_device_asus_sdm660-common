# Build
rm -rf build/make
git clone https://github.com/Tiktodz/android_build build/make

# KSU
#rm -rf kernel/asus/sdm660
git clone --recursive https://github.com/Tiktodz/android_kernel_asus_sdm636 -b 10 kernel/asus/sdm660

# LiveDisplay
rm -rf hardware/lineage/livedisplay
git clone https://github.com/LineageOS/android_hardware_lineage_livedisplay -b lineage-17.1 hardware/lineage/livedisplay

git clone https://github.com/Tiktodz/device_asus_X00TD -b nad device/asus/X00TD

git clone https://github.com/Tiktodz/android_vendor_asus vendor/asus

cd kernel/asus/sdm660/KernelSU && rm -rf manager docs userspace website scripts && cd ../../../..
