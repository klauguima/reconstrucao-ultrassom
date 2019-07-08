## PARAMS
param (
   [string]$hFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\H-teste.txt",
   [string]$gFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\g-teste2.txt"
)

Import-Module -Force '.\classes\TextToImage.psm1'
Import-Module -Force '.\classes\MatrixUtil.psm1'
Import-Module -Force '.\classes\ImageCreator.psm1'

$textToImage = Get-TextToImage $hFilePath $gFilePath
$textToImage.main()

Write-Output "Tudo certo"