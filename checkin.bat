@ECHO OFF

rsync -arv --existing ../src/minecraft/net/minecraft/src/ ./client/
rsync -arv --existing ../src/minecraft/net/minecraft/src/ ./common/

pause

rsync -arv --existing ../src/minecraft_server/net/minecraft/src/ ./server/
rsync -arv --existing ../src/minecraft_server/net/minecraft/src/ ./common/

PAUSE
