#rm -rf kernel/asus/sdm660
git clone --recursive https://github.com/Tiktodz/android_kernel_asus_sdm636 -b codelinaro-hmp kernel/asus/sdm660

rm -rf hardware/qcom-caf/msm8998/audio
git clone https://github.com/aslenolineagestuff/android_hardware_qcom_audio -b lineage-17.1-caf-msm8998 hardware/qcom-caf/msm8998/audio
