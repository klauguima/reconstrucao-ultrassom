[System.Collections.ArrayList]$matrixA = @{}
[System.Collections.ArrayList]$matrixB = @{}

[System.Collections.ArrayList]$matrix1 = @{}
[System.Collections.ArrayList]$matrix2 = @{}
[System.Collections.ArrayList]$matrix3 = @{}
#for($i = 1; $i -le 3; $i++) {
#    $matrix.Add($i) | Out-Null
#}
#for($i = 0; $i -le 10; $i++) {
#    $matrixA.Add($matrix) | Out-Null
#    $matrixB.Add($matrix) | Out-Null
#}
$matrix1.Add(1) | Out-Null
$matrix1.Add(2) | Out-Null
$matrix1.Add(3) | Out-Null
$matrixA.Add($matrix1) | Out-Null

$matrix2.Add(4) | Out-Null
$matrix2.Add(5) | Out-Null
$matrix2.Add(6) | Out-Null
$matrixA.Add($matrix2) | Out-Null

$matrix3.Add(7) | Out-Null
$matrix3.Add(8) | Out-Null
$matrix3.Add(9) | Out-Null
$matrixA.Add($matrix3) | Out-Null

$matrixB.Add($matrix1) | Out-Null
$matrixB.Add($matrix2) | Out-Null
$matrixB.Add($matrix3) | Out-Null


Import-Module -Force '.\classes\MatrixUtil.psm1'

$matrixUtil = Get-MatrixUtil
$resultMatrix = $matrixUtil.multiply($matrixA, $matrixB)
$matrixUtil.display($resultMatrix);