## PARAMS
param (
   [string]$hFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\H-teste.txt",
   [string]$gFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\g-teste2.txt",
   [string]$outputImagePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\img1.bmp"
)

Import-Module -Force '.\classes\TextToImage.psm1'
Import-Module -Force '.\classes\MatrixUtil.psm1'
Import-Module -Force '.\classes\ImageCreator.psm1'

$textToImage = Get-TextToImage $hFilePath $gFilePath $outputImagePath
$textToImage.main()

Write-Output "Tudo certo"