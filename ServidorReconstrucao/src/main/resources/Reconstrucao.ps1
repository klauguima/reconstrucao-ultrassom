## PARAMS
param (
   [string]$hFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\H-teste.txt",
   [string]$gFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\g-teste2.txt",
   [string]$outputImagePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\img1.bmp"
)

Add-Type -Assembly System.Drawing
Import-Module -Force "$($PSScriptRoot)\classes\TextToImage.psm1"
Import-Module -Force "$($PSScriptRoot)\classes\MatrixUtil.psm1"
Import-Module -Force "$($PSScriptRoot)\classes\ImageCreator.psm1"

$textToImage = Get-TextToImage $hFilePath $gFilePath $outputImagePath
$textToImage.main()

Write-Output "Tudo certo"