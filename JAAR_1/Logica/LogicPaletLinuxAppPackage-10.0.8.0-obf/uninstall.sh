#!/bin/bash


INSTALLATION_DIRECTORY=~/.LogicPalet

SETTINGS_FILE_DIRECTORY=~/.local/share/LogicPalet

DIRECTORY_FOR_LAUNCHERS=~/.local/share/applications

echo -n 'Do you want to REMOVE LogicPalet from your system? [y/N]'
read answer 
if ! [[ "$answer" == [yY][eE][sS] || "$answer" == [yY] ]]  # Double brackets because pattern matching. Double quotes: else problem if only enter pressed.
then
  exit
fi

rm --recursive $INSTALLATION_DIRECTORY/bin

rm --recursive -i $INSTALLATION_DIRECTORY  # -i means interactive: asks permission.

if [ -e $SETTINGS_FILE_DIRECTORY/LogicPaletSettings.Xml ]
then
  rm $SETTINGS_FILE_DIRECTORY/LogicPaletSettings.Xml
fi

if [ -e $SETTINGS_FILE_DIRECTORY ]
then
  rm --recursive -i $SETTINGS_FILE_DIRECTORY
fi

if [ -e $DIRECTORY_FOR_LAUNCHERS/LogicPalet.desktop ]
then
  rm $DIRECTORY_FOR_LAUNCHERS/LogicPalet.desktop
fi

# find ~/ -name '*LogicPalet*.desktop' -delete
echo 'Scanning your system for LogicPalet app launchers. Please wait...'
myList=$(find ~/ -name '*LogicPalet*.desktop' 2> /dev/null)     #Does not descend directories on other filesystems?
for word in $myList; do
  rm -i $word
done

echo Done

