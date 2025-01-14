@echo off
rem !!!!! Merging HTML reports from different directories into a single file !!!!!

rem Spécifier le fichier de sortie
set outputFile=target\reports\merged-report.html

rem Créer l'en-tête du fichier HTML
echo ^<html^> > %outputFile%
echo ^<head^> >> %outputFile%
echo ^<title^>Merged Test Report^</title^> >> %outputFile%
echo ^</head^> >> %outputFile%
echo ^<body^> >> %outputFile%
echo ^<h1^>Merged Test Report^</h1^> >> %outputFile%

rem Boucle à travers tous les fichiers HTML dans les sous-répertoires et ajoute leur contenu au rapport final
for /R target\reports %%f in (*.html) do (
    rem Ajouter le contenu de chaque fichier HTML au fichier de sortie
    rem Ignorer la première ligne (la déclaration <html>) et le pied de page (</html>)
    for /f "skip=1 tokens=*" %%a in ('type "%%f" ^| findstr /v /c:"<html>" ^| findstr /v /c:"</html>"') do (
        remecho %%a >> %outputFile%
    )
)

rem Ajouter le pied de page HTML
remecho ^</body^> >> %outputFile%
remecho ^</html^> >> %outputFile%

echo Reports merged successfully.
pause
