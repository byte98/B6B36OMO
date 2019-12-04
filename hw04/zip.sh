echo -n "Removing old archive..."
rm -f -r ./hw04.tar*
echo "DONE"
echo -n "Creating tar..."
tar -cvf hw04.tar ./src/main/java/cz/cvut/k36/omo/hw/hw04/Homework4.java > /dev/null
echo "DONE"
echo -n "Creating bzip2..."
bzip2 hw04.tar
echo "DONE"
echo -n "Archive "
echo -n "successfully"
echo " created!"
