set ESDIR=%CD%

xcopy /Y /E src\*.java ..\src\minecraft\net\minecraft\src

cd ..
cmd /C recompile.bat
cd %ESDIR%
