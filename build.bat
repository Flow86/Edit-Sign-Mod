set ESDIR=%CD%

xcopy /Y /E client\*.java ..\src\minecraft\net\minecraft\src
xcopy /Y /E common\*.java ..\src\minecraft\net\minecraft\src

IF EXIST ..\src\minecraft_server xcopy /Y /E server\*.java ..\src\minecraft_server\net\minecraft\src
IF EXIST ..\src\minecraft_server xcopy /Y /E common\*.java ..\src\minecraft_server\net\minecraft\src

cd ..
cmd /C recompile.bat
cd %ESDIR%
