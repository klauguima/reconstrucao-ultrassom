## import classes
#Using module ".\MatrixUtil.psm1"

## PARAMS
param (
   [string]$hFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\H-teste.txt",
   [string]$gFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\g-teste.txt"
)

Import-Module -Force '.\classes\MatrixUtil.psm1'

## VARIABLES
[System.Collections.ArrayList]$arrValuesG=@{}
[System.Collections.ArrayList]$arrValuesH=@{}

## FUNCTIONS
function readHFile {
    foreach($line in [System.IO.File]::ReadLines($hFilePath)) {
        $arrValuesH.Add($line.split(",")) | Out-Null
    }
    Write-Output "Arquivo H lido"
}
function readGFile {
    foreach($line in [System.IO.File]::ReadLines($gFilePath)) {
        $arrValuesG.Add($line.split(",")) | Out-Null
    }
    Write-Output "Arquivo G lido"
}
function cgne() {
    [System.Collections.ArrayList]$fMatrix=@{}

    foreach($line in $arrValuesG) {
        [System.Collections.ArrayList]$zeroArray=@{}
        $zeroArray.Add(0) | Out-Null
        $fMatrix.Add($zeroArray) | Out-Null
    }
}
function main {
    readGFile
    readHFile
    cgne
}

#main

$matrixUtil = Get-MatrixUtil
Write-Output "Tudo certo"