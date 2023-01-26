echo '----------------------------------'
echo '| Starting to clone stuffs needed |'
echo '----------------------------------'

echo '--------------------'
echo '| Cloning Audio HALs |'
echo '--------------------'
rm -rf hardware/qcom-caf/msm8998/audio
git clone https://github.com/wizardprjkt/hardware_qcom-caf_msm8998_audios -b x hardware/qcom-caf/msm8998/audio

echo '--------------------'
echo '| Cloning Display HALs |'
echo '--------------------'
rm -rf hardware/qcom-caf/msm8998/display
git clone https://github.com/wizardprjkt/hardware_qcom-caf_msm8998_display -b 13x hardware/qcom-caf/msm8998/display

echo '--------------------'
echo '| Cloning Media HALs |'
echo '--------------------'
rm -rf hardware/qcom-caf/msm8998/media
git clone https://github.com/wizardprjkt/hardware_qcom-caf_msm8998_media -b 13x hardware/qcom-caf/msm8998/media

echo '--------------------'
echo '| Cloning ih8sn HALs |'
echo '--------------------'
rm -rf vendor/ih8sn
git clone https://github.com/Terminator-J/vendor_ih8sn -b 12.1-test vendor/ih8sn

echo '-------------------------'
echo '| Cloning all stuffs success |'
echo '-------------------------'
