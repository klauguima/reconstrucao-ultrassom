[System.Collections.ArrayList]$matrixA = @{}
[System.Collections.ArrayList]$matrixB = @{}

[System.Collections.ArrayList]$matrix = @{}
for($i = 1; $i -le 3; $i++) {
    $matrix.Add($i)
}
#for($i = 0; $i -le 10; $i++) {
#    $matrixA.Add($matrix) | Out-Null
#    $matrixB.Add($matrix) | Out-Null
#}
$matrixA.Add($matrix) | Out-Null
$matrixA.Add($matrix) | Out-Null
$matrixA.Add($matrix) | Out-Null

$matrixB.Add($matrix) | Out-Null
$matrixB.Add($matrix) | Out-Null
$matrixB.Add($matrix) | Out-Null


Import-Module -Force '.\classes\MatrixUtil.psm1'

$matrixUtil = Get-MatrixUtil
$matrixUtil.multiply($matrixA, $matrixB)

#Write-Output $matrixA