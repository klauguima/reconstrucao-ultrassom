$hFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\H-1.txt"
$gFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\g-1.txt"
$testeFilePath = "C:\Users\Kleber\Documents\projetos\claudia-faculdade\Imagem\teste.txt"

[System.Collections.ArrayList]$arrValuesG=@{}
foreach($line in [System.IO.File]::ReadLines($hFilePath)) {
    $elements=$line.split(",")
    $arrValuesG.Add($elements) | Out-Null
}

Write-Output $arrValuesG[1000][300]
Write-Output "Tudo certo"