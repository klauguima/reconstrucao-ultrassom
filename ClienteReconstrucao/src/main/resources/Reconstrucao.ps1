## PARAMS
param (

   [string]$hFilePath = "C:\Users\Klaus\Documents\Setimo periodo 2019.2\DIS\imagens\H-1.txt",
   [string]$gFilePath = "C:\Users\Klaus\Documents\Setimo periodo 2019.2\DIS\imagens\g-1.txt",
   [string]$outputImagePath = "C:\Users\Klaus\Documents\Setimo periodo 2019.2\DIS\imagens\img1.bmp"
)

Add-Type -Assembly System.Drawing
Import-Module -Force "$($PSScriptRoot)\classes\TextToImage.psm1"
Import-Module -Force "$($PSScriptRoot)\classes\MatrixUtil.psm1"
Import-Module -Force "$($PSScriptRoot)\classes\ImageCreator.psm1"

$textToImage = Get-TextToImage $hFilePath $gFilePath $outputImagePath
#$textToImage.main()
$textToImage.aprensentaImagemTeste()

Write-Output "Tudo certo"