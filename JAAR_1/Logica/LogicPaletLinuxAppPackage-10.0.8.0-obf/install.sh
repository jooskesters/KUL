#!/bin/bash


SRC_DIR_PATH="$(dirname "${BASH_SOURCE[0]}")"

INSTALLATION_DIRECTORY=~/.LogicPalet

SETTINGS_FILE_PATH=~/.local/share/LogicPalet/LogicPaletSettings.Xml

DIRECTORY_FOR_LAUNCHERS=~/.local/share/applications

MY_ERROR_COUNT=0


function scanObsoleteLaunchers {
  local errors=0
  local myList=$(find ~/ -name '*LogicPaletLauncher*.desktop' 2> /dev/null)   #Does not descend directories on other filesystems?
  IFS=$'\n'    # Very important! Sets the Internal Field Separator.
  local wordCount=0
  for word in $myList; do
    let wordCount++
  done
  if [ $wordCount -gt 0 ]
  then
  echo      
  echo "The following $wordCount files might launch an obsolete version of LogicPalet:"
    for word in $myList; do
      echo "   $word"
    done 
    echo -n 'Do you want to delete these app launchers (recommended)? [y/N]'
    read answer
    # if [ $answer = Y ]
    if [[ "$answer" == [yY][eE][sS] || "$answer" == [yY] ]]  # Double brackets because pattern matching. Double quotes: else problem if only enter pressed.
    then
      errors=0
      for word in $myList; do
        rm $word
        let "errors = $errors + $?"
      done
      if [ $errors -lt 1 ]
      then 
        echo Heads up! These files are now removed.
      fi
    fi
  else
    echo 'No obsolete launchers for LogicPalet found.'
  fi
  unset IFS   # Very important! Sets the Internal Field Separator back to the default.

}

function dialogScanObsoleteLaunchers {

  echo 'If you ever used LogicPalet version 10.0.3 or lower on this system, it might contain obsolete app launchers for LogicPalet.'
  echo -n 'Do you want to scan your system for these launchers, so that they can be removed? [y/N]'
  read answer
  if [[ "$answer" == [yY][eE][sS] || "$answer" == [yY] ]]
  then
    echo Scan started. Please wait...
    scanObsoleteLaunchers  
  else
    echo No scanning.
fi

}


chmod 755 $SRC_DIR_PATH/bin/SPASS.exe
let "MY_ERROR_COUNT += $?"
chmod 755 $SRC_DIR_PATH/bin/gidl.exe
let "MY_ERROR_COUNT += $?"
chmod 755 $SRC_DIR_PATH/bin/minisatid.exe
let "MY_ERROR_COUNT += $?"
chmod 755 $SRC_DIR_PATH/bin/translate.exe
let "MY_ERROR_COUNT += $?"
chmod 755 $SRC_DIR_PATH/bin/st.sh
let "MY_ERROR_COUNT += $?"


dialogScanObsoleteLaunchers

mkdir --parents $INSTALLATION_DIRECTORY
rm --recursive $INSTALLATION_DIRECTORY  # 2> /dev/null #if stderr discarded it hangs if some file is read-only for the owner!!!
mkdir --parents $INSTALLATION_DIRECTORY
cp --recursive $SRC_DIR_PATH/bin $INSTALLATION_DIRECTORY
let "MY_ERROR_COUNT += $?"

MYLAUNCHER=$"
[Desktop Entry]
Encoding=UTF-8
Version=1.0
Name=LogicPalet
Comment=LogicPaletLinux for runtime DotNet Core
Exec=$INSTALLATION_DIRECTORY/bin/st.sh
Icon=$INSTALLATION_DIRECTORY/bin/LogicPaletIcon.ico
Terminal=false
Type=Application
StartupWMClass=LogicPaletLinux
StartupNotify=true
"

mkdir --parents $DIRECTORY_FOR_LAUNCHERS
echo  "$MYLAUNCHER" > $DIRECTORY_FOR_LAUNCHERS/LogicPalet.desktop
let "MY_ERROR_COUNT += $?"
chmod 755 $DIRECTORY_FOR_LAUNCHERS/LogicPalet.desktop
echo  "$MYLAUNCHER" > ~/LogicPalet.desktop
let "MY_ERROR_COUNT += $?"
chmod 755 ~/LogicPalet.desktop

# echo "$MYLAUNCHER" > ~/LogicPaletLauncher.desktop  # For testing only.
# echo "$MYLAUNCHER" > ~/LogicPaletLauncherMMM.desktop  # For testing only.

if [ -e $SETTINGS_FILE_PATH ]
then
  echo
  echo -n 'Do you want to keep your most recent settings for LogicPalet? [y/N]'
  read answer
  if [[ "$answer" == [yY][eE][sS] || "$answer" == [yY] ]]
  then
    touch $SETTINGS_FILE_PATH  # Sets all time stamps of file equal to now. If file does not exist, then it is created (if directory exists).
  else
    rm $SETTINGS_FILE_PATH
  fi
fi

if [ $MY_ERROR_COUNT -lt 1 ]
then
  echo 
  echo -n '!!!!!! You can run LogicPalet by double clicking on the file LogicPalet or LogicPalet.desktop in your home directory, or by using the applications menu. Run it now? [y/N]'
  read answer
  if [[ "$answer" == [yY][eE][sS] || "$answer" == [yY] ]]
  then
    $INSTALLATION_DIRECTORY/bin/st.sh
  fi
else
  echo "The installation did NOT succeed: $MY_ERROR_COUNT fatal errors."
fi



