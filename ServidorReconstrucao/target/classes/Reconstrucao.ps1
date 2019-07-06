## VARIABLES
$hFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\H-1.txt"
$gFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\g-1.txt"
$testeFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\teste.txt"

[System.Collections.ArrayList]$arrValuesG=@{}

## FUNCTIONS
function readHFile {
    foreach($line in [System.IO.File]::ReadLines($testeFilePath)) {
        $elements=$line.split(",")
        $arrValuesG.Add($elements) | Out-Null
    }
}

readHFile
Write-Output $arrValuesG
Write-Output "Tudo certo"